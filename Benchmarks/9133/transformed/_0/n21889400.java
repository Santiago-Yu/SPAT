class n21889400 {
	private void backupOriginalFile(String IIf7cE3n) {
		Date BBRtrLtD = new Date();
		SimpleDateFormat iGedfzTZ = new SimpleDateFormat("yyyy-MM-dd_S");
		String jBwokujm = iGedfzTZ.format(BBRtrLtD);
		try {
			FileInputStream wJ3nz2vU = new FileInputStream(IIf7cE3n);
			FileOutputStream sFLfcfmV = new FileOutputStream(IIf7cE3n + "-" + jBwokujm + "_UserID" + ".html");
			FileChannel DfWv2MMo = wJ3nz2vU.getChannel();
			FileChannel XtCetLo6 = sFLfcfmV.getChannel();
			DfWv2MMo.transferTo(0, DfWv2MMo.size(), XtCetLo6);
			DfWv2MMo.close();
			XtCetLo6.close();
			wJ3nz2vU.close();
			sFLfcfmV.close();
			System.out.println("**** Backup of file made.");
		} catch (Exception bqTtJ8hu) {
			System.out.println(bqTtJ8hu);
		}
	}

}