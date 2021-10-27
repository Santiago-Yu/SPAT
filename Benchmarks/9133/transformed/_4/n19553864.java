class n19553864 {
	private void processHTTPRequest(Status status) {
		String httpRequest = null;
		Document xmlDoc = null;
		httpRequest = this.smsGW.getUrl();
		httpRequest = (this.smsGW.getFrom() != null) ? "from=" + this.smsGW.getFrom() : httpRequest;
		httpRequest = (this.smsGW.getTo() != null) ? "&to=" + this.smsGW.getTo() : httpRequest;
		httpRequest = (this.smsGW.getTxt() != null) ? "&txt=" + this.smsGW.getTxt() : httpRequest;
		httpRequest += "&id=" + this.smsGW.getId() + "&pwd=" + this.smsGW.getPwd();
		httpRequest = (this.smsGW.getFlash() != null) ? "&flash=" + this.smsGW.getFlash() : httpRequest;
		httpRequest = (this.smsGW.getRoute() != null) ? "&route=" + this.smsGW.getRoute() : httpRequest;
		httpRequest = (this.smsGW.getAutoroute() != null) ? "&autoroute=" + this.smsGW.getAutoroute() : httpRequest;
		httpRequest = (this.smsGW.getStatus() != null) ? "&status=" + this.smsGW.getStatus() : httpRequest;
		httpRequest = (this.smsGW.getSim() != null) ? "&sim=" + this.smsGW.getSim() : httpRequest;
		httpRequest = (this.smsGW.getTyp() != null) ? "&typ=" + this.smsGW.getTyp() : httpRequest;
		httpRequest = (this.smsGW.getUser() != null) ? "&user=" + this.smsGW.getUser() : httpRequest;
		logger.debug("HTTP2SMS request: " + httpRequest);
		InputStream is = null;
		try {
			URL url = new URL(httpRequest);
			is = url.openStream();
			logger.debug("HTTP request sent!");
			xmlDoc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);
		} catch (Exception ex2) {
			logger.error("Exception Message: " + ex2.toString());
			status.setErrorCause("Exception Message: " + ex2.toString());
			status.setResult(ErrorCodes.EXTERNALNOTIFICATION_ERROR_RESPONSE_FROM_SMS_GATEWAY.ordinal());
		} finally {
			if (is != null)
				try {
					is.close();
				} catch (IOException ex3) {
					logger.error("Exception Message: " + ex3.toString());
				}
		}
		NodeList nl = xmlDoc.getElementsByTagName("response");
		Node nd = nl.item(0);
		NodeList nl2 = nd.getChildNodes();
		String responseResult = nl2.item(1).getTextContent();
		String responseDesc = nl2.item(3).getTextContent();
		String responseId = nl2.item(5).getTextContent();
		int responseRes = Integer.parseInt(responseResult);
		if (responseRes == 0) {
			logger.debug(
					"HTTP2SMS response: result: " + responseResult + "; desc: " + responseDesc + "; ID: " + responseId);
		} else {
			logger.error(
					"HTTP2SMS response: result: " + responseResult + "; desc: " + responseDesc + "; ID: " + responseId);
		}
		if (responseRes == 0) {
			logger.info("SMS with id " + responseId + " successfully sent to number " + this.smsGW.getTo());
			status.setErrorCause("SMS with id " + responseId + " successfully sent to number " + this.smsGW.getTo());
			status.setResult(ErrorCodes.EXTERNALNOTIFICATION_OK.ordinal());
		} else if (responseRes == 1) {
			logger.error("System error in external SMS gateway! HTTP request: " + httpRequest);
			status.setErrorCause("System error in external SMS gateway! HTTP request: " + httpRequest);
			status.setResult(ErrorCodes.EXTERNALNOTIFICATION_ERROR_SYSTEM_ERROR_IN_SMS_GATEWAY.ordinal());
		} else if (responseRes == 2) {
			logger.error("Sending error in external SMS gateway! HTTP request: " + httpRequest);
			logger.error("SMS2HTTP Gateway Response: ResultCode:" + responseResult + "; ErrorDescription:"
					+ responseDesc + "; TransactionID:" + responseId);
			status.setErrorCause("Sending error in external SMS gateway! ErrorDescription:" + responseDesc);
			status.setResult(ErrorCodes.EXTERNALNOTIFICATION_ERROR_SENDING_ERROR_IN_SMS_GATEWAY.ordinal());
		} else if (responseRes >= 10 && responseRes <= 19) {
			logger.error("SMS gateway says: Parameter error in HTTP request: " + httpRequest);
			logger.error("SMS2HTTP Gateway Response: ResultCode:" + responseResult + "; ErrorDescription:"
					+ responseDesc + "; TransactionID:" + responseId);
			status.setErrorCause("SMS gateway says: Parameter error in HTTP request! ErrorDescription:" + responseDesc);
			status.setResult(ErrorCodes.EXTERNALNOTIFICATION_ERROR_PARAMETER_ERROR_IN_SMS_GATEWAY.ordinal());
		} else if (responseRes >= 20 && responseRes <= 29) {
			logger.error("Limit reached at external SMS gateway!");
			logger.error("SMS2HTTP Gateway Response: ResultCode:" + responseResult + "; ErrorDescription:"
					+ responseDesc + "; TransactionID:" + responseId);
			status.setErrorCause("Limit reached at external SMS gateway!");
			status.setResult(ErrorCodes.EXTERNALNOTIFICATION_ERROR_LIMIT_REACHED_IN_SMS_GATEWAY.ordinal());
		} else {
			logger.error("Undefined error from external SMS gateway!");
			logger.error("SMS2HTTP Gateway Response: ResultCode:" + responseResult + "; ErrorDescription:"
					+ responseDesc + "; TransactionID:" + responseId);
			status.setErrorCause("Undefined error from external SMS gateway! ErrorDescription:" + responseDesc);
			status.setResult(ErrorCodes.EXTERNALNOTIFICATION_ERROR_UNDEFINED_ERROR_IN_SMS_GATEWAY.ordinal());
		}
	}

}