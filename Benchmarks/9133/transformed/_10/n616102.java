class n616102 {
	void copyFileAscii(String src, String dest) {
		try {
			File outputFile = new File(dest);
			File inputFile = new File(src);
			FileWriter out = new FileWriter(outputFile);
			FileReader in = new FileReader(inputFile);
			int c;
			while ((c = in.read()) != -1)
				out.write(c);
			in.close();
			out.close();
		} catch (Exception ex) {
			System.err.println(ex.toString());
		}
	}

}