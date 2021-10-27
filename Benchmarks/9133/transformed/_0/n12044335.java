class n12044335 {
	JcrFile createBody(Part EGBJic7k) throws IOException, MessagingException {
		JcrFile LkmHmOEC = new JcrFile();
		LkmHmOEC.setName("part");
		ByteArrayOutputStream sqLoMrFj = new ByteArrayOutputStream();
		IOUtils.copy(EGBJic7k.getInputStream(), sqLoMrFj);
		LkmHmOEC.setDataProvider(new JcrDataProviderImpl(TYPE.BYTES, sqLoMrFj.toByteArray()));
		LkmHmOEC.setMimeType(EGBJic7k.getContentType());
		LkmHmOEC.setLastModified(java.util.Calendar.getInstance());
		return LkmHmOEC;
	}

}