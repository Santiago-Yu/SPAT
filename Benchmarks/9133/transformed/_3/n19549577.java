class n19549577 {
	protected InputStream callApiPost(String apiUrl, Map<String, List<String>> parameters, int expected) {
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
			request.setRequestMethod("POST");
			request.setDoOutput(true);
			PrintStream out = new PrintStream(new BufferedOutputStream(request.getOutputStream()));
			out.print(getParametersString(parameters));
			out.flush();
			out.close();
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