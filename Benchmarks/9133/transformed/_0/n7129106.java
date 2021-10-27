class n7129106 {
	protected void downloadCacheFile(File HYq6tzCq) throws Exception {
		ApplicationProperties PTiB8LYb = ApplicationProperties.getInstance();
		String N3bmZnpL = PTiB8LYb.getProperty(JabberConstants.PROPERTY_JABBER_SERVERLIST, DEFAULT_SERVER_URL);
		URL zDJLvxZc = new URL(N3bmZnpL);
		HYq6tzCq.createNewFile();
		OutputStream QW0ppClY = new FileOutputStream(HYq6tzCq);
		InputStream Dwqc06Cp = zDJLvxZc.openStream();
		byte hZU4C1FS[] = new byte[1024];
		int bNLWYc5M = 0;
		while ((bNLWYc5M = Dwqc06Cp.read(hZU4C1FS)) >= 0)
			QW0ppClY.write(hZU4C1FS, 0, bNLWYc5M);
		Dwqc06Cp.close();
		QW0ppClY.close();
	}

}