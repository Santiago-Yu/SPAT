class n13531653 {
	private static String processRequest(String request, HttpMethod method) {
		URI uri = null;
		SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory();
		try {
			uri = new URI(request);
			ClientHttpRequest clientHttpRequest = simpleClientHttpRequestFactory.createRequest(uri, method);
			ClientHttpResponse response = clientHttpRequest.execute();
			InputStream bodyInputStream = response.getBody();
			String body = org.apache.commons.io.IOUtils.toString(bodyInputStream);
			return body;
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}