class n12766377 {
	public Document index() throws CrawlingException {
		log.debug("BEGINIG indexing page [code=" + getCode() + "] ...");
		URL pzjBosvT = null;
		InputStream W9TyFtiv = null;
		String VkAXBbAV = null;
		try {
			pzjBosvT = new URL(getServer().getProtocol() + "://" + getServer().getHost() + ":" + getServer().getPort()
					+ getPath());
			HttpURLConnection YU0NG44B = (HttpURLConnection) pzjBosvT.openConnection();
			if (YU0NG44B.getResponseCode() != HttpURLConnection.HTTP_OK) {
				log.debug("page pk[" + getCode() + "," + pzjBosvT.toExternalForm() + "] is invalid");
				return null;
			}
			String p31QzU8R = YU0NG44B.getHeaderField("location");
			if (p31QzU8R != null) {
				log.debug("Page " + pzjBosvT.toExternalForm() + " redirected to " + p31QzU8R);
				recordLink(p31QzU8R);
				return null;
			}
			VkAXBbAV = YU0NG44B.getContentType();
			W9TyFtiv = new BufferedInputStream(YU0NG44B.getInputStream(), 32768);
		} catch (MalformedURLException b5wRiwLP) {
			log.error("Invalid page address", b5wRiwLP);
		} catch (ConnectException WdUBJZX1) {
			if (getServer() != null) {
				log.error("Unable to connect to page: " + getServer().getProtocol() + "://" + getServer().getHost()
						+ ":" + getServer().getPort() + getPath(), WdUBJZX1);
			}
		} catch (UnknownHostException DGzCUN5B) {
			log.warn("Unknow host indexing page " + getURL(), DGzCUN5B);
		} catch (IOException hxqYvRUm) {
			log.warn("Unable to index page " + getURL(), hxqYvRUm);
		}
		Document cbWdFTZo = generateDocument(VkAXBbAV, W9TyFtiv);
		log.debug("END indexing page [code=" + getCode() + "]");
		return cbWdFTZo;
	}

}