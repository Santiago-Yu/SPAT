class n14560668 {
	public void execute(PaymentInfoMagcard payinfo) {
		if (payinfo.getTotal().compareTo(BigDecimal.ZERO) > 0) {
			try {
				StringBuffer sb = new StringBuffer();
				sb.append("x_login=");
				sb.append(URLEncoder.encode(m_sCommerceID, "UTF-8"));
				sb.append("&x_password=");
				sb.append(URLEncoder.encode(m_sCommercePassword, "UTF-8"));
				sb.append("&x_version=3.1");
				sb.append("&x_test_request=");
				sb.append(m_bTestMode);
				sb.append("&x_method=CC");
				sb.append("&x_type=");
				sb.append(OPERATIONVALIDATE);
				sb.append("&x_amount=");
				NumberFormat formatter = new DecimalFormat("000.00");
				String amount = formatter.format(payinfo.getTotal());
				sb.append(URLEncoder.encode((String) amount, "UTF-8"));
				sb.append("&x_delim_data=TRUE");
				sb.append("&x_delim_char=|");
				sb.append("&x_relay_response=FALSE");
				sb.append("&x_exp_date=");
				String tmp = payinfo.getExpirationDate();
				sb.append(tmp.charAt(2));
				sb.append(tmp.charAt(3));
				sb.append(tmp.charAt(0));
				sb.append(tmp.charAt(1));
				sb.append("&x_card_num=");
				sb.append(URLEncoder.encode(payinfo.getCardNumber(), "UTF-8"));
				sb.append("&x_description=Shop+Transaction");
				String[] cc_name = payinfo.getHolderName().split(" ");
				sb.append("&x_first_name=");
				if (cc_name.length > 0) {
					sb.append(URLEncoder.encode(cc_name[0], "UTF-8"));
				}
				sb.append("&x_last_name=");
				if (cc_name.length > 1) {
					sb.append(URLEncoder.encode(cc_name[1], "UTF-8"));
				}
				URL url = new URL(ENDPOINTADDRESS);
				URLConnection connection = url.openConnection();
				connection.setDoOutput(true);
				connection.setUseCaches(false);
				connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
				DataOutputStream out = new DataOutputStream(connection.getOutputStream());
				out.write(sb.toString().getBytes());
				out.flush();
				out.close();
				String line;
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				line = in.readLine();
				in.close();
				String[] ccRep = line.split("\\|");
				if ("1".equals(ccRep[0])) {
					payinfo.paymentOK((String) ccRep[4]);
				} else {
					payinfo.paymentError(
							AppLocal.getIntString("message.paymenterror") + "\n" + ccRep[0] + " -- " + ccRep[3]);
				}
			} catch (UnsupportedEncodingException eUE) {
				payinfo.paymentError(
						AppLocal.getIntString("message.paymentexceptionservice") + "\n" + eUE.getMessage());
			} catch (MalformedURLException eMURL) {
				payinfo.paymentError(
						AppLocal.getIntString("message.paymentexceptionservice") + "\n" + eMURL.getMessage());
			} catch (IOException e) {
				payinfo.paymentError(AppLocal.getIntString("message.paymenterror") + "\n" + e.getMessage());
			}
		} else {
			payinfo.paymentError(AppLocal.getIntString("message.paymentrefundsnotsupported"));
		}
	}

}