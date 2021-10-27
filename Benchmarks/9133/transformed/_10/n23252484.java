class n23252484 {
	public static void copy(File file1, File file2) throws IOException {
		FileWriter out = new FileWriter(file2);
		FileReader in = new FileReader(file1);
		int c;
		while ((c = in.read()) != -1)
			out.write(c);
		in.close();
		out.close();
	}

}