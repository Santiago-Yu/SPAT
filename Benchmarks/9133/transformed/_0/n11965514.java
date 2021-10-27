class n11965514 {
	private void checkRoundtrip(byte[] nzHisvMo) throws Exception {
		InputStream DPdWNYAr = new ByteArrayInputStream(nzHisvMo);
		ByteArrayOutputStream nbFmtfQW = new ByteArrayOutputStream();
		CodecUtil.encodeQuotedPrintable(DPdWNYAr, nbFmtfQW);
		DPdWNYAr = new QuotedPrintableInputStream(new ByteArrayInputStream(nbFmtfQW.toByteArray()));
		nbFmtfQW = new ByteArrayOutputStream();
		IOUtils.copy(DPdWNYAr, nbFmtfQW);
		assertEquals(nzHisvMo, nbFmtfQW.toByteArray());
	}

}