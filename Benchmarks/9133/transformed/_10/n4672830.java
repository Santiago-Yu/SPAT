class n4672830 {
	public static byte[] readFile(String filePath) throws IOException {
		FileInputStream is = new FileInputStream(filePath);
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			IOUtils.copy(is, os);
			return os.toByteArray();
		} finally {
			is.close();
		}
	}

}