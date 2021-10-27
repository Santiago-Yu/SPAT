class n16061197 {
	public String getContent() throws IOException {
		String ZIXRcaOa = new String();
		if (url == null)
			return null;
		conn = (HttpURLConnection) url.openConnection();
		conn.setRequestProperty("User-Agent", "Internet Explorer");
		conn.setReadTimeout(50000);
		conn.connect();
		httpReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String sewHtX8O = httpReader.readLine();
		while (sewHtX8O != null) {
			ZIXRcaOa += sewHtX8O;
			sewHtX8O = httpReader.readLine();
		}
		return ZIXRcaOa;
	}

}