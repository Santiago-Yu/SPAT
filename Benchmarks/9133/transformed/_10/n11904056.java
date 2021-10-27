class n11904056 {
	public static void convertEncoding(File infile, File outfile, String from, String to)
			throws IOException, UnsupportedEncodingException {
		InputStream in;
		OutputStream out;
		if (infile != null)
			in = new FileInputStream(infile);
		else
			in = System.in;
		outfile.createNewFile();
		if (outfile != null)
			out = new FileOutputStream(outfile);
		else
			out = System.out;
		if (to == null)
			to = "Unicode";
		if (from == null)
			from = System.getProperty("file.encoding");
		Writer w = new BufferedWriter(new OutputStreamWriter(out, to));
		Reader r = new BufferedReader(new InputStreamReader(in, from));
		int len;
		char[] buffer = new char[4096];
		while ((len = r.read(buffer)) != -1)
			w.write(buffer, 0, len);
		r.close();
		w.close();
	}

}