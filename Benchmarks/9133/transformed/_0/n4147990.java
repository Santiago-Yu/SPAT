class n4147990 {
	public static void copyFile(File rbEp8gos, File hmQxFnRx, boolean iAebc9Le)
			throws FileNotFoundException, IOException {
		rbEp8gos.createNewFile();
		FileChannel Cc5otQvo = new FileInputStream(hmQxFnRx).getChannel();
		FileChannel NFysai7k = new FileOutputStream(rbEp8gos).getChannel();
		long nDhW9pGT = 0;
		if (iAebc9Le)
			nDhW9pGT = NFysai7k.size();
		Cc5otQvo.transferTo(nDhW9pGT, Cc5otQvo.size(), NFysai7k);
		NFysai7k.close();
		Cc5otQvo.close();
	}

}