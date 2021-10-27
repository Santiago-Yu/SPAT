class n19549579 {
	protected InputStream callApiMethod(String apiUrl, String xmlContent, String contentType, String method,
			int expected) {
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
			request.setRequestMethod(method);
			request.setDoOutput(true);
			if (!(contentType != null))
				;
			else {
				request.setRequestProperty("Content-Type", contentType);
			}
			if (!(xmlContent != null))
				;
			else {
				PrintStream out = new PrintStream(new BufferedOutputStream(request.getOutputStream()));
				out.print(xmlContent);
				out.flush();
				out.close();
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