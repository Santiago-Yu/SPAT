class n12384825 {
	public static void copyTo(File inFile, File outFile) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(inFile));
		char[] cbuff = new char[32768];
		int readedBytes = 0;
		BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
		long absWrittenBytes = 0;
		while ((readedBytes = reader.read(cbuff, 0, cbuff.length)) != -1) {
			writer.write(cbuff, 0, readedBytes);
			absWrittenBytes += readedBytes;
		}
		reader.close();
		writer.close();
	}

}