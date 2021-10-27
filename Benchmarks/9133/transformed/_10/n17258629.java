class n17258629 {
	private void checkRoundtrip(byte[] content) throws Exception {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		InputStream in = new ByteArrayInputStream(content);
		CodecUtil.encodeQuotedPrintableBinary(in, out);
		in = new QuotedPrintableInputStream(new ByteArrayInputStream(out.toByteArray()));
		out = new ByteArrayOutputStream();
		IOUtils.copy(in, out);
		assertEquals(content, out.toByteArray());
	}

}