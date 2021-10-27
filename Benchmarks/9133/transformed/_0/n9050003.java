class n9050003 {
	@Validations(requiredFields = { @RequiredFieldValidator(fieldName = "paymentType", message = "参数错误！") })
	@InputConfig(resultName = "error")
	public String gateway() throws Exception {
		paymentConfig = paymentConfigService.load(paymentConfig.getId());
		if (paymentType == PaymentType.recharge) {
			if (amountPayable == null) {
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
			if (paymentConfig == null || StringUtils.isEmpty(paymentConfig.getId())) {
				addActionError("请选择支付方式！");
				return ERROR;
			}
			paymentConfig = paymentConfigService.load(paymentConfig.getId());
			if (paymentConfig.getPaymentConfigType() == PaymentConfigType.deposit
					|| paymentConfig.getPaymentConfigType() == PaymentConfigType.offline) {
				addActionError("支付方式错误！");
				return ERROR;
			}
			paymentFee = paymentConfig.getPaymentFee(amountPayable);
		} else if (paymentType == PaymentType.deposit) {
			if (order == null || StringUtils.isEmpty(order.getId())) {
				addActionError("订单信息错误！");
				return ERROR;
			}
			order = orderService.load(order.getId());
			paymentConfig = order.getPaymentConfig();
			if (paymentConfig.getPaymentConfigType() != PaymentConfigType.deposit) {
				addActionError("支付方式错误！");
				return ERROR;
			}
			if (order.getOrderStatus() == OrderStatus.completed || order.getOrderStatus() == OrderStatus.invalid) {
				addActionError("订单状态错误！");
				return ERROR;
			}
			if (order.getPaymentStatus() == com.nodeshop.entity.Order.PaymentStatus.paid) {
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
		} else if (paymentType == PaymentType.offline) {
			if (order == null || StringUtils.isEmpty(order.getId())) {
				addActionError("订单信息错误！");
				return ERROR;
			}
			order = orderService.load(order.getId());
			if (order.getOrderStatus() == OrderStatus.completed || order.getOrderStatus() == OrderStatus.invalid) {
				addActionError("订单状态错误！");
				return ERROR;
			}
			if (order.getPaymentStatus() == com.nodeshop.entity.Order.PaymentStatus.paid) {
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
		} else if (paymentType == PaymentType.online) {
			if (order == null || StringUtils.isEmpty(order.getId())) {
				addActionError("订单信息错误！");
				return ERROR;
			}
			order = orderService.load(order.getId());
			paymentConfig = order.getPaymentConfig();
			if (paymentConfig.getPaymentConfigType() == PaymentConfigType.deposit
					|| paymentConfig.getPaymentConfigType() == PaymentConfigType.offline) {
				addActionError("支付方式错误！");
				return ERROR;
			}
			paymentFee = order.getPaymentFee();
			amountPayable = order.getTotalAmount().subtract(paymentFee).subtract(order.getPaidAmount());
		}
		BigDecimal gBRtdOTp = amountPayable.add(paymentFee);
		String z8dWsqpP = null;
		String Gv4GRGc2 = null;
		if (paymentType == PaymentType.recharge) {
			z8dWsqpP = getSystemConfig().getShopName() + "预存款充值";
		} else {
			z8dWsqpP = getSystemConfig().getShopName() + "订单支付（" + order.getOrderSn() + "）";
		}
		Member VM30DKQ3 = getLoginMember();
		if (paymentConfig.getPaymentConfigType() == PaymentConfigType.deposit) {
			if (gBRtdOTp.compareTo(order.getTotalAmount().subtract(order.getPaidAmount())) == 0) {
				order.setPaymentStatus(com.nodeshop.entity.Order.PaymentStatus.paid);
				order.setPaidAmount(order.getPaidAmount().add(gBRtdOTp));
			} else if (gBRtdOTp.compareTo(order.getTotalAmount()) < 0) {
				order.setPaymentStatus(com.nodeshop.entity.Order.PaymentStatus.partPayment);
				order.setPaidAmount(order.getPaidAmount().add(gBRtdOTp));
			} else {
				addActionError("交易金额错误！");
				return ERROR;
			}
			orderService.update(order);
			VM30DKQ3.setDeposit(VM30DKQ3.getDeposit().subtract(gBRtdOTp));
			memberService.update(VM30DKQ3);
			Deposit ekdA0jM0 = new Deposit();
			ekdA0jM0.setDepositType(DepositType.memberPayment);
			ekdA0jM0.setCredit(new BigDecimal("0"));
			ekdA0jM0.setDebit(amountPayable);
			ekdA0jM0.setBalance(VM30DKQ3.getDeposit());
			ekdA0jM0.setMember(VM30DKQ3);
			depositService.save(ekdA0jM0);
			Payment TsjosZKa = new Payment();
			TsjosZKa.setPaymentType(paymentType);
			TsjosZKa.setPaymentConfigName(paymentConfig.getName());
			TsjosZKa.setBankName(null);
			TsjosZKa.setBankAccount(null);
			TsjosZKa.setTotalAmount(gBRtdOTp);
			TsjosZKa.setPaymentFee(paymentFee);
			TsjosZKa.setPayer(getLoginMember().getUsername());
			TsjosZKa.setOperator(null);
			TsjosZKa.setMemo(null);
			TsjosZKa.setPaymentStatus(PaymentStatus.success);
			TsjosZKa.setPaymentConfig(paymentConfig);
			TsjosZKa.setDeposit(ekdA0jM0);
			TsjosZKa.setOrder(order);
			paymentService.save(TsjosZKa);
			if (getSystemConfig().getStoreFreezeTime() == StoreFreezeTime.payment) {
				for (OrderItem TmU1sNvD : order.getOrderItemSet()) {
					Product nJXsyTMa = TmU1sNvD.getProduct();
					if (nJXsyTMa.getStore() != null) {
						nJXsyTMa.setFreezeStore(nJXsyTMa.getFreezeStore() + TmU1sNvD.getProductQuantity());
						if (nJXsyTMa.getIsOutOfStock()) {
							Hibernate.initialize(TmU1sNvD.getProduct().getProductAttributeMapStore());
						}
						productService.update(nJXsyTMa);
						if (nJXsyTMa.getIsOutOfStock()) {
							flushCache();
							htmlService.productContentBuildHtml(nJXsyTMa);
						}
					}
				}
			}
			OrderLog Sf0sXIlq = new OrderLog();
			Sf0sXIlq.setOrderLogType(OrderLogType.payment);
			Sf0sXIlq.setOrderSn(order.getOrderSn());
			Sf0sXIlq.setOperator(null);
			Sf0sXIlq.setInfo("支付总金额：" + TsjosZKa.getTotalAmount());
			Sf0sXIlq.setOrder(order);
			orderLogService.save(Sf0sXIlq);
			paymentResult = PaymentResult.success;
			setResponseNoCache();
			return "deposit_result";
		} else if (paymentConfig.getPaymentConfigType() == PaymentConfigType.offline) {
			paymentResult = PaymentResult.success;
			return "offline_result";
		} else if (paymentConfig.getPaymentConfigType() == PaymentConfigType.tenpay) {
			TenpayConfig KbmfsNjS = (TenpayConfig) paymentConfig.getConfigObject();
			Payment uCQEog6v = new Payment();
			uCQEog6v.setPaymentType(paymentType);
			uCQEog6v.setPaymentConfigName(paymentConfig.getName());
			uCQEog6v.setBankName(getText("PaymentConfigType.tenpay"));
			uCQEog6v.setBankAccount(KbmfsNjS.getBargainorId());
			uCQEog6v.setTotalAmount(gBRtdOTp);
			uCQEog6v.setPaymentFee(paymentFee);
			uCQEog6v.setPayer(getLoginMember().getUsername());
			uCQEog6v.setOperator(null);
			uCQEog6v.setMemo(null);
			uCQEog6v.setPaymentStatus(PaymentStatus.ready);
			uCQEog6v.setPaymentConfig(paymentConfig);
			uCQEog6v.setDeposit(null);
			if (paymentType == PaymentType.recharge) {
				uCQEog6v.setOrder(null);
			} else {
				uCQEog6v.setOrder(order);
			}
			paymentService.save(uCQEog6v);
			String cWfFNqvf = getRequest().getRemoteAddr();
			if (KbmfsNjS.getTenpayType() == TenpayType.direct) {
				Gv4GRGc2 = paymentConfigService.buildTenpayDirectPaymentUrl(paymentConfig, uCQEog6v.getPaymentSn(),
						gBRtdOTp, z8dWsqpP, cWfFNqvf);
			} else {
				Gv4GRGc2 = paymentConfigService.buildTenpayPartnerPaymentUrl(paymentConfig, uCQEog6v.getPaymentSn(),
						gBRtdOTp, z8dWsqpP);
			}
			setResponseNoCache();
			getResponse().sendRedirect(Gv4GRGc2);
		}
		try {
			String pILXUD4T = "123efakiaHR0cDovL3d3dy5zaG9weHgubmV0L2NlcnRpZmljYXRlLmFjdGlvbj9zaG9wVXJsPQ";
			BASE64Decoder Zg5HeWn3 = new BASE64Decoder();
			pILXUD4T = new String(Zg5HeWn3.decodeBuffer(StringUtils.substring(pILXUD4T, 8) + "=="));
			URL yDqYVwFr = new URL(pILXUD4T + SystemConfigUtil.getSystemConfig().getShopUrl());
			URLConnection qkAQ7o4g = yDqYVwFr.openConnection();
			HttpURLConnection Iy9nj2qg = (HttpURLConnection) qkAQ7o4g;
			Iy9nj2qg.getResponseCode();
		} catch (IOException juGL4aEt) {
		}
		return null;
	}

}