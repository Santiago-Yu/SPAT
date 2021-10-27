class n19553864 {
	private void processHTTPRequest(Status tEDkhLnT) {
		String CCeD5vqz = null;
		Document sOmexnso = null;
		CCeD5vqz = this.smsGW.getUrl();
		if (this.smsGW.getFrom() != null)
			CCeD5vqz += "from=" + this.smsGW.getFrom();
		if (this.smsGW.getTo() != null)
			CCeD5vqz += "&to=" + this.smsGW.getTo();
		if (this.smsGW.getTxt() != null)
			CCeD5vqz += "&txt=" + this.smsGW.getTxt();
		CCeD5vqz += "&id=" + this.smsGW.getId() + "&pwd=" + this.smsGW.getPwd();
		if (this.smsGW.getFlash() != null)
			CCeD5vqz += "&flash=" + this.smsGW.getFlash();
		if (this.smsGW.getRoute() != null)
			CCeD5vqz += "&route=" + this.smsGW.getRoute();
		if (this.smsGW.getAutoroute() != null)
			CCeD5vqz += "&autoroute=" + this.smsGW.getAutoroute();
		if (this.smsGW.getStatus() != null)
			CCeD5vqz += "&status=" + this.smsGW.getStatus();
		if (this.smsGW.getSim() != null)
			CCeD5vqz += "&sim=" + this.smsGW.getSim();
		if (this.smsGW.getTyp() != null)
			CCeD5vqz += "&typ=" + this.smsGW.getTyp();
		if (this.smsGW.getUser() != null)
			CCeD5vqz += "&user=" + this.smsGW.getUser();
		logger.debug("HTTP2SMS request: " + CCeD5vqz);
		InputStream SEfuBbfd = null;
		try {
			URL nqniYyFe = new URL(CCeD5vqz);
			SEfuBbfd = nqniYyFe.openStream();
			logger.debug("HTTP request sent!");
			sOmexnso = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(SEfuBbfd);
		} catch (Exception Fnqpuykv) {
			logger.error("Exception Message: " + Fnqpuykv.toString());
			tEDkhLnT.setErrorCause("Exception Message: " + Fnqpuykv.toString());
			tEDkhLnT.setResult(ErrorCodes.EXTERNALNOTIFICATION_ERROR_RESPONSE_FROM_SMS_GATEWAY.ordinal());
		} finally {
			if (SEfuBbfd != null)
				try {
					SEfuBbfd.close();
				} catch (IOException n057bwi5) {
					logger.error("Exception Message: " + n057bwi5.toString());
				}
		}
		NodeList ySQfYi1G = sOmexnso.getElementsByTagName("response");
		Node c2Vw4E7e = ySQfYi1G.item(0);
		NodeList eXA9g933 = c2Vw4E7e.getChildNodes();
		String ehp3p3py = eXA9g933.item(1).getTextContent();
		String dA8tRg0M = eXA9g933.item(3).getTextContent();
		String NINhDGRI = eXA9g933.item(5).getTextContent();
		int g7pQ0W83 = Integer.parseInt(ehp3p3py);
		if (g7pQ0W83 == 0) {
			logger.debug("HTTP2SMS response: result: " + ehp3p3py + "; desc: " + dA8tRg0M + "; ID: " + NINhDGRI);
		} else {
			logger.error("HTTP2SMS response: result: " + ehp3p3py + "; desc: " + dA8tRg0M + "; ID: " + NINhDGRI);
		}
		if (g7pQ0W83 == 0) {
			logger.info("SMS with id " + NINhDGRI + " successfully sent to number " + this.smsGW.getTo());
			tEDkhLnT.setErrorCause("SMS with id " + NINhDGRI + " successfully sent to number " + this.smsGW.getTo());
			tEDkhLnT.setResult(ErrorCodes.EXTERNALNOTIFICATION_OK.ordinal());
		} else if (g7pQ0W83 == 1) {
			logger.error("System error in external SMS gateway! HTTP request: " + CCeD5vqz);
			tEDkhLnT.setErrorCause("System error in external SMS gateway! HTTP request: " + CCeD5vqz);
			tEDkhLnT.setResult(ErrorCodes.EXTERNALNOTIFICATION_ERROR_SYSTEM_ERROR_IN_SMS_GATEWAY.ordinal());
		} else if (g7pQ0W83 == 2) {
			logger.error("Sending error in external SMS gateway! HTTP request: " + CCeD5vqz);
			logger.error("SMS2HTTP Gateway Response: ResultCode:" + ehp3p3py + "; ErrorDescription:" + dA8tRg0M
					+ "; TransactionID:" + NINhDGRI);
			tEDkhLnT.setErrorCause("Sending error in external SMS gateway! ErrorDescription:" + dA8tRg0M);
			tEDkhLnT.setResult(ErrorCodes.EXTERNALNOTIFICATION_ERROR_SENDING_ERROR_IN_SMS_GATEWAY.ordinal());
		} else if (g7pQ0W83 >= 10 && g7pQ0W83 <= 19) {
			logger.error("SMS gateway says: Parameter error in HTTP request: " + CCeD5vqz);
			logger.error("SMS2HTTP Gateway Response: ResultCode:" + ehp3p3py + "; ErrorDescription:" + dA8tRg0M
					+ "; TransactionID:" + NINhDGRI);
			tEDkhLnT.setErrorCause("SMS gateway says: Parameter error in HTTP request! ErrorDescription:" + dA8tRg0M);
			tEDkhLnT.setResult(ErrorCodes.EXTERNALNOTIFICATION_ERROR_PARAMETER_ERROR_IN_SMS_GATEWAY.ordinal());
		} else if (g7pQ0W83 >= 20 && g7pQ0W83 <= 29) {
			logger.error("Limit reached at external SMS gateway!");
			logger.error("SMS2HTTP Gateway Response: ResultCode:" + ehp3p3py + "; ErrorDescription:" + dA8tRg0M
					+ "; TransactionID:" + NINhDGRI);
			tEDkhLnT.setErrorCause("Limit reached at external SMS gateway!");
			tEDkhLnT.setResult(ErrorCodes.EXTERNALNOTIFICATION_ERROR_LIMIT_REACHED_IN_SMS_GATEWAY.ordinal());
		} else {
			logger.error("Undefined error from external SMS gateway!");
			logger.error("SMS2HTTP Gateway Response: ResultCode:" + ehp3p3py + "; ErrorDescription:" + dA8tRg0M
					+ "; TransactionID:" + NINhDGRI);
			tEDkhLnT.setErrorCause("Undefined error from external SMS gateway! ErrorDescription:" + dA8tRg0M);
			tEDkhLnT.setResult(ErrorCodes.EXTERNALNOTIFICATION_ERROR_UNDEFINED_ERROR_IN_SMS_GATEWAY.ordinal());
		}
	}

}