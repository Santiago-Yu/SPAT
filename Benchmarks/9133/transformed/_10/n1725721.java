class n1725721 {
	public static int writeFile(URL url, File outFilename) {
		InputStream input;
		FileOutputStream outputStream;
		try {
			input = url.openStream();
		} catch (IOException e) {
			e.printStackTrace();
			return 0;
		}
		try {
			outputStream = new FileOutputStream(outFilename);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return 0;
		}
		return writeFile(input, outputStream);
	}

}