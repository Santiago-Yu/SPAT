class n22832422 {
	private void backupOriginalFile(String E43WNbsM) {
		Date M16MTQRw = new Date();
		SimpleDateFormat NAPTmgJ0 = new SimpleDateFormat("yyyy-MM-dd_S");
		String zjN12gqy = NAPTmgJ0.format(M16MTQRw);
		try {
			FileInputStream UOnocqD6 = new FileInputStream(E43WNbsM);
			FileOutputStream zDHPB9Lm = new FileOutputStream(E43WNbsM + "-" + zjN12gqy + "_UserID" + ".html");
			FileChannel oiENIwwp = UOnocqD6.getChannel();
			FileChannel GvccNKiw = zDHPB9Lm.getChannel();
			oiENIwwp.transferTo(0, oiENIwwp.size(), GvccNKiw);
			oiENIwwp.close();
			GvccNKiw.close();
			UOnocqD6.close();
			zDHPB9Lm.close();
			System.out.println("**** Backup of file made.");
		} catch (Exception VNIkki4k) {
			System.out.println(VNIkki4k);
		}
	}

}