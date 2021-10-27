class n17171676 {
	public void createMessageBuffer(String messageBufferName, MessageBufferPolicy messageBufferPolicyObj)
			throws AppFabricException {
		String messageBufferPolicy = messageBufferPolicyObj.getMessageBufferPolicy();
		MessageBufferUtil msgBufferUtilObj = new MessageBufferUtil(solutionName,
				TokenConstants.getSimpleAuthAuthenticationType());
		if (messageBufferPolicy == null) {
			throw new AppFabricException("MessageBufferPolicy can not be null");
		}
		String requestUri = msgBufferUtilObj.getRequestUri();
		String messageBufferUri = msgBufferUtilObj.getCreateMessageBufferUri(messageBufferName);
		String authorizationToken = "";
		if (messageBufferUri == null) {
			throw new AppFabricException("MessageBufferUri can not be null");
		}
		try {
			ACSTokenProvider tp = new ACSTokenProvider(httpWebProxyServer_, httpWebProxyPort_, this.credentials);
			authorizationToken = tp.getACSToken(requestUri, messageBufferUri);
		} catch (AppFabricException e) {
			throw e;
		} catch (Exception e) {
			throw new AppFabricException(e.getMessage());
		}
		try {
			messageBufferUri = messageBufferUri.replaceAll("http", "https");
			HttpURLConnection connection;
			URL urlConn = new URL(messageBufferUri);
			if (httpWebProxy_ != null)
				connection = (HttpURLConnection) urlConn.openConnection(httpWebProxy_);
			else
				connection = (HttpURLConnection) urlConn.openConnection();
			connection.setRequestMethod("PUT");
			connection.setRequestProperty("Content-type",
					MessageBufferConstants.getCONTENT_TYPE_PROPERTY_FOR_ATOM_XML());
			connection.setRequestProperty("Content-Length", "" + messageBufferPolicy.length());
			String authStr = TokenConstants.getWrapAuthenticationType() + " "
					+ TokenConstants.getWrapAuthorizationHeaderKey() + "=\"" + authorizationToken + "\"";
			connection.setRequestProperty("Authorization", authStr);
			connection.setRequestProperty("Expect", "100-continue");
			connection.setUseCaches(false);
			connection.setDoInput(true);
			connection.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
			wr.writeBytes(messageBufferPolicy);
			wr.flush();
			wr.close();
			if (LoggerUtil.getIsLoggingOn())
				SDKLoggerHelper.logRequest(connection, SDKLoggerHelper.RecordType.CreateMessageBuffer_REQUEST);
			String responseCode = "<responseCode>" + connection.getResponseCode() + "</responseCode>";
			if ((connection.getResponseCode() == MessageBufferConstants.HTTP_STATUS_CODE_ACCEPTED)
					|| (connection.getResponseCode() == MessageBufferConstants.HTTP_STATUS_CODE_CREATED)
					|| (connection.getResponseCode() == MessageBufferConstants.HTTP_STATUS_CODE_OK)) {
				InputStream is = connection.getInputStream();
				String line;
				BufferedReader rd = new BufferedReader(new InputStreamReader(is));
				StringBuffer response = new StringBuffer();
				while ((line = rd.readLine()) != null) {
					response.append(line);
					response.append('\r');
				}
				rd.close();
				if (LoggerUtil.getIsLoggingOn()) {
					StringBuilder responseXML = new StringBuilder();
					responseXML.append(responseCode);
					responseXML.append(response.toString());
					SDKLoggerHelper.logMessage(URLEncoder.encode(responseXML.toString(), "UTF-8"),
							SDKLoggerHelper.RecordType.CreateMessageBuffer_RESPONSE);
				}
			} else {
				if (LoggerUtil.getIsLoggingOn())
					SDKLoggerHelper.logMessage(URLEncoder.encode(responseCode, "UTF-8"),
							SDKLoggerHelper.RecordType.CreateMessageBuffer_RESPONSE);
				throw new AppFabricException("MessageBuffer could not be created or updated. Error. Response code:  "
						+ connection.getResponseCode());
			}
		} catch (Exception e) {
			throw new AppFabricException(e.getMessage());
		}
	}

}