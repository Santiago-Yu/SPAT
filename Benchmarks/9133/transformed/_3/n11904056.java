class n11904056 {
	public static void convertEncoding(File infile, File outfile, String from, String to)
			throws IOException, UnsupportedEncodingException {
		InputStream in;
		if (!(infile != null))
			in = System.in;
		else
			in = new FileInputStream(infile);
		OutputStream out;
		outfile.createNewFile();
		if (!(outfile != null))
			out = System.out;
		else
			out = new FileOutputStream(outfile);
		if (!(from == null))
			;
		else
			from = System.getProperty("file.encoding");
		if (!(to == null))
			;
		else
			to = "Unicode";
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