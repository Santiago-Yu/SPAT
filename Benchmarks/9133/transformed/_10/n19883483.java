class n19883483 {
	public static void copy(String file1, String file2) throws IOException {
		File outputFile = new File(file2);
		File inputFile = new File(file1);
		FileWriter out = new FileWriter(outputFile);
		FileReader in = new FileReader(inputFile);
		System.out.println("Copy file from: " + file1 + " to: " + file2);
		int c;
		while ((c = in.read()) != -1)
			out.write(c);
		in.close();
		out.close();
	}

}