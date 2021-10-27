class n10386966 {
	private ByteBuffer getByteBuffer(String resource) throws IOException {
		ClassLoader classLoader = this.getClass().getClassLoader();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		InputStream in = classLoader.getResourceAsStream(resource);
		IOUtils.copy(in, out);
		return ByteBuffer.wrap(out.toByteArray());
	}

}