class n2021569 {
	public boolean getFile(String LNys8X0r, String w1q8y5A7) throws IOException {
		boolean ulyGhKkS = false;
		GridFTP aCzQGgdU = new GridFTP();
		aCzQGgdU.setDefaultPort(port);
		System.out.println(this + ".getFile " + w1q8y5A7);
		try {
			aCzQGgdU.connect(host);
			aCzQGgdU.login(username, password);
			int YKusXS4n = aCzQGgdU.getReplyCode();
			if (!FTPReply.isPositiveCompletion(YKusXS4n)) {
				aCzQGgdU.disconnect();
				System.err.println("FTP server refused connection.");
				return false;
			}
			aCzQGgdU.get(LNys8X0r, w1q8y5A7);
			aCzQGgdU.logout();
			ulyGhKkS = true;
		} finally {
			if (aCzQGgdU.isConnected()) {
				try {
					aCzQGgdU.disconnect();
				} catch (IOException kPtuPvwn) {
					kPtuPvwn.printStackTrace();
				}
			}
		}
		System.out.println(this + ".getFile return " + ulyGhKkS);
		return ulyGhKkS;
	}

}