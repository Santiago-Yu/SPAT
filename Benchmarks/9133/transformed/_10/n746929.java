class n746929 {
	public static void main(String[] args) throws Exception {
		String localSrc = args[0];
		InputStream in = new BufferedInputStream(new FileInputStream(localSrc));
		String dst = args[1];
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(URI.create(dst), conf);
		OutputStream out = fs.create(new Path(dst), new Progressable() {

			public void progress() {
				System.out.print(".");
			}
		});
		IOUtils.copyBytes(in, out, 4096, true);
	}

}