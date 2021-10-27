class n13879984 {
	public static String readFromURL(String urlStr) throws IOException {
		StringBuilder sb = new StringBuilder();
		URL url = new URL(urlStr);
		String inputLine;
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		while ((inputLine = in.readLine()) != null) {
			sb.append(inputLine);
		}
		in.close();
		return sb.toString();
	}

}