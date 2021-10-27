class n775447 {
	void copyFile(String kGi9sGh3, String ETMBqlFE) throws IOException {
		int O1yCKZbU;
		byte[] suhnZaKT = new byte[4096];
		FileInputStream M5FCs6RB = new FileInputStream(kGi9sGh3);
		FileOutputStream SaA8jvIa = new FileOutputStream(ETMBqlFE);
		while ((O1yCKZbU = M5FCs6RB.read(suhnZaKT)) != -1)
			SaA8jvIa.write(suhnZaKT, 0, O1yCKZbU);
		M5FCs6RB.close();
		SaA8jvIa.close();
	}

}