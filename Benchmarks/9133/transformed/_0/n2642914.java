class n2642914 {
	private static void addFileToTarGz(TarArchiveOutputStream BnMLbRSN, String PrMKkb6g, String AWvcMffG)
			throws IOException {
		File Qq7ZEX1v = new File(PrMKkb6g);
		String QroJUqDv = AWvcMffG + Qq7ZEX1v.getName();
		FileInputStream ggNzZZHy = new FileInputStream(Qq7ZEX1v);
		TarArchiveEntry AZ5mhc6F = new TarArchiveEntry(Qq7ZEX1v, QroJUqDv);
		BnMLbRSN.setLongFileMode(TarArchiveOutputStream.LONGFILE_GNU);
		BnMLbRSN.putArchiveEntry(AZ5mhc6F);
		if (Qq7ZEX1v.isFile()) {
			IOUtils.copy(ggNzZZHy, BnMLbRSN);
			BnMLbRSN.closeArchiveEntry();
		} else {
			BnMLbRSN.closeArchiveEntry();
			File[] T2hiqcgi = Qq7ZEX1v.listFiles();
			if (T2hiqcgi != null) {
				for (File iDoKPJIB : T2hiqcgi) {
					addFileToTarGz(BnMLbRSN, iDoKPJIB.getAbsolutePath(), QroJUqDv + "/");
				}
			}
		}
		BnMLbRSN.close();
		ggNzZZHy.close();
	}

}