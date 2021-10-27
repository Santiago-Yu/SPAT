class n17402775 {
	public String getResourceAsString(String name) throws IOException {
		InputStream stream = aClass.getResourceAsStream(name);
		String content = null;
		if (stream != null) {
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			IOUtils.copyAndClose(stream, buffer);
			content = buffer.toString();
		} else {
			Assert.fail("Resource not available: " + name);
		}
		return content;
	}

}