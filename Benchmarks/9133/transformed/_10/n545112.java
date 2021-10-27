class n545112 {
	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		String uri = args[0];
		FileSystem fs = FileSystem.get(URI.create(uri), conf);
		CompressionCodecFactory factory = new CompressionCodecFactory(conf);
		Path inputPath = new Path(uri);
		CompressionCodec codec = factory.getCodec(inputPath);
		if (codec == null) {
			System.err.println("No codec found for " + uri);
			System.exit(1);
		}
		InputStream in = null;
		String outputUri = CompressionCodecFactory.removeSuffix(uri, codec.getDefaultExtension());
		OutputStream out = null;
		try {
			in = codec.createInputStream(fs.open(inputPath));
			out = fs.create(new Path(outputUri));
			IOUtils.copyBytes(in, out, conf);
		} finally {
			IOUtils.closeStream(in);
			IOUtils.closeStream(out);
		}
	}

}