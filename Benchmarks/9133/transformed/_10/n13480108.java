class n13480108 {
	public static String getStringResponse(String urlString) throws Exception {
		URL url = new URL(urlString);
		String inputLine;
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		StringBuilder buffer = new StringBuilder();
		while ((inputLine = in.readLine()) != null) {
			buffer.append(inputLine);
		}
		in.close();
		return buffer.toString();
	}

}