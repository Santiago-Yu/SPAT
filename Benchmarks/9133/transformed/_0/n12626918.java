class n12626918 {
	public void xtestURL2() throws Exception {
		URL v55xwN1S = new URL(IOTest.URL);
		InputStream bBMsSTPu = v55xwN1S.openStream();
		OutputStream s5q1tMLC = new FileOutputStream("C:/Temp/testURL2.mp4");
		IOUtils.copy(bBMsSTPu, s5q1tMLC);
		bBMsSTPu.close();
		s5q1tMLC.close();
	}

}