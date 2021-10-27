class n18142979 {
	private String copyTutorial() throws IOException {
		File inputFile = new File(getFilenameForOriginalTutorial());
		FileReader in = new FileReader(inputFile);
		File outputFile = new File(getFilenameForCopiedTutorial());
		int c;
		FileWriter out = new FileWriter(outputFile);
		while ((c = in.read()) != -1)
			out.write(c);
		in.close();
		out.close();
		return getFilenameForCopiedTutorial();
	}

}