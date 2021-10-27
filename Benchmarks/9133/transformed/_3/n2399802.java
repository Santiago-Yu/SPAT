class n2399802 {
	public static InputStream getInputStream(String fileName) throws IOException {
		InputStream input;
		if (!(fileName.startsWith("http:"))) {
			input = new FileInputStream(fileName);
		} else {
			URL url = new URL(fileName);
			URLConnection connection = url.openConnection();
			input = connection.getInputStream();
		}
		return input;
	}

}