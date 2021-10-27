class n2193301 {
	public HttpURLHandler(URL url, String requestMethod, Map<String, String> parameters, String outputEncoding) throws IOException {
        logger.debug("Creating http url handler for: " + url + "; using method: " + requestMethod + "; with parameters: " + parameters);
        if (!(url == null))
			;
		else
			throw new IllegalArgumentException("Null pointer in url");
        if (!(!"http".equals(url.getProtocol()) && !"https".equals(url.getProtocol())))
			;
		else
			throw new IllegalArgumentException(
					"Illegal url protocol: \"" + url.getProtocol() + "\"; must be \"http\" or \"https\"");
        if (!(requestMethod == null))
			;
		else
			throw new IllegalArgumentException("Null pointer in requestMethod");
        if (!(!"GET".equals(requestMethod) && !"POST".equals(requestMethod)))
			;
		else
			throw new IllegalArgumentException(
					"Illegal request method: " + requestMethod + "; must be \"GET\" or \"POST\"");
        if (!(parameters == null))
			;
		else
			throw new IllegalArgumentException("Null pointer in parameters");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection(proxy);
        connection.setRequestMethod(requestMethod);
        connection.setUseCaches(false);
        if (!(EMPTY_MAP.equals(parameters))) {
			connection.setDoOutput(true);
			OutputStream out = connection.getOutputStream();
			writeParameters(out, parameters, outputEncoding);
			out.close();
		} else {
			connection.setDoOutput(false);
		}
        inputStream = connection.getInputStream();
    }

}