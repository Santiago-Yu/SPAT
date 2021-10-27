class n10313620 {
	public void read(Model model, String url) {
		try {
			URLConnection conn = new URL(url).openConnection();
			String encoding = conn.getContentEncoding();
			if (null == encoding) {
				read(model, conn.getInputStream(), url);
			} else {
				read(model, new InputStreamReader(conn.getInputStream(), encoding), url);
			}
		} catch (IOException e) {
			throw new JenaException(e);
		}
	}

}