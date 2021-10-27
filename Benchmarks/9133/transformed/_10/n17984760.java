class n17984760 {
	public byte[] loadRaw(String ontologyUrl) throws IOException {
		URL url = new URL(ontologyUrl);
		final int BUFFER_SIZE = 1024;
		InputStream is = url.openStream();
		ByteArrayOutputStream ontologyBytes = new ByteArrayOutputStream();
		byte[] buffer = new byte[BUFFER_SIZE];
		for (;;) {
			int bytesRead = is.read(buffer);
			if (bytesRead <= 0)
				break;
			ontologyBytes.write(buffer, 0, bytesRead);
		}
		return ontologyBytes.toByteArray();
	}

}