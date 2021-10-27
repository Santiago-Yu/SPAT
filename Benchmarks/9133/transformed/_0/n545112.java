class n545112 {
	public static void main(String[] kfjXmuwR) throws Exception {
		String F77rD0lV = kfjXmuwR[0];
		Configuration jLqxEcwF = new Configuration();
		FileSystem aY4wUV8R = FileSystem.get(URI.create(F77rD0lV), jLqxEcwF);
		Path ACASJmGi = new Path(F77rD0lV);
		CompressionCodecFactory sNTX9jkI = new CompressionCodecFactory(jLqxEcwF);
		CompressionCodec Gt3qhjZX = sNTX9jkI.getCodec(ACASJmGi);
		if (Gt3qhjZX == null) {
			System.err.println("No codec found for " + F77rD0lV);
			System.exit(1);
		}
		String AWj0IIC2 = CompressionCodecFactory.removeSuffix(F77rD0lV, Gt3qhjZX.getDefaultExtension());
		InputStream qTRYUh6R = null;
		OutputStream gdpyvXdP = null;
		try {
			qTRYUh6R = Gt3qhjZX.createInputStream(aY4wUV8R.open(ACASJmGi));
			gdpyvXdP = aY4wUV8R.create(new Path(AWj0IIC2));
			IOUtils.copyBytes(qTRYUh6R, gdpyvXdP, jLqxEcwF);
		} finally {
			IOUtils.closeStream(qTRYUh6R);
			IOUtils.closeStream(gdpyvXdP);
		}
	}

}