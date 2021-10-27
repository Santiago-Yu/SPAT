class n12626920 {
	public void xtestFile2() throws Exception {
		OutputStream outputStream = new FileOutputStream("C:/Temp/testFile2.mp4");
		InputStream inputStream = new FileInputStream(IOTest.FILE);
		IOUtils.copy(inputStream, outputStream);
		inputStream.close();
		outputStream.close();
	}

}