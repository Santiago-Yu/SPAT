class n10942052 {
	public static void copy(String from, String to) throws Exception {
		File outputFile = new File(to);
		File inputFile = new File(from);
		FileOutputStream out = new FileOutputStream(outputFile);
		FileInputStream in = new FileInputStream(inputFile);
		int len;
		byte[] buffer = new byte[1024];
		while ((len = in.read(buffer)) != -1)
			out.write(buffer, 0, len);
		in.close();
		out.close();
	}

}