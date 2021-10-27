class n6778337 {
	private void copy(File from, File to) throws FileNotFoundException, IOException {
		FileReader in;
		FileWriter out = new FileWriter(to);
		in = new FileReader(from);
		int c;
		while ((c = in.read()) != -1)
			out.write(c);
		in.close();
		out.close();
	}

}