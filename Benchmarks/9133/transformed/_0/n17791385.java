class n17791385 {
	public static void copyFile(File QhbpposG, File FwhgKCxX) throws IOException {
		InputStream oHAB2MXh = new FileInputStream(QhbpposG);
		OutputStream JXGxI2uN = new FileOutputStream(FwhgKCxX);
		byte[] m7mZnAU2 = new byte[1024];
		int qSOcah3j;
		while ((qSOcah3j = oHAB2MXh.read(m7mZnAU2)) > 0)
			JXGxI2uN.write(m7mZnAU2, 0, qSOcah3j);
		oHAB2MXh.close();
		JXGxI2uN.close();
	}

}