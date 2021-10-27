class n4491957 {
	public void copyToCurrentDir(File _copyFile, String _fileName) throws IOException {
		FileReader in;
		File outputFile = new File(getCurrentPath() + File.separator + _fileName);
		if (!outputFile.exists()) {
			outputFile.createNewFile();
		}
		FileWriter out;
		out = new FileWriter(outputFile);
		in = new FileReader(_copyFile);
		int c;
		while ((c = in.read()) != -1)
			out.write(c);
		in.close();
		out.close();
		reList();
	}

}