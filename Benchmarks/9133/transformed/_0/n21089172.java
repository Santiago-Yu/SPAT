class n21089172 {
	private File Gzip(File Sb7qHL2U) throws IOException {
		if (Sb7qHL2U == null || !Sb7qHL2U.exists())
			return null;
		File l3oE5tma = Sb7qHL2U.getParentFile();
		String ow6aOBAM = Sb7qHL2U.getName() + ".gz";
		File q8KpI6gE = new File(l3oE5tma, ow6aOBAM);
		GZIPOutputStream uku9SLE2 = new GZIPOutputStream(new FileOutputStream(q8KpI6gE));
		FileInputStream xsa3cZbv = new FileInputStream(Sb7qHL2U);
		byte Lx9OxGj6[] = new byte[1024];
		int x3btLyX1;
		while ((x3btLyX1 = xsa3cZbv.read(Lx9OxGj6)) > 0)
			uku9SLE2.write(Lx9OxGj6, 0, x3btLyX1);
		uku9SLE2.finish();
		try {
			xsa3cZbv.close();
		} catch (Exception w7QAbSc2) {
		}
		try {
			uku9SLE2.close();
		} catch (Exception wJg0K4WG) {
		}
		try {
			Sb7qHL2U.delete();
		} catch (Exception SxpRS8wk) {
		}
		return q8KpI6gE;
	}

}