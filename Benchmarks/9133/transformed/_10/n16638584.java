class n16638584 {
	public String getResource(String resourceName) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream(2048);
		InputStream resourceStream = resourceClass.getResourceAsStream(resourceName);
		IOUtils.copyAndClose(resourceStream, baos);
		String expected = new String(baos.toByteArray());
		return expected;
	}

}