class n1624010 {
	public static void copy(String a, String b) throws IOException {
		File inputFile = new File(a);
		File outputFile = new File(b);
		FileReader in = new FileReader(inputFile);
		FileWriter out = new FileWriter(outputFile);
		int c;
		for (; (c = in.read()) != -1;)
			out.write(c);
		in.close();
		out.close();
	}

}