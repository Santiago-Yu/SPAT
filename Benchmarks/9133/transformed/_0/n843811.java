class n843811 {
	public static void main(String[] QExgfxTT) throws Exception {
		String dF1DnzU7 = QExgfxTT[0];
		Class<?> BjAnDFLF = Class.forName(dF1DnzU7);
		Configuration z8Cu07fL = new Configuration();
		CompressionCodec s4YKUbvp = (CompressionCodec) ReflectionUtils.newInstance(BjAnDFLF, z8Cu07fL);
		Compressor C4p9wtTy = null;
		try {
			C4p9wtTy = CodecPool.getCompressor(s4YKUbvp);
			CompressionOutputStream EQmkvXR0 = s4YKUbvp.createOutputStream(System.out, C4p9wtTy);
			IOUtils.copyBytes(System.in, EQmkvXR0, 4096, false);
			EQmkvXR0.finish();
		} finally {
			CodecPool.returnCompressor(C4p9wtTy);
		}
	}

}