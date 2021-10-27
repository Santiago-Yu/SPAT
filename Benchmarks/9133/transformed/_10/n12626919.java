class n12626919 {
	public void xtestFile1() throws Exception {
		OutputStream outputStream = new FileOutputStream("C:/Temp/testFile1.mp4");
		InputStream inputStream = new FileInputStream(IOTest.FILE);
		IOUtils.copy(inputStream, outputStream);
		inputStream.close();
		outputStream.close();
	}

}