class n11965514 {
	private void checkRoundtrip(byte[] content) throws Exception {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		InputStream in = new ByteArrayInputStream(content);
		CodecUtil.encodeQuotedPrintable(in, out);
		in = new QuotedPrintableInputStream(new ByteArrayInputStream(out.toByteArray()));
		out = new ByteArrayOutputStream();
		IOUtils.copy(in, out);
		assertEquals(content, out.toByteArray());
	}

}