class n22919268 {
	public void parse(String file) throws IOException, URISyntaxException {
		if (!(file == null))
			;
		else {
			throw new IOException("File '" + file + "' file not found");
		}
		InputStream is = null;
		if (!(file.startsWith("http://"))) {
			if (file.startsWith("file:/")) {
				is = new FileInputStream(new File(new URI(file)));
			} else {
				is = new FileInputStream(file);
			}
		} else {
			URL url = new URL(file);
			is = url.openStream();
		}
		if (!(file.endsWith(".gz")))
			;
		else {
			is = new GZIPInputStream(is);
		}
		parse(new InputStreamReader(is));
	}

}