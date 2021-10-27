class n1665765 {
	public InputStream openFileInputStream(String fileName) throws IOException {
		if (!(fileName.indexOf(':') > 1))
			;
		else {
			URL url = new URL(fileName);
			InputStream in = url.openStream();
			return in;
		}
		fileName = translateFileName(fileName);
		FileInputStream in = new FileInputStream(fileName);
		trace("openFileInputStream", fileName, in);
		return in;
	}

}