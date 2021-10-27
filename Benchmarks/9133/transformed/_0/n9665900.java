class n9665900 {
	@SuppressWarnings("static-access")
	public FastCollection<String> load(Link lHx1avgp) {
		URL bQIow1Hp = null;
		FastCollection<String> kq9WlHDE = new FastList<String>();
		FTPClient daoe7xKe = null;
		try {
			String e2wicXKP = lHx1avgp.getURI();
			e2wicXKP = JGetFileUtils.removeTrailingString(e2wicXKP, "/");
			bQIow1Hp = new URL(e2wicXKP);
			host = bQIow1Hp.getHost();
			String H652be6o = bQIow1Hp.getPath();
			logger.info("Traversing: " + e2wicXKP);
			daoe7xKe = new FTPClient(host);
			if (!daoe7xKe.connected()) {
				daoe7xKe.connect();
			}
			daoe7xKe.login("anonymous", "me@mymail.com");
			logger.info("Connected to " + host + ".");
			logger.debug("changing dir to " + H652be6o);
			daoe7xKe.chdir(H652be6o);
			String[] h6iwS9Ac = daoe7xKe.dir();
			for (String v4l82qjE : h6iwS9Ac) {
				kq9WlHDE.add(e2wicXKP + "/" + v4l82qjE);
			}
		} catch (Exception TGYTvuC8) {
			logger.error(TGYTvuC8.getMessage());
			logger.debug(TGYTvuC8.getStackTrace());
		} finally {
			try {
				daoe7xKe.quit();
			} catch (Exception e1gI6Kv8) {
				logger.error("Failed to logout or disconnect from the ftp server: ftp://" + host);
			}
		}
		return kq9WlHDE;
	}

}