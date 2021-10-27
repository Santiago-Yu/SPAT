class n17339760 {
	public static String get_content(String _url) throws Exception {
		URL url = new URL(_url);
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		String inputLine, content = new String();
		while ((inputLine = in.readLine()) != null) {
			content += inputLine;
		}
		in.close();
		return content;
	}

}