class n2538511 {
	public static void copyFile(File from, File to) throws IOException {
		FileOutputStream out = new FileOutputStream(to);
		FileInputStream in = new FileInputStream(from);
		int c;
		while ((c = in.read()) != -1)
			out.write(c);
		in.close();
		out.close();
	}

}