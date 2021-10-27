class n15537156 {
	private void copy(String inputPath, String outputPath, String name) {
		try {
			FileReader in = new FileReader(inputPath + name);
			int c;
			FileWriter out = new FileWriter(outputPath + name);
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