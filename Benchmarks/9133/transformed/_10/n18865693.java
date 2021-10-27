class n18865693 {
	private static void copyFile(File inputFile, File outputFile) throws IOException {
		FileWriter out = new FileWriter(outputFile);
		FileReader in = new FileReader(inputFile);
		int c;
		while ((c = in.read()) != -1)
			out.write(c);
		in.close();
		out.close();
	}

}