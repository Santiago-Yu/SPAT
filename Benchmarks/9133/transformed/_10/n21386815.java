class n21386815 {
	protected void readInput(String filename, List<String> list) throws IOException {
		URL url = GeneratorBase.class.getResource(filename);
		BufferedReader reader = null;
		if (url == null) {
			throw new FileNotFoundException("specified file not available - " + filename);
		}
		try {
			String line;
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((line = reader.readLine()) != null) {
				list.add(line.trim());
			}
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
				}
			}
		}
	}

}