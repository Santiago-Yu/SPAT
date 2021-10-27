class n17171676 {
	public void createMessageBuffer(String zV3JYHb3, MessageBufferPolicy vTU4ifB9) throws AppFabricException {
		String FKjR1Xsj = vTU4ifB9.getMessageBufferPolicy();
		if (FKjR1Xsj == null) {
			throw new AppFabricException("MessageBufferPolicy can not be null");
		}
		MessageBufferUtil AXglTe8P = new MessageBufferUtil(solutionName,
				TokenConstants.getSimpleAuthAuthenticationType());
		String BsLw6vMU = AXglTe8P.getRequestUri();
		String fMJKUe7v = AXglTe8P.getCreateMessageBufferUri(zV3JYHb3);
		if (fMJKUe7v == null) {
			throw new AppFabricException("MessageBufferUri can not be null");
		}
		String nsnBGcWx = "";
		try {
			ACSTokenProvider lab1R3Dj = new ACSTokenProvider(httpWebProxyServer_, httpWebProxyPort_, this.credentials);
			nsnBGcWx = lab1R3Dj.getACSToken(BsLw6vMU, fMJKUe7v);
		} catch (AppFabricException zjL3h2yz) {
			throw zjL3h2yz;
		} catch (Exception t3GcXwuC) {
			throw new AppFabricException(t3GcXwuC.getMessage());
		}
		try {
			fMJKUe7v = fMJKUe7v.replaceAll("http", "https");
			URL Ny88Hzwp = new URL(fMJKUe7v);
			HttpURLConnection VGiAiXZS;
			if (httpWebProxy_ != null)
				VGiAiXZS = (HttpURLConnection) Ny88Hzwp.openConnection(httpWebProxy_);
			else
				VGiAiXZS = (HttpURLConnection) Ny88Hzwp.openConnection();
			VGiAiXZS.setRequestMethod("PUT");
			VGiAiXZS.setRequestProperty("Content-type", MessageBufferConstants.getCONTENT_TYPE_PROPERTY_FOR_ATOM_XML());
			VGiAiXZS.setRequestProperty("Content-Length", "" + FKjR1Xsj.length());
			String wjmhxDn2 = TokenConstants.getWrapAuthenticationType() + " "
					+ TokenConstants.getWrapAuthorizationHeaderKey() + "=\"" + nsnBGcWx + "\"";
			VGiAiXZS.setRequestProperty("Authorization", wjmhxDn2);
			VGiAiXZS.setRequestProperty("Expect", "100-continue");
			VGiAiXZS.setUseCaches(false);
			VGiAiXZS.setDoInput(true);
			VGiAiXZS.setDoOutput(true);
			DataOutputStream NygY357R = new DataOutputStream(VGiAiXZS.getOutputStream());
			NygY357R.writeBytes(FKjR1Xsj);
			NygY357R.flush();
			NygY357R.close();
			if (LoggerUtil.getIsLoggingOn())
				SDKLoggerHelper.logRequest(VGiAiXZS, SDKLoggerHelper.RecordType.CreateMessageBuffer_REQUEST);
			String hJLFm1ma = "<responseCode>" + VGiAiXZS.getResponseCode() + "</responseCode>";
			if ((VGiAiXZS.getResponseCode() == MessageBufferConstants.HTTP_STATUS_CODE_ACCEPTED)
					|| (VGiAiXZS.getResponseCode() == MessageBufferConstants.HTTP_STATUS_CODE_CREATED)
					|| (VGiAiXZS.getResponseCode() == MessageBufferConstants.HTTP_STATUS_CODE_OK)) {
				InputStream iw9NVNWu = VGiAiXZS.getInputStream();
				BufferedReader vrVcBP9z = new BufferedReader(new InputStreamReader(iw9NVNWu));
				String EF5HqCLB;
				StringBuffer sRzfs4sh = new StringBuffer();
				while ((EF5HqCLB = vrVcBP9z.readLine()) != null) {
					sRzfs4sh.append(EF5HqCLB);
					sRzfs4sh.append('\r');
				}
				vrVcBP9z.close();
				if (LoggerUtil.getIsLoggingOn()) {
					StringBuilder V5HWTURv = new StringBuilder();
					V5HWTURv.append(hJLFm1ma);
					V5HWTURv.append(sRzfs4sh.toString());
					SDKLoggerHelper.logMessage(URLEncoder.encode(V5HWTURv.toString(), "UTF-8"),
							SDKLoggerHelper.RecordType.CreateMessageBuffer_RESPONSE);
				}
			} else {
				if (LoggerUtil.getIsLoggingOn())
					SDKLoggerHelper.logMessage(URLEncoder.encode(hJLFm1ma, "UTF-8"),
							SDKLoggerHelper.RecordType.CreateMessageBuffer_RESPONSE);
				throw new AppFabricException("MessageBuffer could not be created or updated. Error. Response code:  "
						+ VGiAiXZS.getResponseCode());
			}
		} catch (Exception QN6v9AMJ) {
			throw new AppFabricException(QN6v9AMJ.getMessage());
		}
	}

}