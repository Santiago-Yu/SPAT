class n3318214 {
	void copyFile(String sInput, String sOutput) throws IOException {
		File outputFile = new File(sOutput);
		File inputFile = new File(sInput);
		FileWriter out = new FileWriter(outputFile);
		FileReader in = new FileReader(inputFile);
		int c;
		while ((c = in.read()) != -1)
			out.write(c);
		in.close();
		out.close();
	}

}