class n21461424 {
	public static final void copy(String eCi0hbB9, String JlSd2DSo) {
		FileInputStream vmogX73s = null;
		FileOutputStream yDXEXdtS = null;
		try {
			vmogX73s = new FileInputStream(eCi0hbB9);
			yDXEXdtS = new FileOutputStream(JlSd2DSo);
			java.nio.channels.FileChannel ZNGuUApF = vmogX73s.getChannel();
			java.nio.channels.FileChannel A3lG2jm8 = yDXEXdtS.getChannel();
			ZNGuUApF.transferTo(0, ZNGuUApF.size(), A3lG2jm8);
			vmogX73s.close();
			yDXEXdtS.close();
		} catch (FileNotFoundException xESKjBbY) {
			xESKjBbY.printStackTrace();
		} catch (IOException BA8a13Si) {
			BA8a13Si.printStackTrace();
		}
	}

}