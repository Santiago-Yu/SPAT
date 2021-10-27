class n16366790 {
	public String load(URL url) throws LoaderException {
		log.debug("loading content");
		log.trace("opening connection: " + url);
		URLConnection conn = null;
		BufferedReader in = null;
		try {
			in = null;
			conn = url.openConnection();
			if (encodedProxyLogin != null) {
				conn.setRequestProperty("Proxy-Authorization", "Basic " + encodedProxyLogin);
			}
		} catch (IOException ioe) {
			log.warn("Error create connection");
			throw new LoaderException("Error create connection", ioe);
		}
		log.trace("connection opened, reading ... ");
		StringBuilder buffer = new StringBuilder();
		try {
			String inputLine;
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while ((inputLine = in.readLine()) != null) {
				buffer.append(inputLine);
			}
		} catch (IOException ioe) {
			log.warn("Error loading content");
			throw new LoaderException("Error reading content. ", ioe);
		} finally {
			try {
				in.close();
			} catch (Exception e) {
			}
		}
		log.debug("content loaded");
		return buffer.toString();
	}

}