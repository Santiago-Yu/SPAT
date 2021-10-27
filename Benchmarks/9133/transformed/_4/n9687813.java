class n9687813 {
	public static InputStream getFileInputStream(String path) throws IOException {
		InputStream is = null;
		File file = new File(path);
		is = (file.exists()) ? new BufferedInputStream(new FileInputStream(file)) : is;
		if (is == null) {
			URL url = FileUtils.class.getClassLoader().getResource(path);
			is = (url == null) ? null : url.openStream();
		}
		return is;
	}

}