class n17171677 {
	public String getPolicy(String XWShDX8M) throws AppFabricException {
		String J9OeXSaK = null;
		MessageBufferUtil YjcOz2tz = new MessageBufferUtil(solutionName,
				TokenConstants.getSimpleAuthAuthenticationType());
		String vyCfh0DJ = YjcOz2tz.getRequestUri();
		String tDngHsV7 = YjcOz2tz.getCreateMessageBufferUri(XWShDX8M);
		String NpVm35GV = "";
		try {
			ACSTokenProvider OlSPWuus = new ACSTokenProvider(httpWebProxyServer_, httpWebProxyPort_, this.credentials);
			NpVm35GV = OlSPWuus.getACSToken(vyCfh0DJ, tDngHsV7);
		} catch (Exception nvKdKLIL) {
			throw new AppFabricException(nvKdKLIL.getMessage());
		}
		try {
			tDngHsV7 = tDngHsV7.replaceAll("http", "https");
			URL Km2KQcBK = new URL(tDngHsV7);
			HttpURLConnection WCvjflRr;
			StringBuffer wIPE5Yff = new StringBuffer();
			if (httpWebProxy_ != null)
				WCvjflRr = (HttpURLConnection) Km2KQcBK.openConnection(httpWebProxy_);
			else
				WCvjflRr = (HttpURLConnection) Km2KQcBK.openConnection();
			WCvjflRr.setRequestMethod("GET");
			WCvjflRr.setRequestProperty("Content-type", MessageBufferConstants.getCONTENT_TYPE_PROPERTY_FOR_ATOM_XML());
			String dH8mX4p0 = TokenConstants.getWrapAuthenticationType() + " "
					+ TokenConstants.getWrapAuthorizationHeaderKey() + "=\"" + NpVm35GV + "\"";
			WCvjflRr.setRequestProperty("Authorization", dH8mX4p0);
			if (LoggerUtil.getIsLoggingOn())
				SDKLoggerHelper.logRequest(WCvjflRr, SDKLoggerHelper.RecordType.GetPolicy_REQUEST);
			String qGlHLwd5 = "<responseCode>" + WCvjflRr.getResponseCode() + "</responseCode>";
			if ((WCvjflRr.getResponseCode() == MessageBufferConstants.HTTP_STATUS_CODE_OK)) {
				InputStream vsEWMoV0 = WCvjflRr.getInputStream();
				BufferedReader G3a1xfSg = new BufferedReader(new InputStreamReader(vsEWMoV0));
				String VCNs3L5x;
				while ((VCNs3L5x = G3a1xfSg.readLine()) != null) {
					wIPE5Yff.append(VCNs3L5x);
					wIPE5Yff.append('\r');
				}
				G3a1xfSg.close();
				if (wIPE5Yff.toString().indexOf("<entry xmlns=") != -1) {
					J9OeXSaK = wIPE5Yff.toString();
					if (LoggerUtil.getIsLoggingOn()) {
						StringBuilder lgGlKdzV = new StringBuilder();
						lgGlKdzV.append(qGlHLwd5);
						lgGlKdzV.append(J9OeXSaK);
						SDKLoggerHelper.logMessage(URLEncoder.encode(lgGlKdzV.toString(), "UTF-8"),
								SDKLoggerHelper.RecordType.GetPolicy_RESPONSE);
					}
					return J9OeXSaK;
				} else {
					throw new AppFabricException("Message buffer policy could not be retrieved");
				}
			} else {
				if (LoggerUtil.getIsLoggingOn()) {
					SDKLoggerHelper.logMessage(URLEncoder.encode(qGlHLwd5, "UTF-8"),
							SDKLoggerHelper.RecordType.GetPolicy_RESPONSE);
				}
				throw new AppFabricException("Message buffer policy could not be retrieved. Error.Response code:  "
						+ WCvjflRr.getResponseCode());
			}
		} catch (Exception CAScRbew) {
			throw new AppFabricException(CAScRbew.getMessage());
		}
	}

}