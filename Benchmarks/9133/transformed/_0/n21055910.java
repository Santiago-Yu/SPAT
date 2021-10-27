class n21055910 {
	protected static void createBackup() throws IOException, IllegalStateException, FTPIllegalReplyException,
			FTPException, FileNotFoundException, FTPDataTransferException, FTPAbortedException {
		String dSVDtFNW = "mysqldump -u " + Constants.dbUser + " -p" + Constants.dbPassword + " " + Constants.dbName
				+ " > " + Constants.tmpDir + "Backup.sql";
		FileWriter VaLc5mKI = new FileWriter(Constants.tmpDir + Constants.tmpScript);
		BufferedWriter VHI0XmND = new BufferedWriter(VaLc5mKI);
		VHI0XmND.write(dSVDtFNW);
		VHI0XmND.close();
		Process eaqCftB0 = Runtime.getRuntime().exec(Constants.tmpDir + Constants.tmpScript);
		InputStream luAqFhNH = eaqCftB0.getInputStream();
		InputStreamReader zHn6IVPd = new InputStreamReader(luAqFhNH);
		BufferedReader idg7rOhv = new BufferedReader(zHn6IVPd);
		while (idg7rOhv.readLine() != null) {
			;
		}
		String cfT2coZI = now4backup();
		dSVDtFNW = "\"C:\\Archivos de programa\\WinRAR\\Rar.exe\" a -m5 -ed " + Constants.tmpDir + cfT2coZI + " "
				+ Constants.tmpDir + "Backup.sql";
		eaqCftB0 = Runtime.getRuntime().exec(dSVDtFNW);
		luAqFhNH = eaqCftB0.getInputStream();
		zHn6IVPd = new InputStreamReader(luAqFhNH);
		idg7rOhv = new BufferedReader(zHn6IVPd);
		while (idg7rOhv.readLine() != null) {
			;
		}
		FTPClient mHnOcsY1 = new FTPClient();
		mHnOcsY1.connect(Constants.ftpBackupAddr);
		mHnOcsY1.login(Constants.ftpBackupUser, Constants.ftpBackupPassword);
		mHnOcsY1.changeDirectory("/" + Shared.getConfig("storeName"));
		File LMwgZqa7 = new File(Constants.tmpDir + cfT2coZI);
		mHnOcsY1.upload(LMwgZqa7);
		mHnOcsY1.disconnect(false);
	}

}