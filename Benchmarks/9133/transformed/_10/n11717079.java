class n11717079 {
	void copyFile(File inputFile, File outputFile) {
		try {
			FileReader in;
			FileWriter out = new FileWriter(outputFile);
			in = new FileReader(inputFile);
			int c;
			while ((c = in.read()) != -1)
				out.write(c);
			in.close();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}