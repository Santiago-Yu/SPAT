class n17984760 {
	public byte[] loadRaw(String ontologyUrl) throws IOException {
		URL url = new URL(ontologyUrl);
		InputStream is = url.openStream();
		final int BUFFER_SIZE = 1024;
		byte[] buffer = new byte[BUFFER_SIZE];
		ByteArrayOutputStream ontologyBytes = new ByteArrayOutputStream();
		while (true) {
			int bytesRead = is.read(buffer);
			if (bytesRead <= 0)
				break;
			ontologyBytes.write(buffer, 0, bytesRead);
		}
		return ontologyBytes.toByteArray();
	}

}