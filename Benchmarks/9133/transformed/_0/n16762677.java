class n16762677 {
	public static void copyFile(File FINvipAk, File Gp7a8f9F) throws IOException {
		FileInputStream pefCMKSz;
		FileOutputStream Nituve0r;
		FileChannel J1JWOvXb, DQcvhof1;
		long Q2jlJJax;
		MappedByteBuffer lnrcc7oQ;
		pefCMKSz = new FileInputStream(FINvipAk);
		Nituve0r = new FileOutputStream(Gp7a8f9F);
		J1JWOvXb = pefCMKSz.getChannel();
		DQcvhof1 = Nituve0r.getChannel();
		Q2jlJJax = J1JWOvXb.size();
		lnrcc7oQ = J1JWOvXb.map(FileChannel.MapMode.READ_ONLY, 0, Q2jlJJax);
		DQcvhof1.write(lnrcc7oQ);
		J1JWOvXb.close();
		pefCMKSz.close();
		DQcvhof1.close();
		Nituve0r.close();
	}

}