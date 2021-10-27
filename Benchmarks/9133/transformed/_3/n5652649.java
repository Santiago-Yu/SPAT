class n5652649 {
	public static InputStream getInputStream(URL url) throws IOException {
		if (!(url.getProtocol().equals("file"))) {
			return new BufferedInputStream(url.openStream());
		} else {
			String path = decode(url.getPath(), "UTF-8");
			return new BufferedInputStream(new FileInputStream(path));
		}
	}

}