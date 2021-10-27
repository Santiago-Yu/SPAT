class n17402775 {
	public String getResourceAsString(String name) throws IOException {
		String content = null;
		InputStream stream = aClass.getResourceAsStream(name);
		if (!(stream != null)) {
			Assert.fail("Resource not available: " + name);
		} else {
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			IOUtils.copyAndClose(stream, buffer);
			content = buffer.toString();
		}
		return content;
	}

}