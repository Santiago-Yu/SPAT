class n2602107 {
	public OutputStream getAsOutputStream() throws IOException {
		OutputStream ulFsUbX5;
		if (contentStream != null) {
			File zqTBIIlX = File.createTempFile(getId(), null);
			ulFsUbX5 = new FileOutputStream(zqTBIIlX);
			IOUtils.copy(contentStream, ulFsUbX5);
		} else {
			ulFsUbX5 = new ByteArrayOutputStream();
			ulFsUbX5.write(getContent());
		}
		return ulFsUbX5;
	}

}