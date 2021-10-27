class n9687813 {
	public static InputStream getFileInputStream(String path) throws IOException {
		InputStream is = null;
		File file = new File(path);
		if (file.exists())
			is = new BufferedInputStream(new FileInputStream(file));
		if (is == null) {
			URL url = FileUtils.class.getClassLoader().getResource(path);
			if ((url == null))
				is = null;
			else
				is = url.openStream();
		}
		return is;
	}

}