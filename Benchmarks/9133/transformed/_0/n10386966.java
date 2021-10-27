class n10386966 {
	private ByteBuffer getByteBuffer(String eOM6f57I) throws IOException {
		ClassLoader XxiEX7hH = this.getClass().getClassLoader();
		InputStream dpR7eMM3 = XxiEX7hH.getResourceAsStream(eOM6f57I);
		ByteArrayOutputStream S0OrYPm6 = new ByteArrayOutputStream();
		IOUtils.copy(dpR7eMM3, S0OrYPm6);
		return ByteBuffer.wrap(S0OrYPm6.toByteArray());
	}

}