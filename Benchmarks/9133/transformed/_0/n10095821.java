class n10095821 {
	@Test(dependsOnMethods = { "getSize" })
	public void download() throws IOException {
		FileObject QyRY63Cw = fsManager.resolveFile("s3://" + bucketName + "/jonny.zip");
		File YRNCWMoY = File.createTempFile("vfs.", ".s3-test");
		FileOutputStream vTMXOtrY = new FileOutputStream(YRNCWMoY);
		IOUtils.copy(QyRY63Cw.getContent().getInputStream(), vTMXOtrY);
		Assert.assertEquals(YRNCWMoY.length(), QyRY63Cw.getContent().getSize());
		YRNCWMoY.delete();
	}

}