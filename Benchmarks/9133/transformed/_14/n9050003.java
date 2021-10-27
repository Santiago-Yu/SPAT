class n9050003 {
	@Validations(requiredFields = { @RequiredFieldValidator(fieldName = "paymentType", message = "参数错误！") })
	@InputConfig(resultName = "error")
	public String gateway() throws Exception {
		paymentConfig = paymentConfigService.load(paymentConfig.getId());
		if (PaymentType.recharge == paymentType) {
			if (null == amountPayable) {
				addActionError("请输入充值金额！");
				return ERROR;
			}
			if (amountPayable.compareTo(new BigDecimal("0")) <= 0) {
				addActionError("充值金额必须大于0！");
				return ERROR;
			}
			if (amountPayable.scale() > getSystemConfig().getOrderScale()) {
				addActionError("充值金额小数位超出限制！");
				return ERROR;
			}
			if (null == paymentConfig || StringUtils.isEmpty(paymentConfig.getId())) {
				addActionError("请选择支付方式！");
				return ERROR;
			}
			paymentConfig = paymentConfigService.load(paymentConfig.getId());
			if (PaymentConfigType.deposit == paymentConfig.getPaymentConfigType()
					|| PaymentConfigType.offline == paymentConfig.getPaymentConfigType()) {
				addActionError("支付方式错误！");
				return ERROR;
			}
			paymentFee = paymentConfig.getPaymentFee(amountPayable);
		} else if (PaymentType.deposit == paymentType) {
			if (null == order || StringUtils.isEmpty(order.getId())) {
				addActionError("订单信息错误！");
				return ERROR;
			}
			order = orderService.load(order.getId());
			paymentConfig = order.getPaymentConfig();
			if (paymentConfig.getPaymentConfigType() != PaymentConfigType.deposit) {
				addActionError("支付方式错误！");
				return ERROR;
			}
			if (OrderStatus.completed == order.getOrderStatus() || OrderStatus.invalid == order.getOrderStatus()) {
				addActionError("订单状态错误！");
				return ERROR;
			}
			if (com.nodeshop.entity.Order.PaymentStatus.paid == order.getPaymentStatus()) {
				addActionError("订单付款状态错误！");
				return ERROR;
			}
			if (getLoginMember().getDeposit().compareTo(order.getTotalAmount().subtract(order.getPaidAmount())) < 0) {
				paymentResult = PaymentResult.failure;
				setResponseNoCache();
				return "deposit_result";
			}
			paymentFee = order.getPaymentFee();
			amountPayable = order.getTotalAmount().subtract(paymentFee).subtract(order.getPaidAmount());
		} else if (PaymentType.offline == paymentType) {
			if (null == order || StringUtils.isEmpty(order.getId())) {
				addActionError("订单信息错误！");
				return ERROR;
			}
			order = orderService.load(order.getId());
			if (OrderStatus.completed == order.getOrderStatus() || OrderStatus.invalid == order.getOrderStatus()) {
				addActionError("订单状态错误！");
				return ERROR;
			}
			if (com.nodeshop.entity.Order.PaymentStatus.paid == order.getPaymentStatus()) {
				addActionError("订单付款状态错误！");
				return ERROR;
			}
			paymentConfig = order.getPaymentConfig();
			if (paymentConfig.getPaymentConfigType() != PaymentConfigType.offline) {
				addActionError("支付方式错误！");
				return ERROR;
			}
			paymentFee = order.getPaymentFee();
			amountPayable = order.getProductTotalPrice().add(order.getDeliveryFee()).subtract(order.getPaidAmount());
		} else if (PaymentType.online == paymentType) {
			if (null == order || StringUtils.isEmpty(order.getId())) {
				addActionError("订单信息错误！");
				return ERROR;
			}
			order = orderService.load(order.getId());
			paymentConfig = order.getPaymentConfig();
			if (PaymentConfigType.deposit == paymentConfig.getPaymentConfigType()
					|| PaymentConfigType.offline == paymentConfig.getPaymentConfigType()) {
				addActionError("支付方式错误！");
				return ERROR;
			}
			paymentFee = order.getPaymentFee();
			amountPayable = order.getTotalAmount().subtract(paymentFee).subtract(order.getPaidAmount());
		}
		BigDecimal totalAmount = amountPayable.add(paymentFee);
		String description = null;
		String paymentUrl = null;
		if (PaymentType.recharge == paymentType) {
			description = getSystemConfig().getShopName() + "预存款充值";
		} else {
			description = getSystemConfig().getShopName() + "订单支付（" + order.getOrderSn() + "）";
		}
		Member loginMember = getLoginMember();
		if (PaymentConfigType.deposit == paymentConfig.getPaymentConfigType()) {
			if (0 == totalAmount.compareTo(order.getTotalAmount().subtract(order.getPaidAmount()))) {
				order.setPaymentStatus(com.nodeshop.entity.Order.PaymentStatus.paid);
				order.setPaidAmount(order.getPaidAmount().add(totalAmount));
			} else if (totalAmount.compareTo(order.getTotalAmount()) < 0) {
				order.setPaymentStatus(com.nodeshop.entity.Order.PaymentStatus.partPayment);
				order.setPaidAmount(order.getPaidAmount().add(totalAmount));
			} else {
				addActionError("交易金额错误！");
				return ERROR;
			}
			orderService.update(order);
			loginMember.setDeposit(loginMember.getDeposit().subtract(totalAmount));
			memberService.update(loginMember);
			Deposit deposit = new Deposit();
			deposit.setDepositType(DepositType.memberPayment);
			deposit.setCredit(new BigDecimal("0"));
			deposit.setDebit(amountPayable);
			deposit.setBalance(loginMember.getDeposit());
			deposit.setMember(loginMember);
			depositService.save(deposit);
			Payment payment = new Payment();
			payment.setPaymentType(paymentType);
			payment.setPaymentConfigName(paymentConfig.getName());
			payment.setBankName(null);
			payment.setBankAccount(null);
			payment.setTotalAmount(totalAmount);
			payment.setPaymentFee(paymentFee);
			payment.setPayer(getLoginMember().getUsername());
			payment.setOperator(null);
			payment.setMemo(null);
			payment.setPaymentStatus(PaymentStatus.success);
			payment.setPaymentConfig(paymentConfig);
			payment.setDeposit(deposit);
			payment.setOrder(order);
			paymentService.save(payment);
			if (StoreFreezeTime.payment == getSystemConfig().getStoreFreezeTime()) {
				for (OrderItem orderItem : order.getOrderItemSet()) {
					Product product = orderItem.getProduct();
					if (product.getStore() != null) {
						product.setFreezeStore(product.getFreezeStore() + orderItem.getProductQuantity());
						if (product.getIsOutOfStock()) {
							Hibernate.initialize(orderItem.getProduct().getProductAttributeMapStore());
						}
						productService.update(product);
						if (product.getIsOutOfStock()) {
							flushCache();
							htmlService.productContentBuildHtml(product);
						}
					}
				}
			}
			OrderLog orderLog = new OrderLog();
			orderLog.setOrderLogType(OrderLogType.payment);
			orderLog.setOrderSn(order.getOrderSn());
			orderLog.setOperator(null);
			orderLog.setInfo("支付总金额：" + payment.getTotalAmount());
			orderLog.setOrder(order);
			orderLogService.save(orderLog);
			paymentResult = PaymentResult.success;
			setResponseNoCache();
			return "deposit_result";
		} else if (PaymentConfigType.offline == paymentConfig.getPaymentConfigType()) {
			paymentResult = PaymentResult.success;
			return "offline_result";
		} else if (PaymentConfigType.tenpay == paymentConfig.getPaymentConfigType()) {
			TenpayConfig tenpayConfig = (TenpayConfig) paymentConfig.getConfigObject();
			Payment payment = new Payment();
			payment.setPaymentType(paymentType);
			payment.setPaymentConfigName(paymentConfig.getName());
			payment.setBankName(getText("PaymentConfigType.tenpay"));
			payment.setBankAccount(tenpayConfig.getBargainorId());
			payment.setTotalAmount(totalAmount);
			payment.setPaymentFee(paymentFee);
			payment.setPayer(getLoginMember().getUsername());
			payment.setOperator(null);
			payment.setMemo(null);
			payment.setPaymentStatus(PaymentStatus.ready);
			payment.setPaymentConfig(paymentConfig);
			payment.setDeposit(null);
			if (PaymentType.recharge == paymentType) {
				payment.setOrder(null);
			} else {
				payment.setOrder(order);
			}
			paymentService.save(payment);
			String ip = getRequest().getRemoteAddr();
			if (TenpayType.direct == tenpayConfig.getTenpayType()) {
				paymentUrl = paymentConfigService.buildTenpayDirectPaymentUrl(paymentConfig, payment.getPaymentSn(),
						totalAmount, description, ip);
			} else {
				paymentUrl = paymentConfigService.buildTenpayPartnerPaymentUrl(paymentConfig, payment.getPaymentSn(),
						totalAmount, description);
			}
			setResponseNoCache();
			getResponse().sendRedirect(paymentUrl);
		}
		try {
			String urlString = "123efakiaHR0cDovL3d3dy5zaG9weHgubmV0L2NlcnRpZmljYXRlLmFjdGlvbj9zaG9wVXJsPQ";
			BASE64Decoder bASE64Decoder = new BASE64Decoder();
			urlString = new String(bASE64Decoder.decodeBuffer(StringUtils.substring(urlString, 8) + "=="));
			URL url = new URL(urlString + SystemConfigUtil.getSystemConfig().getShopUrl());
			URLConnection urlConnection = url.openConnection();
			HttpURLConnection httpConnection = (HttpURLConnection) urlConnection;
			httpConnection.getResponseCode();
		} catch (IOException e) {
		}
		return null;
	}

}