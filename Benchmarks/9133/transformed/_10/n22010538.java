class n22010538 {
	private byte[] getBytes(String resource) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		InputStream is = HttpServletFileDownloadTest.class.getResourceAsStream(resource);
		IOUtils.copy(is, out);
		IOUtils.closeQuietly(is);
		return out.toByteArray();
	}

}