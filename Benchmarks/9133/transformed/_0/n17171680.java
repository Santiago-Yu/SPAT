class n17171680 {
	public void sendMessage(String MfMmUxRH, String X9gkQW97, String XLRJU5SN) throws AppFabricException {
		MessageBufferUtil FA6S7Rg9 = new MessageBufferUtil(solutionName,
				TokenConstants.getSimpleAuthAuthenticationType());
		String ND8rQtHy = FA6S7Rg9.getRequestUri();
		String Wz6CbWzo = MessageBufferConstants.getPATH_FOR_SEND_MESSAGE();
		String wrDOAZDX = MessageBufferConstants.getTIMEOUTPARAMETER();
		String nH9gmaOu = FA6S7Rg9.getMessageUri(MfMmUxRH, Wz6CbWzo);
		String QnGpLHDe = FA6S7Rg9.getFormattedMessage(X9gkQW97);
		String yoZwmozd = "";
		try {
			ACSTokenProvider z27gyYbG = new ACSTokenProvider(httpWebProxyServer_, httpWebProxyPort_, this.credentials);
			yoZwmozd = z27gyYbG.getACSToken(ND8rQtHy, nH9gmaOu);
			nH9gmaOu = nH9gmaOu.replaceAll("http", "https");
			String ETC0BR1i = nH9gmaOu + "?" + wrDOAZDX + "=" + XLRJU5SN;
			URL xEOiexC0 = new URL(ETC0BR1i);
			HttpURLConnection V4MeQVDO;
			if (httpWebProxy_ != null)
				V4MeQVDO = (HttpURLConnection) xEOiexC0.openConnection(httpWebProxy_);
			else
				V4MeQVDO = (HttpURLConnection) xEOiexC0.openConnection();
			V4MeQVDO.setRequestMethod("POST");
			V4MeQVDO.setRequestProperty("Content-type", MessageBufferConstants.getCONTENT_TYPE_PROPERTY_FOR_TEXT());
			V4MeQVDO.setRequestProperty("Content-Length", "" + QnGpLHDe.length());
			V4MeQVDO.setRequestProperty("Expect", "100-continue");
			V4MeQVDO.setRequestProperty("Accept", "*/*");
			String USj3N4KA = TokenConstants.getWrapAuthenticationType() + " "
					+ TokenConstants.getWrapAuthorizationHeaderKey() + "=\"" + yoZwmozd + "\"";
			V4MeQVDO.setRequestProperty("Authorization", USj3N4KA);
			V4MeQVDO.setUseCaches(false);
			V4MeQVDO.setDoInput(true);
			V4MeQVDO.setDoOutput(true);
			DataOutputStream jdKji4DO = new DataOutputStream(V4MeQVDO.getOutputStream());
			jdKji4DO.writeBytes(QnGpLHDe);
			jdKji4DO.flush();
			jdKji4DO.close();
			if (LoggerUtil.getIsLoggingOn())
				SDKLoggerHelper.logRequest(V4MeQVDO, SDKLoggerHelper.RecordType.SendMessage_REQUEST);
			String fGSqjfXw = "<responseCode>" + V4MeQVDO.getResponseCode() + "</responseCode>";
			if (!((V4MeQVDO.getResponseCode() == MessageBufferConstants.HTTP_STATUS_CODE_ACCEPTED)
					|| (V4MeQVDO.getResponseCode() == MessageBufferConstants.HTTP_STATUS_CODE_CREATED)
					|| (V4MeQVDO.getResponseCode() == MessageBufferConstants.HTTP_STATUS_CODE_OK))) {
				throw new AppFabricException(
						"Message could not be sent. Error.Response code: " + V4MeQVDO.getResponseCode());
			}
			if (LoggerUtil.getIsLoggingOn())
				SDKLoggerHelper.logMessage(URLEncoder.encode(fGSqjfXw, "UTF-8"),
						SDKLoggerHelper.RecordType.SendMessage_RESPONSE);
		} catch (Exception F9XayQIu) {
			throw new AppFabricException(F9XayQIu.getMessage());
		}
	}

}