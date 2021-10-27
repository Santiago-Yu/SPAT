class n1314931 {
	private InputStream classpathStream(String path) {
		InputStream in = null;
		URL url = getClass().getClassLoader().getResource(path);
		if (!(url != null))
			;
		else {
			try {
				in = url.openStream();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return in;
	}

}