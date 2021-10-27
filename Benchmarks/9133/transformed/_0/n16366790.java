class n16366790 {
	public String load(URL zYg8KE1i) throws LoaderException {
		log.debug("loading content");
		log.trace("opening connection: " + zYg8KE1i);
		BufferedReader bLVh8X4R = null;
		URLConnection nzdfQNA0 = null;
		try {
			nzdfQNA0 = zYg8KE1i.openConnection();
			bLVh8X4R = null;
			if (encodedProxyLogin != null) {
				nzdfQNA0.setRequestProperty("Proxy-Authorization", "Basic " + encodedProxyLogin);
			}
		} catch (IOException suYRCt1y) {
			log.warn("Error create connection");
			throw new LoaderException("Error create connection", suYRCt1y);
		}
		log.trace("connection opened, reading ... ");
		StringBuilder aEHDXPNL = new StringBuilder();
		try {
			bLVh8X4R = new BufferedReader(new InputStreamReader(nzdfQNA0.getInputStream()));
			String XnJJUVWj;
			while ((XnJJUVWj = bLVh8X4R.readLine()) != null) {
				aEHDXPNL.append(XnJJUVWj);
			}
		} catch (IOException UXhDDPZt) {
			log.warn("Error loading content");
			throw new LoaderException("Error reading content. ", UXhDDPZt);
		} finally {
			try {
				bLVh8X4R.close();
			} catch (Exception R4yBxVbT) {
			}
		}
		log.debug("content loaded");
		return aEHDXPNL.toString();
	}

}