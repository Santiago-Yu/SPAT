class n3156435 {
	public static void fileCopy(File GJ0CdzW9, File StJrfHPD) throws FileNotFoundException, IOException {
		if (GJ0CdzW9.isDirectory() && (!StJrfHPD.exists() || StJrfHPD.isDirectory())) {
			if (!StJrfHPD.exists()) {
				if (!StJrfHPD.mkdirs())
					throw new IOException("unable to mkdir " + StJrfHPD);
			}
			File UZ1GsEmI = new File(StJrfHPD, GJ0CdzW9.getName());
			if (!UZ1GsEmI.exists() && !UZ1GsEmI.mkdir())
				throw new IOException("unable to mkdir " + UZ1GsEmI);
			StJrfHPD = UZ1GsEmI;
			File[] Ea99HA88 = GJ0CdzW9.listFiles();
			for (File BzVOtD01 : Ea99HA88) {
				if (BzVOtD01.isDirectory()) {
					UZ1GsEmI = new File(StJrfHPD, BzVOtD01.getName());
					if (!UZ1GsEmI.exists() && !UZ1GsEmI.mkdir())
						throw new IOException("unable to mkdir " + UZ1GsEmI);
				} else {
					UZ1GsEmI = StJrfHPD;
				}
				fileCopy(BzVOtD01, UZ1GsEmI);
			}
			return;
		} else if (StJrfHPD.isDirectory()) {
			StJrfHPD = new File(StJrfHPD, GJ0CdzW9.getName());
		}
		FileChannel xoHkqVLa = new FileInputStream(GJ0CdzW9).getChannel();
		FileChannel fHftyZpp = new FileOutputStream(StJrfHPD).getChannel();
		xoHkqVLa.transferTo(0, xoHkqVLa.size(), fHftyZpp);
		xoHkqVLa.close();
		fHftyZpp.close();
	}

}