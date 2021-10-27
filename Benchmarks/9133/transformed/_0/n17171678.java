class n17171678 {
	public void deleteMessageBuffer(String YKCZCHCD) throws AppFabricException {
		MessageBufferUtil Jg5tE5vs = new MessageBufferUtil(solutionName,
				TokenConstants.getSimpleAuthAuthenticationType());
		String QsIKUfMU = Jg5tE5vs.getRequestUri();
		String p8inWDYu = Jg5tE5vs.getCreateMessageBufferUri(YKCZCHCD);
		String tla0RGP9 = "";
		try {
			ACSTokenProvider OVHucyiA = new ACSTokenProvider(httpWebProxyServer_, httpWebProxyPort_, this.credentials);
			tla0RGP9 = OVHucyiA.getACSToken(QsIKUfMU, p8inWDYu);
		} catch (Exception M4fkCQIt) {
			throw new AppFabricException(M4fkCQIt.getMessage());
		}
		try {
			p8inWDYu = p8inWDYu.replaceAll("http", "https");
			URL GRhCO4Xy = new URL(p8inWDYu);
			HttpURLConnection srMQTuJF;
			if (httpWebProxy_ != null)
				srMQTuJF = (HttpURLConnection) GRhCO4Xy.openConnection(httpWebProxy_);
			else
				srMQTuJF = (HttpURLConnection) GRhCO4Xy.openConnection();
			srMQTuJF.setRequestMethod("DELETE");
			srMQTuJF.setDoInput(true);
			srMQTuJF.setDoOutput(true);
			srMQTuJF.setRequestProperty("Content-type", MessageBufferConstants.getCONTENT_TYPE_PROPERTY_FOR_ATOM_XML());
			String AHxGsWmi = TokenConstants.getWrapAuthenticationType() + " "
					+ TokenConstants.getWrapAuthorizationHeaderKey() + "=\"" + tla0RGP9 + "\"";
			srMQTuJF.setRequestProperty("Authorization", AHxGsWmi);
			if (LoggerUtil.getIsLoggingOn())
				SDKLoggerHelper.logRequest(srMQTuJF, SDKLoggerHelper.RecordType.DeleteMessageBuffer_REQUEST);
			String qPc3OxeP = "<responseCode>" + srMQTuJF.getResponseCode() + "</responseCode>";
			if ((srMQTuJF.getResponseCode() == MessageBufferConstants.HTTP_STATUS_CODE_OK)) {
				InputStream T0asC7r9 = srMQTuJF.getInputStream();
				BufferedReader ga9DExoF = new BufferedReader(new InputStreamReader(T0asC7r9));
				String ZIbZ6mYm;
				StringBuffer tZH7JCFf = new StringBuffer();
				while ((ZIbZ6mYm = ga9DExoF.readLine()) != null) {
					tZH7JCFf.append(ZIbZ6mYm);
					tZH7JCFf.append('\r');
				}
				ga9DExoF.close();
			} else {
				throw new AppFabricException(
						"MessageBuffer could not be deleted.Error...Response code:  " + srMQTuJF.getResponseCode());
			}
			if (LoggerUtil.getIsLoggingOn())
				SDKLoggerHelper.logMessage(URLEncoder.encode(qPc3OxeP, "UTF-8"),
						SDKLoggerHelper.RecordType.DeleteMessageBuffer_RESPONSE);
		} catch (Exception alcJvN7H) {
			throw new AppFabricException(alcJvN7H.getMessage());
		}
	}

}