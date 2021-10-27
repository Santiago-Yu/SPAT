class n16924659 {
	public static void copyFile(File C3Tivy67, File YCGd62eQ) throws IOException {
		InputStream twtmIBOp = new FileInputStream(C3Tivy67);
		OutputStream KDBcyfZM = new FileOutputStream(YCGd62eQ);
		byte[] p4ZeNKpo = new byte[1024];
		int DfIp9WAK;
		while ((DfIp9WAK = twtmIBOp.read(p4ZeNKpo)) > 0)
			KDBcyfZM.write(p4ZeNKpo, 0, DfIp9WAK);
		twtmIBOp.close();
		KDBcyfZM.close();
	}

}