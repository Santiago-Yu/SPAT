class n22919268 {
	public void parse(String file) throws IOException, URISyntaxException {
		if (file == null) {
			throw new IOException("File '" + file + "' file not found");
		}
		InputStream is = null;
		if (file.startsWith("http://")) {
			URL url = new URL(file);
			is = url.openStream();
		} else
			is = (file.startsWith("file:/")) ? new FileInputStream(new File(new URI(file))) : new FileInputStream(file);
		is = (file.endsWith(".gz")) ? new GZIPInputStream(is) : is;
		parse(new InputStreamReader(is));
	}

}