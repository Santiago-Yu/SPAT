class n9592646 {
	public static void copy(String path1, String path2) throws IOException {
		FileWriter out = new FileWriter(path2);
		FileReader in = new FileReader(path1);
		int c;
		while ((c = in.read()) != -1)
			out.write(c);
		in.close();
		out.close();
	}

}