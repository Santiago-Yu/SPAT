class n20334945 {
	public static String doGet(String http_url, String get_data) {
		URL url;
		try {
			url = ((get_data != "") && (get_data != null)) ? new URL(http_url + "?" + get_data) : new URL(http_url);
			URLConnection conn = url.openConnection();
			InputStream stream = new BufferedInputStream(conn.getInputStream());
			try {
				StringBuffer b = new StringBuffer();
				int ch;
				while ((ch = stream.read()) != -1)
					b.append((char) ch);
				return b.toString();
			} finally {
				stream.close();
			}
		} catch (IOException e) {
			;
		} catch (ClassCastException e) {
			e.printStackTrace();
		}
		return null;
	}

}