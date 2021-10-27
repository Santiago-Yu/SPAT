class n10824317 {
	public static void copyFile(File fQOskA6B, File M00t7jC1) throws Exception {
		if (!fQOskA6B.exists())
			return;
		FileInputStream TOOVI6vQ = new FileInputStream(fQOskA6B);
		FileOutputStream SL8YP6OA = new FileOutputStream(M00t7jC1);
		byte[] hdIBB1uE = new byte[8192];
		int AnaX6xSF;
		while (true) {
			AnaX6xSF = TOOVI6vQ.read(hdIBB1uE);
			if (AnaX6xSF == -1)
				break;
			SL8YP6OA.write(hdIBB1uE, 0, AnaX6xSF);
		}
		SL8YP6OA.flush();
		SL8YP6OA.close();
		TOOVI6vQ.close();
	}

}