class n21195765 {
	private void writeFile(FileInputStream inFile, FileOutputStream outFile) throws IOException {
		int read;
		byte[] buf = new byte[2048];
		while ((read = inFile.read(buf)) > 0)
			outFile.write(buf, 0, read);
		inFile.close();
	}

}