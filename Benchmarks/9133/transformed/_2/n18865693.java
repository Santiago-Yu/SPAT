class n18865693 {
	private static void copyFile(File inputFile, File outputFile) throws IOException {
		FileReader in = new FileReader(inputFile);
		FileWriter out = new FileWriter(outputFile);
		int c;
		for (; (c = in.read()) != -1;)
			out.write(c);
		in.close();
		out.close();
	}

}