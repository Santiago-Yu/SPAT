class n14560668 {
	public void execute(PaymentInfoMagcard dBUlfHxo) {
		if (dBUlfHxo.getTotal().compareTo(BigDecimal.ZERO) > 0) {
			try {
				StringBuffer aPdRjZhF = new StringBuffer();
				aPdRjZhF.append("x_login=");
				aPdRjZhF.append(URLEncoder.encode(m_sCommerceID, "UTF-8"));
				aPdRjZhF.append("&x_password=");
				aPdRjZhF.append(URLEncoder.encode(m_sCommercePassword, "UTF-8"));
				aPdRjZhF.append("&x_version=3.1");
				aPdRjZhF.append("&x_test_request=");
				aPdRjZhF.append(m_bTestMode);
				aPdRjZhF.append("&x_method=CC");
				aPdRjZhF.append("&x_type=");
				aPdRjZhF.append(OPERATIONVALIDATE);
				aPdRjZhF.append("&x_amount=");
				NumberFormat jUc27NCE = new DecimalFormat("000.00");
				String gv2SvBcK = jUc27NCE.format(dBUlfHxo.getTotal());
				aPdRjZhF.append(URLEncoder.encode((String) gv2SvBcK, "UTF-8"));
				aPdRjZhF.append("&x_delim_data=TRUE");
				aPdRjZhF.append("&x_delim_char=|");
				aPdRjZhF.append("&x_relay_response=FALSE");
				aPdRjZhF.append("&x_exp_date=");
				String z3W7z0Bj = dBUlfHxo.getExpirationDate();
				aPdRjZhF.append(z3W7z0Bj.charAt(2));
				aPdRjZhF.append(z3W7z0Bj.charAt(3));
				aPdRjZhF.append(z3W7z0Bj.charAt(0));
				aPdRjZhF.append(z3W7z0Bj.charAt(1));
				aPdRjZhF.append("&x_card_num=");
				aPdRjZhF.append(URLEncoder.encode(dBUlfHxo.getCardNumber(), "UTF-8"));
				aPdRjZhF.append("&x_description=Shop+Transaction");
				String[] lUpoxQbi = dBUlfHxo.getHolderName().split(" ");
				aPdRjZhF.append("&x_first_name=");
				if (lUpoxQbi.length > 0) {
					aPdRjZhF.append(URLEncoder.encode(lUpoxQbi[0], "UTF-8"));
				}
				aPdRjZhF.append("&x_last_name=");
				if (lUpoxQbi.length > 1) {
					aPdRjZhF.append(URLEncoder.encode(lUpoxQbi[1], "UTF-8"));
				}
				URL xbAn7XJ9 = new URL(ENDPOINTADDRESS);
				URLConnection y5KIExwQ = xbAn7XJ9.openConnection();
				y5KIExwQ.setDoOutput(true);
				y5KIExwQ.setUseCaches(false);
				y5KIExwQ.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
				DataOutputStream BmUmZMaw = new DataOutputStream(y5KIExwQ.getOutputStream());
				BmUmZMaw.write(aPdRjZhF.toString().getBytes());
				BmUmZMaw.flush();
				BmUmZMaw.close();
				BufferedReader nS99hRTg = new BufferedReader(new InputStreamReader(y5KIExwQ.getInputStream()));
				String owPRuzbR;
				owPRuzbR = nS99hRTg.readLine();
				nS99hRTg.close();
				String[] IPXLlZNX = owPRuzbR.split("\\|");
				if ("1".equals(IPXLlZNX[0])) {
					dBUlfHxo.paymentOK((String) IPXLlZNX[4]);
				} else {
					dBUlfHxo.paymentError(
							AppLocal.getIntString("message.paymenterror") + "\n" + IPXLlZNX[0] + " -- " + IPXLlZNX[3]);
				}
			} catch (UnsupportedEncodingException zy23aPBi) {
				dBUlfHxo.paymentError(
						AppLocal.getIntString("message.paymentexceptionservice") + "\n" + zy23aPBi.getMessage());
			} catch (MalformedURLException C0C11VcM) {
				dBUlfHxo.paymentError(
						AppLocal.getIntString("message.paymentexceptionservice") + "\n" + C0C11VcM.getMessage());
			} catch (IOException iO0epCbt) {
				dBUlfHxo.paymentError(AppLocal.getIntString("message.paymenterror") + "\n" + iO0epCbt.getMessage());
			}
		} else {
			dBUlfHxo.paymentError(AppLocal.getIntString("message.paymentrefundsnotsupported"));
		}
	}

}