class n2852141 {
	public static void copyFile(String input, String output) {
		try {
			File outputFile = new File(output);
			File inputFile = new File(input);
			FileReader in;
			FileWriter out = new FileWriter(outputFile);
			in = new FileReader(inputFile);
			int c;
			while ((c = in.read()) != -1)
				out.write(c);
			in.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}