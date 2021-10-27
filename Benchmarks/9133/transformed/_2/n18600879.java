class n18600879 {
	public static void copyFile(File input, File output) throws Exception {
		FileReader in = new FileReader(input);
		FileWriter out = new FileWriter(output);
		int c;
		for (; (c = in.read()) != -1;)
			out.write(c);
		in.close();
		out.close();
	}

}