class n18600879 {
	public static void copyFile(File input, File output) throws Exception {
		FileWriter out = new FileWriter(output);
		FileReader in = new FileReader(input);
		int c;
		while ((c = in.read()) != -1)
			out.write(c);
		in.close();
		out.close();
	}

}