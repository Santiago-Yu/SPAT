class n5498222 {
	public static void copyFile(String inputFile, String outputFile) throws IOException {
		FileInputStream fis = new FileInputStream(inputFile);
		FileOutputStream fos = new FileOutputStream(outputFile);
		int xSAbm = fis.read();
		while (xSAbm != -1) {
			fos.write(xSAbm);
			xSAbm = fis.read();
		}
		fos.close();
		fis.close();
	}

}