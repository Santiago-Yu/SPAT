class n11314030 {
	public static void copyFile(File StVjM0nU, File Fxjs041r) {
		if (!StVjM0nU.exists()) {
			return;
		}
		if ((Fxjs041r.getParentFile() != null) && (!Fxjs041r.getParentFile().exists())) {
			Fxjs041r.getParentFile().mkdirs();
		}
		try {
			FileChannel lcAkfvUK = new FileInputStream(StVjM0nU).getChannel();
			FileChannel DUj1BrCJ = new FileOutputStream(Fxjs041r).getChannel();
			DUj1BrCJ.transferFrom(lcAkfvUK, 0, lcAkfvUK.size());
			lcAkfvUK.close();
			DUj1BrCJ.close();
		} catch (IOException N0QwlPcu) {
			N0QwlPcu.printStackTrace();
		}
	}

}