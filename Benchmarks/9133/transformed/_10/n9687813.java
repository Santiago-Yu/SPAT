class n9687813 {
	public static InputStream getFileInputStream(String path) throws IOException {
		File file = new File(path);
		InputStream is = null;
		if (file.exists())
			is = new BufferedInputStream(new FileInputStream(file));
		if (is == null) {
			URL url = FileUtils.class.getClassLoader().getResource(path);
			is = (url == null) ? null : url.openStream();
		}
		return is;
	}

}