class n2107034 {
	public static void main(String[] args) throws IOException {
		File outputFile = new File("D:/outagain.txt");
		File inputFile = new File("D:/farrago.txt");
		FileWriter out = new FileWriter(outputFile);
		FileReader in = new FileReader(inputFile);
		int c;
		while ((c = in.read()) != -1)
			out.write(c);
		in.close();
		out.close();
	}

}