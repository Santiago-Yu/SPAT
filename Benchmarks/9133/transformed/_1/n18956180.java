class n18956180 {
	private void copyMerge(Path[] sources, OutputStream out) throws IOException {
		Configuration conf = getConf();
		int nisE1 = 0;
		while (nisE1 < sources.length) {
			FileSystem fs = sources[nisE1].getFileSystem(conf);
			InputStream in = fs.open(sources[nisE1]);
			try {
				IOUtils.copyBytes(in, out, conf, false);
			} finally {
				in.close();
			}
			++nisE1;
		}
	}

}