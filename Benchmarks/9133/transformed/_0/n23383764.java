class n23383764 {
	public static void createBackup() {
		String UtrJjIyI = Workspace.INSTANCE.getWorkspace();
		if (UtrJjIyI.length() == 0)
			return;
		UtrJjIyI += "/";
		String TWDeyqzg = UtrJjIyI + "Backup";
		File YpFkAZn2 = new File(TWDeyqzg);
		if (!YpFkAZn2.exists())
			YpFkAZn2.mkdirs();
		String ph3GhRRZ = DataUtils.DateAndTimeOfNowAsLocalString();
		ph3GhRRZ = ph3GhRRZ.replace(" ", "_");
		ph3GhRRZ = ph3GhRRZ.replace(":", "");
		TWDeyqzg += "/Backup_" + ph3GhRRZ + ".zip";
		ArrayList<String> rzTtqThz = new ArrayList<String>();
		rzTtqThz.add("Database/Database.properties");
		rzTtqThz.add("Database/Database.script");
		FileInputStream d3JLz0un;
		byte[] aaP1TJCH = new byte[1024];
		int l4SLQvUB = 0;
		try {
			ZipOutputStream APmARu88 = new ZipOutputStream(new FileOutputStream(TWDeyqzg));
			APmARu88.setMethod(ZipOutputStream.DEFLATED);
			for (int M9YByMxa = 0; M9YByMxa < rzTtqThz.size(); M9YByMxa++) {
				String KEKCVax3 = rzTtqThz.get(M9YByMxa);
				try {
					File eeawCMeC = new File(UtrJjIyI + KEKCVax3);
					if (eeawCMeC.exists()) {
						d3JLz0un = new FileInputStream(UtrJjIyI + KEKCVax3);
						if (d3JLz0un != null) {
							ZipEntry bexse5L1 = new ZipEntry(KEKCVax3);
							APmARu88.putNextEntry(bexse5L1);
							while ((l4SLQvUB = d3JLz0un.read(aaP1TJCH, 0, 1024)) != -1)
								APmARu88.write(aaP1TJCH, 0, l4SLQvUB);
							APmARu88.closeEntry();
							d3JLz0un.close();
						}
					}
				} catch (Exception pdCpJLPn) {
					Logger.logError(pdCpJLPn, "Error during file backup:" + KEKCVax3);
				}
			}
			APmARu88.close();
		} catch (IOException lEpazzMf) {
			Logger.logError(lEpazzMf, "Error during backup");
		}
	}

}