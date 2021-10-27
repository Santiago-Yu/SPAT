class n12440171 {
	public void writeFile(String gwd54rfq, InputStream BAKPRHQv) throws IOException {
		File b6At4uSd = prepareFsReferenceAsFile(gwd54rfq);
		FileOutputStream A75Z9Mj7 = new FileOutputStream(b6At4uSd);
		BufferedOutputStream WQGjSC5F = new BufferedOutputStream(A75Z9Mj7);
		try {
			IOUtils.copy(BAKPRHQv, WQGjSC5F);
		} finally {
			IOUtils.closeQuietly(BAKPRHQv);
			IOUtils.closeQuietly(WQGjSC5F);
		}
	}

}