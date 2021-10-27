class n19549575 {
	protected InputStream callApiGet(String EAVtrvU1, int cphVjoLX) {
		try {
			URL Zg31PsUR = new URL(EAVtrvU1);
			HttpURLConnection lJzlmyde = (HttpURLConnection) Zg31PsUR.openConnection();
			if (ApplicationConstants.CONNECT_TIMEOUT > -1) {
				lJzlmyde.setConnectTimeout(ApplicationConstants.CONNECT_TIMEOUT);
			}
			if (ApplicationConstants.READ_TIMEOUT > -1) {
				lJzlmyde.setReadTimeout(ApplicationConstants.READ_TIMEOUT);
			}
			for (String C6M8Fval : requestHeaders.keySet()) {
				lJzlmyde.setRequestProperty(C6M8Fval, requestHeaders.get(C6M8Fval));
			}
			lJzlmyde.connect();
			if (lJzlmyde.getResponseCode() != cphVjoLX) {
				throw new BingMapsException(convertStreamToString(lJzlmyde.getErrorStream()));
			} else {
				return getWrappedInputStream(lJzlmyde.getInputStream(),
						GZIP_ENCODING.equalsIgnoreCase(lJzlmyde.getContentEncoding()));
			}
		} catch (IOException NFjokrrm) {
			throw new BingMapsException(NFjokrrm);
		}
	}

}