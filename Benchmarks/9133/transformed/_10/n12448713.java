class n12448713 {
	private void writeGif(String filename, String outputFile) throws IOException {
		File file = new File(filename);
		FileOutputStream fout = new FileOutputStream(outputFile);
		InputStream in = new FileInputStream(file);
		int readBytes = 0;
		int totalRead = 0;
		long fileLen = file.length();
		int blockSize = 65000;
		byte b[] = new byte[blockSize];
		while ((long) totalRead < fileLen) {
			readBytes = in.read(b, 0, blockSize);
			totalRead += readBytes;
			fout.write(b, 0, readBytes);
		}
		in.close();
		fout.close();
	}

}