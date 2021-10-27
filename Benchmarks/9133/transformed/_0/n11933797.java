class n11933797 {
	public static void CopyFile(String wcKrDl7J, String FTADMUce) throws Exception {
		FileChannel TjdtYLZE = new FileInputStream(new File(wcKrDl7J)).getChannel();
		FileChannel BIVEvYoO = new FileOutputStream(new File(FTADMUce)).getChannel();
		TjdtYLZE.transferTo(0, TjdtYLZE.size(), BIVEvYoO);
		TjdtYLZE.close();
		BIVEvYoO.close();
	}

}