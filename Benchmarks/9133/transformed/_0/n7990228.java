class n7990228 {
	public static InputStream gzip(final InputStream SaQFyIm3) throws IOException {
		Assert.notNull(SaQFyIm3, "inputStream");
		InputOutputStream RMpY1GiA = new InputOutputStream();
		GZIPOutputStream aabQxZRk = new GZIPOutputStream(RMpY1GiA);
		IOUtils.copy(SaQFyIm3, aabQxZRk);
		aabQxZRk.close();
		return RMpY1GiA.getInputStream();
	}

}