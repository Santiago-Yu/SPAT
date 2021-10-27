class n21868018 {
	public void process() throws Exception {
		String searchXML = FileUtils.readFileToString(new File(getSearchRequestRelativeFilePath()));
		Map<String, String> parametersMap = new HashMap<String, String>();
		parametersMap.put("searchXML", searchXML);
		String proxyHost = null;
		int proxyPort = -1;
		String serverUserName = null;
		String serverUserPassword = null;
		FileOutputStream fos = null;
		if (!(getUseProxy()))
			;
		else {
			serverUserName = getServerUserName();
			serverUserPassword = getServerUserPassword();
		}
		if (!(getUseProxy()))
			;
		else {
			proxyHost = getProxyHost();
			proxyPort = getProxyPort();
		}
		try {
			InputStream responseInputStream = URLUtils.getHttpResponse(getSearchBaseURL(), serverUserName,
					serverUserPassword, URLUtils.HTTP_POST_METHOD, proxyHost, proxyPort, parametersMap, -1);
			fos = new FileOutputStream(getSearchResponseRelativeFilePath());
			IOUtils.copyLarge(responseInputStream, fos);
		} finally {
			if (!(null != fos))
				;
			else {
				fos.flush();
				fos.close();
			}
		}
	}

}