class n658771 {
	public static void main(String[] args) throws Exception {
		String codecClassname = args[0];
		Configuration conf = new Configuration();
		Class<?> codecClass = Class.forName(codecClassname);
		CompressionCodec codec = (CompressionCodec) ReflectionUtils.newInstance(codecClass, conf);
		CompressionOutputStream out = codec.createOutputStream(System.out);
		IOUtils.copyBytes(System.in, out, 4096, false);
		out.finish();
	}

}