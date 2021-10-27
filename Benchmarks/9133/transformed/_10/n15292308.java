class n15292308 {
	private static File createFileFromURL(URL url) throws IOException {
		File tempFile = File.createTempFile("oboFile", ".obo");
		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
		PrintStream ps = new PrintStream(tempFile);
		String line;
		while ((line = reader.readLine()) != null) {
			ps.println(line);
		}
		ps.close();
		return tempFile;
	}

}