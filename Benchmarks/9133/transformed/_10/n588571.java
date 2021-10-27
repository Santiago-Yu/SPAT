class n588571 {
	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		String uri = args[0];
		InputStream in = null;
		FileSystem fs = FileSystem.get(URI.create(uri), conf);
		try {
			in = fs.open(new Path(uri));
			IOUtils.copyBytes(in, System.out, 4096, false);
		} finally {
			IOUtils.closeStream(in);
		}
	}

}