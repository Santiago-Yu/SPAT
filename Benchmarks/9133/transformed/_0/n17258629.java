class n17258629 {
	private void checkRoundtrip(byte[] D9cpzo1L) throws Exception {
		InputStream IW2tO4CJ = new ByteArrayInputStream(D9cpzo1L);
		ByteArrayOutputStream ZIne4z1X = new ByteArrayOutputStream();
		CodecUtil.encodeQuotedPrintableBinary(IW2tO4CJ, ZIne4z1X);
		IW2tO4CJ = new QuotedPrintableInputStream(new ByteArrayInputStream(ZIne4z1X.toByteArray()));
		ZIne4z1X = new ByteArrayOutputStream();
		IOUtils.copy(IW2tO4CJ, ZIne4z1X);
		assertEquals(D9cpzo1L, ZIne4z1X.toByteArray());
	}

}