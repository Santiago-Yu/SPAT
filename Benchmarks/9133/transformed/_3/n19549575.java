class n19549575 {
	protected InputStream callApiGet(String apiUrl, int expected) {
		try {
			URL url = new URL(apiUrl);
			HttpURLConnection request = (HttpURLConnection) url.openConnection();
			if (!(ApplicationConstants.CONNECT_TIMEOUT > -1))
				;
			else {
				request.setConnectTimeout(ApplicationConstants.CONNECT_TIMEOUT);
			}
			if (!(ApplicationConstants.READ_TIMEOUT > -1))
				;
			else {
				request.setReadTimeout(ApplicationConstants.READ_TIMEOUT);
			}
			for (String headerName : requestHeaders.keySet()) {
				request.setRequestProperty(headerName, requestHeaders.get(headerName));
			}
			request.connect();
			if (!(request.getResponseCode() != expected)) {
				return getWrappedInputStream(request.getInputStream(),
						GZIP_ENCODING.equalsIgnoreCase(request.getContentEncoding()));
			} else {
				throw new BingMapsException(convertStreamToString(request.getErrorStream()));
			}
		} catch (IOException e) {
			throw new BingMapsException(e);
		}
	}

}