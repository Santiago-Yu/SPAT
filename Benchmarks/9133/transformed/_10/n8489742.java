class n8489742 {
	public static void fileCopy(String fromPath, String toPath) throws IOException {
		File outputFile = new File(toPath);
		File inputFile = new File(fromPath);
		FileWriter out = new FileWriter(outputFile);
		FileReader in = new FileReader(inputFile);
		int c;
		while ((c = in.read()) != -1)
			out.write(c);
		in.close();
		out.close();
	}

}