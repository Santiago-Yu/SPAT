class n12236729 {
	private void copy(File inputFile, File outputFile) throws Exception {
		FileReader in = new FileReader(inputFile);
		FileWriter out = new FileWriter(outputFile);
		int c;
		for (; (c = in.read()) != -1;)
			out.write(c);
		in.close();
		out.close();
	}

}