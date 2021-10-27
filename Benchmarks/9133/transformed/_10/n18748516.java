class n18748516 {
	public static void copy(String fromFile, String toFile) throws IOException {
		File outputFile = new File(toFile);
		File inputFile = new File(fromFile);
		FileWriter out = new FileWriter(outputFile);
		FileReader in = new FileReader(inputFile);
		int c;
		while ((c = in.read()) != -1)
			out.write(c);
		in.close();
		out.close();
	}

}