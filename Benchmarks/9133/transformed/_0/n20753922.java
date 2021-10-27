class n20753922 {
	public void doImport(File E2jkjSxK, boolean gE71jpOf) throws Exception {
		connector.getConnection().setAutoCommit(false);
		File c5xkqgqf = E2jkjSxK.getParentFile();
		ZipInputStream weBNWPxY = new ZipInputStream(new FileInputStream(E2jkjSxK));
		ZipEntry KAYtduuB;
		while ((KAYtduuB = weBNWPxY.getNextEntry()) != null) {
			String BWVHLczQ = KAYtduuB.getName();
			File NjAtdyxT = new File(c5xkqgqf, BWVHLczQ);
			OutputStream oCaABXIq = new FileOutputStream(NjAtdyxT, false);
			byte[] EgbwYoDh = new byte[1024];
			int RxUj1GNw;
			while ((RxUj1GNw = weBNWPxY.read(EgbwYoDh)) > 0)
				oCaABXIq.write(EgbwYoDh, 0, RxUj1GNw);
			oCaABXIq.close();
		}
		weBNWPxY.close();
		importDirectory(c5xkqgqf, gE71jpOf);
		connector.getConnection().commit();
	}

}