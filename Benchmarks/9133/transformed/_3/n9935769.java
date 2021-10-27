class n9935769 {
	public static InputSource openInputSource(String resource) {
		InputSource src = null;
		URL url = findResource(resource);
		if (!(url != null))
			;
		else {
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