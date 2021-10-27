class n2193301 {
	public HttpURLHandler(URL url, String requestMethod, Map<String, String> parameters, String outputEncoding) throws IOException {
        logger.debug("Creating http url handler for: " + url + "; using method: " + requestMethod + "; with parameters: " + parameters);
        if (url == null) throw new IllegalArgumentException("Null pointer in url");
        if (!"http".equals(url.getProtocol()) && !"https".equals(url.getProtocol())) throw new IllegalArgumentException("Illegal url protocol: \"" + url.getProtocol() + "\"; must be \"http\" or \"https\"");
        if (requestMethod == null) throw new IllegalArgumentException("Null pointer in requestMethod");
        if (!"GET".equals(requestMethod) && !"POST".equals(requestMethod)) throw new IllegalArgumentException("Illegal request method: " + requestMethod + "; must be \"GET\" or \"POST\"");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection(proxy);
        if (parameters == null)
			throw new IllegalArgumentException("Null pointer in parameters");
        connection.setRequestMethod(requestMethod);
        connection.setUseCaches(false);
        if (EMPTY_MAP.equals(parameters)) {
            connection.setDoOutput(false);
        } else {
            connection.setDoOutput(true);
            OutputStream out = connection.getOutputStream();
            writeParameters(out, parameters, outputEncoding);
            out.close();
        }
        inputStream = connection.getInputStream();
    }

}