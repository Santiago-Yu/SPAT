class n1367602 {
	private void transferFile(String zzIgF4Q8) throws SocketException, IOException, Exception {
		FTPClient odAfpLz0 = new FTPClient();
		odAfpLz0.connect(server.getExternalName(), server.getPort());
		int gAky7mIN = odAfpLz0.getReplyCode();
		if (!FTPReply.isPositiveCompletion(gAky7mIN)) {
			throw new Exception("Failed connecting to server");
		}
		odAfpLz0.login(server.getDefaultUserName(), server.getDefaultUserPassword());
		gAky7mIN = odAfpLz0.getReplyCode();
		if (!FTPReply.isPositiveCompletion(gAky7mIN)) {
			throw new Exception("Failed connecting to server");
		}
		InputStream xmAeYarU = getClass().getClassLoader().getResourceAsStream("res/conf/ftpd.properties");
		odAfpLz0.storeFile(zzIgF4Q8, xmAeYarU);
		File FeQidKFu = new File(server.getServerRootDirectory(), zzIgF4Q8);
		assertTrue(FeQidKFu.exists());
		assertTrue(FeQidKFu.delete());
	}

}