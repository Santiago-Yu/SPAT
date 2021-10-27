class n8403573 {
	public static void copyFile(File src, String srcEncoding, File dest, String destEncoding) throws IOException {
		OutputStreamWriter out = new OutputStreamWriter(new RobustFileOutputStream(dest), destEncoding);
		InputStreamReader in = new InputStreamReader(new FileInputStream(src), srcEncoding);
		int c;
		while ((c = in.read()) != -1)
			out.write(c);
		out.flush();
		in.close();
		out.close();
	}

}