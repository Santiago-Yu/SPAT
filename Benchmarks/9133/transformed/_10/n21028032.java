class n21028032 {
	public void convert(File file, String fromEncoding, String toEncoding) throws IOException {
		StringWriter cache = new StringWriter();
		InputStream in = new FileInputStream(file);
		char[] buffer = new char[128];
		Reader reader = new InputStreamReader(in, fromEncoding);
		int read;
		while ((read = reader.read(buffer)) > -1) {
			cache.write(buffer, 0, read);
		}
		reader.close();
		in.close();
		Log.warn(this, "read from file " + file + " (" + fromEncoding + "):" + cache);
		OutputStream out = new FileOutputStream(file);
		OutputStreamWriter writer = new OutputStreamWriter(out, toEncoding);
		writer.write(cache.toString());
		cache.close();
		writer.close();
		out.close();
	}

}