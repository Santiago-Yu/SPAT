class n6844411 {
	public static void copyFileTo(String FQvcRiVF, String HL22mf6P) {
		if (FQvcRiVF == null || HL22mf6P == null)
			throw new IllegalArgumentException("Argument cannot be null.");
		try {
			FileInputStream hDF7uWHm = null;
			FileOutputStream cawGkkbZ = null;
			File hxuaoQ5N = new File(HL22mf6P);
			if (!hxuaoQ5N.isFile()) {
				System.out.println(HL22mf6P + " cannot be opened.");
				return;
			}
			hDF7uWHm = new FileInputStream(hxuaoQ5N);
			cawGkkbZ = new FileOutputStream(new File(FQvcRiVF));
			int YYUQtDMC;
			while ((YYUQtDMC = hDF7uWHm.read()) != -1)
				cawGkkbZ.write(YYUQtDMC);
			hDF7uWHm.close();
			cawGkkbZ.close();
		} catch (IOException MSxg0amg) {
			MSxg0amg.printStackTrace();
		}
	}

}