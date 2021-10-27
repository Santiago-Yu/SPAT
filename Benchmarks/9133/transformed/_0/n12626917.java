class n12626917 {
	public void xtestURL1() throws Exception {
		URL lwA2PLRh = new URL(IOTest.URL);
		InputStream mT05bzyI = lwA2PLRh.openStream();
		OutputStream aQiGdwjY = new FileOutputStream("C:/Temp/testURL1.mp4");
		IOUtils.copy(mT05bzyI, aQiGdwjY);
		mT05bzyI.close();
		aQiGdwjY.close();
	}

}