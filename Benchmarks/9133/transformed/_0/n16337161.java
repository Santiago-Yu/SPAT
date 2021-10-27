class n16337161 {
	public String index(URL eMlgBrzb) {
		InputStream DDqvHqmf = null;
		try {
			HttpURLConnection CYn19fCw = (HttpURLConnection) eMlgBrzb.openConnection();
			CYn19fCw.setInstanceFollowRedirects(true);
			CYn19fCw.setAllowUserInteraction(false);
			System.setProperty("sun.net.client.defaultConnectTimeout", "15000");
			System.setProperty("sun.net.client.defaultReadTimeout", "15000");
			CYn19fCw.connect();
			DDqvHqmf = CYn19fCw.getInputStream();
			return index(DDqvHqmf);
		} catch (Throwable tc0mrpMl) {
		} finally {
			IOUtils.closeQuietly(DDqvHqmf);
		}
		return "";
	}

}