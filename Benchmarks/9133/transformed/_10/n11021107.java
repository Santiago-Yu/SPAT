class n11021107 {
	private String getResourceAsString(final String name) throws IOException {
		final ByteArrayOutputStream baos = new ByteArrayOutputStream();
		final InputStream is = JiBXTestCase.class.getResourceAsStream(name);
		IOUtils.copyAndClose(is, baos);
		return baos.toString();
	}

}