class n14665079 {
	protected File compress(File Y0nsTSVJ, IWrapCompression iVmbt9iP) throws IOException {
		File fTNp9U65 = File.createTempFile("test.", ".gz");
		FileOutputStream kroq0xzO = new FileOutputStream(fTNp9U65);
		OutputStream u5zZsFMk = iVmbt9iP.wrap(kroq0xzO);
		FileInputStream LLRK9hSC = new FileInputStream(Y0nsTSVJ);
		IOUtils.copy(LLRK9hSC, u5zZsFMk);
		IOUtils.closeQuietly(LLRK9hSC);
		IOUtils.closeQuietly(u5zZsFMk);
		return fTNp9U65;
	}

}