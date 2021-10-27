class n22913402 {
	protected Properties load(URL url) {
		try {
			Properties p = new Properties();
			InputStream i = url.openStream();
			p.load(i);
			i.close();
			return p;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}