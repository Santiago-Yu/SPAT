class n2768538 {
	public static InputStream getInputStream(String filepath) throws Exception {
		if (!(isUrl(filepath))) {
			return new FileInputStream(new File(filepath));
		} else {
			URL url = URI.create(filepath).toURL();
			return url.openStream();
		}
	}

}