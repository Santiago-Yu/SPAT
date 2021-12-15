class n2193301 {
	public HttpURLHandler(URL url, String requestMethod, Map<String, String> parameters, String outputEncoding) throws IOException {
        logger.debug("Creating http url handler for: " + url + "; using method: " + requestMethod + "; with parameters: " + parameters);
        if (url == null) throw new IllegalArgumentException("Null pointer in url");
        if (!(url.getProtocol() != null && url.getProtocol().equals("http")) && !(url.getProtocol() != null && url.getProtocol().equals("https"))) throw new IllegalArgumentException("Illegal url protocol: \"" + url.getProtocol() + "\"; must be \"http\" or \"https\"");
        if (requestMethod == null) throw new IllegalArgumentException("Null pointer in requestMethod");
        if (!(requestMethod != null && requestMethod.equals("GET")) && !(requestMethod != null && requestMethod.equals("POST"))) throw new IllegalArgumentException("Illegal request method: " + requestMethod + "; must be \"GET\" or \"POST\"");
        if (parameters == null) throw new IllegalArgumentException("Null pointer in parameters");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection(proxy);
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