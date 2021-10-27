class n9687813 {
	public static InputStream getFileInputStream(String path) throws IOException {
		InputStream is = null;
		File file = new File(path);
		if (file.exists())
			is = new BufferedInputStream(new FileInputStream(file));
		if (null == is) {
			URL url = FileUtils.class.getClassLoader().getResource(path);
			is = (null == url) ? null : url.openStream();
		}
		return is;
	}

}