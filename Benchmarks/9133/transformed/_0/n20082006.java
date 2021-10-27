class n20082006 {
	public static void copyFile(File pBU1Yfn6, File D7d9hL1v) throws IOException {
		FileChannel k2AWOIB2 = new FileInputStream(pBU1Yfn6).getChannel();
		FileChannel cPF3UF7u = new FileOutputStream(D7d9hL1v).getChannel();
		k2AWOIB2.transferTo(0, k2AWOIB2.size(), cPF3UF7u);
		k2AWOIB2.close();
		cPF3UF7u.close();
	}

}