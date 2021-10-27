class n19738435 {
	public Resource parse(URL url, IRDFContainer target) throws RDFException, IOException {
		parseURL = url;
		URLConnection connection = url.openConnection();
		charset = (charset == null) ? Charset.forName("UTF-8") : charset;
		Reader reader = new InputStreamReader(connection.getInputStream(), charset);
		return internalParse(reader, target);
	}

}