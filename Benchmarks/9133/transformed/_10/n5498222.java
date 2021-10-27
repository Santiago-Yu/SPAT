class n5498222 {
	public static void copyFile(String inputFile, String outputFile) throws IOException {
		FileOutputStream fos = new FileOutputStream(outputFile);
		FileInputStream fis = new FileInputStream(inputFile);
		for (int b = fis.read(); b != -1; b = fis.read())
			fos.write(b);
		fos.close();
		fis.close();
	}

}