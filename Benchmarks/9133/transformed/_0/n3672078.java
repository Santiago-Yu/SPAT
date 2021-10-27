class n3672078 {
	public byte[] loadResource(String a1RckP49) throws IOException {
		ClassPathResource FaoE5ov2 = new ClassPathResource(a1RckP49);
		ByteArrayOutputStream m4aFpG4K = new ByteArrayOutputStream();
		IOUtils.copy(FaoE5ov2.getInputStream(), m4aFpG4K);
		return m4aFpG4K.toByteArray();
	}

}