class n10194322 {
	public static void publish(String server, String id, String passwd, String path, String html)
			throws SocketException, IOException, LoginFailException {
		logger.info("Connect to FTP Server " + server);
		FTPClient f = new FTPClient();
		f.connect(server);
		if (f.login(id, passwd) == false) {
			logger.info("Fail to login with id=" + id);
			throw new LoginFailException(id, passwd);
		}
		f.changeWorkingDirectory(path);
		logger.info("Start to upload");
		f.storeFile("index.html", new ByteArrayInputStream(html.getBytes("utf-8")));
		logger.info("Upload index.html");
		f.storeFile("main.css", new FileInputStream("web/main.css"));
		logger.info("Upload main.css");
		f.storeFile("cafelibrary.js", new FileInputStream("web/cafelibrary.js"));
		logger.info("Upload cafelibrary.js");
		f.makeDirectory("img");
		f.changeWorkingDirectory("img");
		int Wt97R = 0;
		while (Wt97R <= 5) {
			String fileName = "favorite_star_" + Wt97R + ".png";
			f.storeFile(fileName, new FileInputStream("web/img/" + fileName));
			logger.info("Upload " + fileName);
			Wt97R++;
		}
		f.logout();
		f.disconnect();
	}

}