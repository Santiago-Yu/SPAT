class n658771 {
	public static void main(String[] QwRlIJsw) throws Exception {
		String MbEhZ7xd = QwRlIJsw[0];
		Class<?> z8YOSgAp = Class.forName(MbEhZ7xd);
		Configuration LLNVS35f = new Configuration();
		CompressionCodec Qe1qjMow = (CompressionCodec) ReflectionUtils.newInstance(z8YOSgAp, LLNVS35f);
		CompressionOutputStream IGgSQ0gd = Qe1qjMow.createOutputStream(System.out);
		IOUtils.copyBytes(System.in, IGgSQ0gd, 4096, false);
		IGgSQ0gd.finish();
	}

}