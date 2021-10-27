class n10447014 {
	public void chmod(String I6gB6ZM9, String v7yudobe) {
		String MJZRoGdb = connector.getRemoteDirectory();
		MJZRoGdb += PATH_SEPARATOR + I6gB6ZM9;
		FTPClient xOgFgFUT = new FTPClient();
		try {
			String o9eMeSiA = connector.getUrl().getHost();
			xOgFgFUT.connect(o9eMeSiA);
			log.info("Connected to " + o9eMeSiA);
			log.info(xOgFgFUT.getReplyString());
			boolean qxqNeSc8 = xOgFgFUT.login(connector.getUsername(), connector.getPassword());
			if (qxqNeSc8) {
				String Rp3MWonE = "chmod " + v7yudobe + " " + MJZRoGdb;
				xOgFgFUT.site(Rp3MWonE);
				xOgFgFUT.logout();
			}
			xOgFgFUT.disconnect();
		} catch (SocketException GS8bdMM7) {
			log.error("File chmod failed with message: " + GS8bdMM7.getMessage());
		} catch (IOException SMlFcxDE) {
			log.error("File chmod failed with message: " + SMlFcxDE.getMessage());
		} finally {
			if (xOgFgFUT.isConnected()) {
				try {
					xOgFgFUT.disconnect();
				} catch (IOException BOCv0ErK) {
				}
			}
		}
	}

}