class n21889400 {
	private void backupOriginalFile(String myFile) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_S");
		Date date = new Date();
		String datePortion = format.format(date);
		try {
			FileInputStream fis = new FileInputStream(myFile);
			FileChannel fcin = fis.getChannel();
			FileOutputStream fos = new FileOutputStream(myFile + "-" + datePortion + "_UserID" + ".html");
			FileChannel fcout = fos.getChannel();
			fcin.transferTo(0, fcin.size(), fcout);
			fcin.close();
			fcout.close();
			fis.close();
			fos.close();
			System.out.println("**** Backup of file made.");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}