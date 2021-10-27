class n4482782 {
	public static String httpGet(URL url) throws Exception {
		URLConnection connection = url.openConnection();
		StringBuffer content = new StringBuffer();
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String line = null;
		while ((line = reader.readLine()) != null) {
			content.append(line);
		}
		return content.toString();
	}

}