class n13447231 {
	public void copy(String pathFileIn, String pathFileOut) {
		try {
			File outputFile = new File(pathFileOut);
			File inputFile = new File(pathFileIn);
			File outDir = new File(DirOut);
			FileReader in = new FileReader(inputFile);
			FileWriter out = new FileWriter(outputFile);
			if (!outDir.exists())
				outDir.mkdirs();
			int c;
			while ((c = in.read()) != -1)
				out.write(c);
			in.close();
			out.close();
			this.printColumn(inputFile.getName(), outputFile.getPath());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}