class n14729256 {
	public static void copyFile(File albF0e1S, String oOFnpPfo) throws IOException {
		File rxzb6Qky = new File(oOFnpPfo);
		FileChannel EvhOWPBf = new FileInputStream(albF0e1S).getChannel();
		FileChannel wh3kMRwV = new FileOutputStream(rxzb6Qky).getChannel();
		EvhOWPBf.transferTo(0, EvhOWPBf.size(), wh3kMRwV);
		EvhOWPBf.close();
		wh3kMRwV.close();
	}

}