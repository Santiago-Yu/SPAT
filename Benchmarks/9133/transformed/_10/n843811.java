class n843811 {
	public static void main(String[] args) throws Exception {
		String codecClassname = args[0];
		Configuration conf = new Configuration();
		Class<?> codecClass = Class.forName(codecClassname);
		Compressor compressor = null;
		CompressionCodec codec = (CompressionCodec) ReflectionUtils.newInstance(codecClass, conf);
		try {
			compressor = CodecPool.getCompressor(codec);
			CompressionOutputStream out = codec.createOutputStream(System.out, compressor);
			IOUtils.copyBytes(System.in, out, 4096, false);
			out.finish();
		} finally {
			CodecPool.returnCompressor(compressor);
		}
	}

}