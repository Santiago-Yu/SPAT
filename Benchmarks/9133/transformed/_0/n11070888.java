class n11070888 {
	public static void copyFile(File KDSMchpQ, File yISWsbNt) throws FileNotFoundException, IOException {
		DataInputStream Za7UxKhZ = new DataInputStream(new BufferedInputStream(new FileInputStream(KDSMchpQ)));
		DataOutputStream garGxZWW = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(yISWsbNt)));
		byte[] pAi272h8 = new byte[1024];
		int fblFgW1Y;
		while ((fblFgW1Y = Za7UxKhZ.read(pAi272h8)) > 0) {
			garGxZWW.write(pAi272h8, 0, fblFgW1Y);
		}
		Za7UxKhZ.close();
		garGxZWW.close();
	}

}