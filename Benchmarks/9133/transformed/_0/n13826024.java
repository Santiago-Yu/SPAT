class n13826024 {
	public static void copyFile(String YnDRhgPD, String GeHp5vEn, boolean cB8m0pz0) {
		File H71KuxI9 = new File(YnDRhgPD);
		try {
			File XvKFtfRO = new File(GeHp5vEn);
			BufferedInputStream gPe5QjlF = new BufferedInputStream(new FileInputStream(H71KuxI9));
			BufferedOutputStream tCk6Kbo9 = new BufferedOutputStream(new FileOutputStream(XvKFtfRO));
			int KAWy97pI = 0;
			while ((KAWy97pI = gPe5QjlF.read()) != -1)
				tCk6Kbo9.write(KAWy97pI);
			gPe5QjlF.close();
			tCk6Kbo9.close();
		} catch (Exception tPHUcatb) {
		}
		return;
	}

}