class n18991846 {
	public static void copyFile(File aVMB6vP1, File hBBJr9cm) throws Exception {
		hBBJr9cm.getParentFile().mkdirs();
		hBBJr9cm.createNewFile();
		FileChannel lHRJTuAU = new FileInputStream(aVMB6vP1).getChannel();
		FileChannel jaBELUlc = new FileOutputStream(hBBJr9cm).getChannel();
		jaBELUlc.transferFrom(lHRJTuAU, 0, lHRJTuAU.size());
		lHRJTuAU.close();
		jaBELUlc.close();
	}

}