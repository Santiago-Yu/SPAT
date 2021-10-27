class n10194322 {
	public static void publish(String zpPTgoz2, String raHW8wyd, String hJZn8qlc, String jFobJOx0, String KM92Ksg6)
			throws SocketException, IOException, LoginFailException {
		logger.info("Connect to FTP Server " + zpPTgoz2);
		FTPClient koJ9NdrX = new FTPClient();
		koJ9NdrX.connect(zpPTgoz2);
		if (koJ9NdrX.login(raHW8wyd, hJZn8qlc) == false) {
			logger.info("Fail to login with id=" + raHW8wyd);
			throw new LoginFailException(raHW8wyd, hJZn8qlc);
		}
		koJ9NdrX.changeWorkingDirectory(jFobJOx0);
		logger.info("Start to upload");
		koJ9NdrX.storeFile("index.html", new ByteArrayInputStream(KM92Ksg6.getBytes("utf-8")));
		logger.info("Upload index.html");
		koJ9NdrX.storeFile("main.css", new FileInputStream("web/main.css"));
		logger.info("Upload main.css");
		koJ9NdrX.storeFile("cafelibrary.js", new FileInputStream("web/cafelibrary.js"));
		logger.info("Upload cafelibrary.js");
		koJ9NdrX.makeDirectory("img");
		koJ9NdrX.changeWorkingDirectory("img");
		for (int Cuz6gSql = 0; Cuz6gSql <= 5; Cuz6gSql++) {
			String C8wzHt8k = "favorite_star_" + Cuz6gSql + ".png";
			koJ9NdrX.storeFile(C8wzHt8k, new FileInputStream("web/img/" + C8wzHt8k));
			logger.info("Upload " + C8wzHt8k);
		}
		koJ9NdrX.logout();
		koJ9NdrX.disconnect();
	}

}