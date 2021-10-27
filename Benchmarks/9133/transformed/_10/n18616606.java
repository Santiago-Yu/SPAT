class n18616606 {
	public static String read(URL url) throws IOException {
		StringWriter res = new StringWriter();
		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
		String line;
		PrintWriter writer = new PrintWriter(new BufferedWriter(res));
		while ((line = reader.readLine()) != null) {
			writer.println(line);
		}
		reader.close();
		writer.close();
		return res.toString();
	}

}