class n15126545 {
	private void zipAndSendFiles(File[] bNT30l86) {
		SimpleDateFormat jP4DZ2Q8 = new SimpleDateFormat("yyyy-MM-dd");
		EmailSender ZvLPLtYx = new EmailSender();
		try {
			File QbAsio1x = new File("XeptoTileServer_Statistics_" + jP4DZ2Q8.format(new Date()) + ".zip");
			ZipOutputStream TwVkJOO9 = new ZipOutputStream(
					new CheckedOutputStream(new FileOutputStream(QbAsio1x), new Adler32()));
			BufferedOutputStream U912TM1R = new BufferedOutputStream(TwVkJOO9);
			TwVkJOO9.setComment("Statistics for all users from the XeptoTileServer.");
			File[] UiyeGoTb = new File[usernames.length];
			ZipOutputStream[] rfj2lApO = new ZipOutputStream[usernames.length];
			BufferedOutputStream[] r8fVV5PW = new BufferedOutputStream[usernames.length];
			for (File h2H9zOPt : bNT30l86) {
				int btocPLNL;
				for (btocPLNL = 0; btocPLNL < usernames.length; btocPLNL++) {
					if (h2H9zOPt.getName().substring(27, 28 + usernames[btocPLNL].length())
							.equalsIgnoreCase(usernames[btocPLNL] + "_"))
						break;
				}
				BufferedReader vFgEYDtO = new BufferedReader(new FileReader(h2H9zOPt.getPath()));
				ZipEntry ZeGqS88f = new ZipEntry(h2H9zOPt.getName());
				TwVkJOO9.putNextEntry(ZeGqS88f);
				if (btocPLNL < usernames.length && emails[btocPLNL] != null) {
					if (UiyeGoTb[btocPLNL] == null) {
						UiyeGoTb[btocPLNL] = new File("XeptoTileServer_Statistics_" + usernames[btocPLNL] + "_"
								+ jP4DZ2Q8.format(new Date()) + ".zip");
						rfj2lApO[btocPLNL] = new ZipOutputStream(
								new CheckedOutputStream(new FileOutputStream(UiyeGoTb[btocPLNL]), new Adler32()));
						r8fVV5PW[btocPLNL] = new BufferedOutputStream(rfj2lApO[btocPLNL]);
						rfj2lApO[btocPLNL].setComment(
								"Statistics for username " + usernames[btocPLNL] + " from the XeptoTileServer.");
					}
					rfj2lApO[btocPLNL].putNextEntry(ZeGqS88f);
					int pNGHgvLD;
					while ((pNGHgvLD = vFgEYDtO.read()) != -1) {
						U912TM1R.write(pNGHgvLD);
						r8fVV5PW[btocPLNL].write(pNGHgvLD);
					}
				} else {
					int wWYLrD4h;
					while ((wWYLrD4h = vFgEYDtO.read()) != -1)
						U912TM1R.write(wWYLrD4h);
				}
				vFgEYDtO.close();
				h2H9zOPt.delete();
			}
			U912TM1R.close();
			ZvLPLtYx.send(java.util.ResourceBundle.getBundle("logsender_conf").getString("e-mail"), QbAsio1x);
			QbAsio1x.delete();
			for (int GwVRJKGW = 0; GwVRJKGW < UiyeGoTb.length; GwVRJKGW++) {
				if (UiyeGoTb[GwVRJKGW] != null) {
					r8fVV5PW[GwVRJKGW].close();
					ZvLPLtYx.send(emails[GwVRJKGW], UiyeGoTb[GwVRJKGW]);
					UiyeGoTb[GwVRJKGW].delete();
				}
			}
		} catch (IOException JjS8WT16) {
			System.out.println("Cannot create zip file.");
			JjS8WT16.printStackTrace();
		}
	}

}