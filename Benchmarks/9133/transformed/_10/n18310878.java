class n18310878 {
	public static void copyFile(File src, File dst) throws IOException {
		File outputFile = dst;
		File inputFile = src;
		FileWriter out = new FileWriter(outputFile);
		FileReader in = new FileReader(inputFile);
		int c;
		while ((c = in.read()) != -1)
			out.write(c);
		in.close();
		out.close();
	}

}