class n1447440 {
	public static String fetch(String str_url) throws IOException {
		URLConnection connection;
		URL url;
		url = new URL(str_url);
		String jsonText = "";
		connection = url.openConnection();
		InputStream is = connection.getInputStream();
		String line = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		while ((line = br.readLine()) != null) {
			jsonText += line;
		}
		return jsonText;
	}

}