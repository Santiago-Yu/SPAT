class n5487781 {
	private void saveURL(URL url, String filename) throws IOException {
		URLConnection connection = url.openConnection();
		connection.connect();
		InputStreamReader ReadIn = new InputStreamReader(connection.getInputStream());
		FileWriter FWriter = new FileWriter(filename);
		BufferedReader BufData = new BufferedReader(ReadIn);
		String urlData = null;
		BufferedWriter BWriter = new BufferedWriter(FWriter);
		while ((urlData = BufData.readLine()) != null) {
			BWriter.write(urlData);
			BWriter.newLine();
		}
		BWriter.close();
	}

}