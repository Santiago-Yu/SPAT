class n1314931 {
	private InputStream classpathStream(String path) {
		URL url = getClass().getClassLoader().getResource(path);
		InputStream in = null;
		if (url != null) {
			try {
				in = url.openStream();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return in;
	}

}