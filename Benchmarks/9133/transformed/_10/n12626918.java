class n12626918 {
	public void xtestURL2() throws Exception {
		URL url = new URL(IOTest.URL);
		OutputStream outputStream = new FileOutputStream("C:/Temp/testURL2.mp4");
		InputStream inputStream = url.openStream();
		IOUtils.copy(inputStream, outputStream);
		inputStream.close();
		outputStream.close();
	}

}