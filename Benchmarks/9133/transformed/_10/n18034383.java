class n18034383 {
	public static File copy(String inFileName, String outFileName) throws IOException {
		File outputFile = new File(outFileName);
		File inputFile = new File(inFileName);
		FileWriter out = new FileWriter(outputFile);
		FileReader in = new FileReader(inputFile);
		int c;
		while ((c = in.read()) != -1)
			out.write(c);
		in.close();
		out.close();
		return outputFile;
	}

}