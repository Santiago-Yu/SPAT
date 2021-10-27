class n14341904 {
	private static void copyFile(String from, String to) throws IOException {
		FileWriter out = new FileWriter(to);
		FileReader in = new FileReader(from);
		int c;
		while ((c = in.read()) != -1)
			out.write(c);
		in.close();
		out.close();
	}

}