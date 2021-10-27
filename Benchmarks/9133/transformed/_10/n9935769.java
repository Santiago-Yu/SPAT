class n9935769 {
	public static InputSource openInputSource(String resource) {
		URL url = findResource(resource);
		InputSource src = null;
		if (url != null) {
			try {
				InputStream in = url.openStream();
				src = new InputSource(in);
				src.setSystemId(url.toExternalForm());
			} catch (IOException e) {
			}
		}
		return src;
	}

}