class n11107871 {
	private static Reader getReader(String fname) throws IOException {
		InputStream is;
		if (isUrl(fname)) {
			URL url = new URL(fname);
			is = url.openStream();
		} else {
			is = new FileInputStream(fname);
		}
		if (fname.endsWith(".zip")) {
			is = new ZipInputStream(is);
		} else
			is = (fname.endsWith(".gz") || fname.endsWith(".gzip")) ? new GZIPInputStream(is) : is;
		return new InputStreamReader(is);
	}

}