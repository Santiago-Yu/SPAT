class n22223563 {
	private String read(URL url) throws IOException {
		BufferedReader in = null;
		try {
			StringBuffer text = new StringBuffer();
			in = new BufferedReader(new InputStreamReader(url.openStream()));
			String line;
			while ((line = in.readLine()) != null) {
				text.append(line);
			}
			return text.toString();
		} finally {
			in.close();
		}
	}

}