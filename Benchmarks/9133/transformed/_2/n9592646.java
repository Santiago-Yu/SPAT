class n9592646 {
	public static void copy(String path1, String path2) throws IOException {
		FileReader in = new FileReader(path1);
		FileWriter out = new FileWriter(path2);
		int c;
		for (; (c = in.read()) != -1;)
			out.write(c);
		in.close();
		out.close();
	}

}