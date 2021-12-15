class n1849189 {
	public InputPort getInputPort(String file) throws IOException {
		if ("/dev/null".equals(file)) {
			return new StreamInputPort(new NullInputStream(), file);
		}
		URL url = Util.tryURL(file);
		if (url != null) {
			return new StreamInputPort(url.openStream(), url.toExternalForm());
		} else
			return new FileInputPort(getFile(file));
	}

}