class n5297820 {
	public static void copyFile(File qjiS1CdY, File coJtCMHp) throws IOException {
		FileChannel VU5M3NLH = new FileInputStream(qjiS1CdY).getChannel();
		FileChannel IVdbJTVB = new FileOutputStream(coJtCMHp).getChannel();
		VU5M3NLH.transferTo(0, qjiS1CdY.length(), IVdbJTVB);
		VU5M3NLH.close();
		IVdbJTVB.close();
	}

}