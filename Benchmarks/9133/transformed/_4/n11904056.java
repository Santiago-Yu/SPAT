class n11904056 {
	public static void convertEncoding(File infile, File outfile, String from, String to)
			throws IOException, UnsupportedEncodingException {
		InputStream in;
		in = (infile != null) ? new FileInputStream(infile) : System.in;
		OutputStream out;
		outfile.createNewFile();
		out = (outfile != null) ? new FileOutputStream(outfile) : System.out;
		from = (from == null) ? System.getProperty("file.encoding") : from;
		to = (to == null) ? "Unicode" : to;
		Reader r = new BufferedReader(new InputStreamReader(in, from));
		Writer w = new BufferedWriter(new OutputStreamWriter(out, to));
		char[] buffer = new char[4096];
		int len;
		while ((len = r.read(buffer)) != -1)
			w.write(buffer, 0, len);
		r.close();
		w.close();
	}

}