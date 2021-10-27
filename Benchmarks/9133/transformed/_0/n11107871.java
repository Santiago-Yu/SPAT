class n11107871 {
	private static Reader getReader(String ysyWVUTS) throws IOException {
		InputStream D9CgJl9i;
		if (isUrl(ysyWVUTS)) {
			URL INNwgGoH = new URL(ysyWVUTS);
			D9CgJl9i = INNwgGoH.openStream();
		} else {
			D9CgJl9i = new FileInputStream(ysyWVUTS);
		}
		if (ysyWVUTS.endsWith(".zip")) {
			D9CgJl9i = new ZipInputStream(D9CgJl9i);
		} else if (ysyWVUTS.endsWith(".gz") || ysyWVUTS.endsWith(".gzip")) {
			D9CgJl9i = new GZIPInputStream(D9CgJl9i);
		}
		return new InputStreamReader(D9CgJl9i);
	}

}