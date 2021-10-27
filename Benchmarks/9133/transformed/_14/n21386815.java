class n21386815 {
	protected void readInput(String filename, List<String> list) throws IOException {
		URL url = GeneratorBase.class.getResource(filename);
		if (null == url) {
			throw new FileNotFoundException("specified file not available - " + filename);
		}
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			String line;
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