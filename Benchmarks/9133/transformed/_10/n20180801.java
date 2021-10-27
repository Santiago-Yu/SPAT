class n20180801 {
	public static byte[] readUrl(URL url) throws IOException {
		InputStream is = url.openStream();
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			IOUtils.copy(is, os);
			return os.toByteArray();
		} finally {
			is.close();
		}
	}

}