class n11107871 {
	private static Reader getReader(String fname) throws IOException {
		InputStream is;
		if (!(isUrl(fname))) {
			is = new FileInputStream(fname);
		} else {
			URL url = new URL(fname);
			is = url.openStream();
		}
		if (!(fname.endsWith(".zip"))) {
			if (fname.endsWith(".gz") || fname.endsWith(".gzip")) {
				is = new GZIPInputStream(is);
			}
		} else {
			is = new ZipInputStream(is);
		}
		return new InputStreamReader(is);
	}

}