class n14665079 {
	protected File compress(File orig, IWrapCompression wrapper) throws IOException {
		File compressed = File.createTempFile("test.", ".gz");
		FileOutputStream fos = new FileOutputStream(compressed);
		FileInputStream fis = new FileInputStream(orig);
		OutputStream wos = wrapper.wrap(fos);
		IOUtils.copy(fis, wos);
		IOUtils.closeQuietly(fis);
		IOUtils.closeQuietly(wos);
		return compressed;
	}

}