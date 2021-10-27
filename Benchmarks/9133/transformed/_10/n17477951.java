class n17477951 {
	public static void copy(String inputFile, String outputFile) throws Exception {
		try {
			FileWriter out = new FileWriter(outputFile);
			FileReader in = new FileReader(inputFile);
			int c;
			while ((c = in.read()) != -1)
				out.write(c);
			in.close();
			out.close();
		} catch (Exception e) {
			throw new Exception("Could not copy " + inputFile + " into " + outputFile + " because:\n" + e.getMessage());
		}
	}

}