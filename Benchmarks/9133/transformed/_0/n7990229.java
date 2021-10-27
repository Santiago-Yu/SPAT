class n7990229 {
	public static InputStream gunzip(final InputStream oPJAsauh) throws IOException {
		Assert.notNull(oPJAsauh, "inputStream");
		GZIPInputStream hUdSn2Ro = new GZIPInputStream(oPJAsauh);
		InputOutputStream WFPpl0K5 = new InputOutputStream();
		IOUtils.copy(hUdSn2Ro, WFPpl0K5);
		return WFPpl0K5.getInputStream();
	}

}