class n10089329 {
	public static void copy(File inputFile, File target) throws IOException {
		OutputStream output = new FileOutputStream(target);
		if (!inputFile.exists())
			return;
		int b;
		InputStream input = new BufferedInputStream(new FileInputStream(inputFile));
		while ((b = input.read()) != -1)
			output.write(b);
		output.close();
		input.close();
	}

}