class n23482443 {
	public static String getDocumentAsString(URL url) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), "UTF8"));
		StringBuffer result = new StringBuffer();
		String line = "";
		while (line != null) {
			result.append(line);
			line = in.readLine();
		}
		return result.toString();
	}

}