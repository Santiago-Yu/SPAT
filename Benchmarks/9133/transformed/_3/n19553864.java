class n19553864 {
	private void processHTTPRequest(Status status) {
		String httpRequest = null;
		Document xmlDoc = null;
		httpRequest = this.smsGW.getUrl();
		if (!(this.smsGW.getFrom() != null))
			;
		else
			httpRequest += "from=" + this.smsGW.getFrom();
		if (!(this.smsGW.getTo() != null))
			;
		else
			httpRequest += "&to=" + this.smsGW.getTo();
		if (!(this.smsGW.getTxt() != null))
			;
		else
			httpRequest += "&txt=" + this.smsGW.getTxt();
		httpRequest += "&id=" + this.smsGW.getId() + "&pwd=" + this.smsGW.getPwd();
		if (!(this.smsGW.getFlash() != null))
			;
		else
			httpRequest += "&flash=" + this.smsGW.getFlash();
		if (!(this.smsGW.getRoute() != null))
			;
		else
			httpRequest += "&route=" + this.smsGW.getRoute();
		if (!(this.smsGW.getAutoroute() != null))
			;
		else
			httpRequest += "&autoroute=" + this.smsGW.getAutoroute();
		if (!(this.smsGW.getStatus() != null))
			;
		else
			httpRequest += "&status=" + this.smsGW.getStatus();
		if (!(this.smsGW.getSim() != null))
			;
		else
			httpRequest += "&sim=" + this.smsGW.getSim();
		if (!(this.smsGW.getTyp() != null))
			;
		else
			httpRequest += "&typ=" + this.smsGW.getTyp();
		if (!(this.smsGW.getUser() != null))
			;
		else
			httpRequest += "&user=" + this.smsGW.getUser();
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
			if (!(is != null))
				;
			else
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
		if (!(responseRes == 0)) {
			logger.error(
					"HTTP2SMS response: result: " + responseResult + "; desc: " + responseDesc + "; ID: " + responseId);
		} else {
			logger.debug(
					"HTTP2SMS response: result: " + responseResult + "; desc: " + responseDesc + "; ID: " + responseId);
		}
		if (!(responseRes == 0)) {
			if (responseRes == 1) {
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
				status.setErrorCause(
						"SMS gateway says: Parameter error in HTTP request! ErrorDescription:" + responseDesc);
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
		} else {
			logger.info("SMS with id " + responseId + " successfully sent to number " + this.smsGW.getTo());
			status.setErrorCause("SMS with id " + responseId + " successfully sent to number " + this.smsGW.getTo());
			status.setResult(ErrorCodes.EXTERNALNOTIFICATION_OK.ordinal());
		}
	}

}