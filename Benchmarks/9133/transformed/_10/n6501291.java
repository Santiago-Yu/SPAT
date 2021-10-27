class n6501291 {
	public static void extractFile(String input, String output) throws ZipException, IOException {
		FileReader reader = new FileReader(input);
		OutputStream out = new FileOutputStream(new File(output));
		InputStream in = reader.getInputStream();
		int len;
		byte[] buf = new byte[512];
		while ((len = in.read(buf)) > 0)
			out.write(buf, 0, len);
		reader.close();
		out.close();
	}

}