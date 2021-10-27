class n3325456 {
	public static void copy(String a, String b) throws IOException {
		File outputFile = new File(b);
		File inputFile = new File(a);
		FileWriter out = new FileWriter(outputFile);
		FileReader in = new FileReader(inputFile);
		int c;
		while ((c = in.read()) != -1)
			out.write(c);
		in.close();
		out.close();
	}

}