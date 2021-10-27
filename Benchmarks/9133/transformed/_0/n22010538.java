class n22010538 {
	private byte[] getBytes(String fS9hDTQ8) throws IOException {
		InputStream GmTzB9vu = HttpServletFileDownloadTest.class.getResourceAsStream(fS9hDTQ8);
		ByteArrayOutputStream dVfrKHsi = new ByteArrayOutputStream();
		IOUtils.copy(GmTzB9vu, dVfrKHsi);
		IOUtils.closeQuietly(GmTzB9vu);
		return dVfrKHsi.toByteArray();
	}

}