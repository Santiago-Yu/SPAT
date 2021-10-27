class n13879984 {
	public static String readFromURL(String urlStr) throws IOException {
		URL url = new URL(urlStr);
		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		String inputLine;
		for (; (inputLine = in.readLine()) != null;) {
			sb.append(inputLine);
		}
		in.close();
		return sb.toString();
	}

}