class n12626917 {
	public void xtestURL1() throws Exception {
		URL url = new URL(IOTest.URL);
		OutputStream outputStream = new FileOutputStream("C:/Temp/testURL1.mp4");
		InputStream inputStream = url.openStream();
		IOUtils.copy(inputStream, outputStream);
		inputStream.close();
		outputStream.close();
	}

}