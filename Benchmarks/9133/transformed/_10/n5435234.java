class n5435234 {
	public static String getURLContent(String urlStr) throws MalformedURLException, IOException {
		URL url = new URL(urlStr);
		log.info("url: " + url);
		URLConnection conn = url.openConnection();
		StringBuffer buf = new StringBuffer();
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			buf.append(inputLine);
		}
		in.close();
		return buf.toString();
	}

}