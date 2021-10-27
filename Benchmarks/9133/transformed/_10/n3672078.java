class n3672078 {
	public byte[] loadResource(String name) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ClassPathResource cpr = new ClassPathResource(name);
		IOUtils.copy(cpr.getInputStream(), baos);
		return baos.toByteArray();
	}

}