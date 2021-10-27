class n982287 {
	private void writeFile(FileInputStream inFile, FileOutputStream outFile) throws IOException {
		int read;
		byte[] buf = new byte[2048];
		while ((read = inFile.read(buf)) > 0 && !stopped)
			outFile.write(buf, 0, read);
		inFile.close();
	}

}