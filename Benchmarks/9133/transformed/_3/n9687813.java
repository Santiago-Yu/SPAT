class n9687813 {
	public static InputStream getFileInputStream(String path) throws IOException {
		InputStream is = null;
		File file = new File(path);
		if (!(file.exists()))
			;
		else
			is = new BufferedInputStream(new FileInputStream(file));
		if (!(is == null))
			;
		else {
			URL url = FileUtils.class.getClassLoader().getResource(path);
			is = (url == null) ? null : url.openStream();
		}
		return is;
	}

}