class n16012363 {
	public static void main(String[] args) throws IOException {
		Configuration conf = new Configuration();
		String uri = "hdfs://localhost:8020/user/leeing/maxtemp/sample.txt";
		InputStream in = null;
		FileSystem fs = FileSystem.get(URI.create(uri), conf);
		try {
			in = fs.open(new Path(uri));
			IOUtils.copyBytes(in, System.out, 8192, false);
		} finally {
			IOUtils.closeStream(in);
		}
	}

}