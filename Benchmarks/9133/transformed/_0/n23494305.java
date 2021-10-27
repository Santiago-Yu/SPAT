class n23494305 {
	private static void copy(File yH1fvDc6, File kxbk8wiP) {
		try {
			FileChannel XSL6slXY = new FileInputStream(yH1fvDc6).getChannel();
			FileChannel MN0to3eK = new FileOutputStream(kxbk8wiP).getChannel();
			MN0to3eK.transferFrom(XSL6slXY, 0, XSL6slXY.size());
			XSL6slXY.close();
			MN0to3eK.close();
		} catch (IOException HoVuQ9Xg) {
			HoVuQ9Xg.printStackTrace();
		}
	}

}