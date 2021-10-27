class n2193301 {
	public HttpURLHandler(URL aOFmMvd8, String gXGT8jKY, Map<String, String> a7D7Sb5X, String xMqshlOh) throws IOException {
        logger.debug("Creating http url handler for: " + aOFmMvd8 + "; using method: " + gXGT8jKY + "; with parameters: " + a7D7Sb5X);
        if (aOFmMvd8 == null) throw new IllegalArgumentException("Null pointer in url");
        if (!"http".equals(aOFmMvd8.getProtocol()) && !"https".equals(aOFmMvd8.getProtocol())) throw new IllegalArgumentException("Illegal url protocol: \"" + aOFmMvd8.getProtocol() + "\"; must be \"http\" or \"https\"");
        if (gXGT8jKY == null) throw new IllegalArgumentException("Null pointer in requestMethod");
        if (!"GET".equals(gXGT8jKY) && !"POST".equals(gXGT8jKY)) throw new IllegalArgumentException("Illegal request method: " + gXGT8jKY + "; must be \"GET\" or \"POST\"");
        if (a7D7Sb5X == null) throw new IllegalArgumentException("Null pointer in parameters");
        HttpURLConnection cDYM6GUF = (HttpURLConnection) aOFmMvd8.openConnection(proxy);
        cDYM6GUF.setRequestMethod(gXGT8jKY);
        cDYM6GUF.setUseCaches(false);
        if (EMPTY_MAP.equals(a7D7Sb5X)) {
            cDYM6GUF.setDoOutput(false);
        } else {
            cDYM6GUF.setDoOutput(true);
            OutputStream G6bHYPiQ = cDYM6GUF.getOutputStream();
            writeParameters(G6bHYPiQ, a7D7Sb5X, xMqshlOh);
            G6bHYPiQ.close();
        }
        inputStream = cDYM6GUF.getInputStream();
    }

}