class n6527977 {
	public static void copy(File RwQuaR8L, File PifE0ETp) throws IOException {
		FileChannel fRN7SYUz = new FileInputStream(RwQuaR8L).getChannel();
		FileChannel We1Cqwjy = new FileOutputStream(PifE0ETp).getChannel();
		fRN7SYUz.transferTo(0, fRN7SYUz.size(), We1Cqwjy);
		fRN7SYUz.close();
		We1Cqwjy.close();
	}

}