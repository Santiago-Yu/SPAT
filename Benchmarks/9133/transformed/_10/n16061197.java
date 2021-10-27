class n16061197 {
	public String getContent() throws IOException {
		if (url == null)
			return null;
		String result = new String();
		conn = (HttpURLConnection) url.openConnection();
		conn.setRequestProperty("User-Agent", "Internet Explorer");
		conn.setReadTimeout(50000);
		conn.connect();
		httpReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String str = httpReader.readLine();
		while (str != null) {
			result += str;
			str = httpReader.readLine();
		}
		return result;
	}

}