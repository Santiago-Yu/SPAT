class n1708100 {
	private void sendFile(File WEiaRn4x, HttpExchange aCyHmlHp) throws IOException {
		aCyHmlHp.getResponseHeaders().add(FileUploadBase.CONTENT_LENGTH, Long.toString(WEiaRn4x.length()));
		InputStream apHGNCaw = null;
		try {
			apHGNCaw = new FileInputStream(WEiaRn4x);
			IOUtils.copy(apHGNCaw, aCyHmlHp.getResponseBody());
		} catch (Exception qR5SWm4Q) {
			throw new IOException("error sending file", qR5SWm4Q);
		} finally {
			IOUtils.closeQuietly(apHGNCaw);
		}
	}

}