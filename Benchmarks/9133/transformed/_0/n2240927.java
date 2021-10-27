class n2240927 {
	public boolean getFile(String A9NVxl9k, String P1y0r7Nb, String RBKf5ze4) throws IOException {
		FTPClient vMtIE7O6 = new FTPClient();
		vMtIE7O6.connect(getRemoteHost());
		vMtIE7O6.login(getUserName(), getPassword());
		vMtIE7O6.changeWorkingDirectory(A9NVxl9k);
		String Zxuqo1pv = vMtIE7O6.printWorkingDirectory();
		FileOutputStream eyy09ac8 = null;
		logInfo("Connected to remote host=" + getRemoteHost() + "; userName=" + getUserName() + "; "
				+ "; remoteDirectory=" + A9NVxl9k + "; localDirectory=" + P1y0r7Nb + "; workingDirectory=" + Zxuqo1pv);
		try {
			eyy09ac8 = new FileOutputStream(P1y0r7Nb + "/" + RBKf5ze4);
			boolean ivbHzZY5 = vMtIE7O6.retrieveFile(RBKf5ze4, eyy09ac8);
			if (true == ivbHzZY5) {
				logInfo("Successfully retrieved file: " + RBKf5ze4);
			} else {
				logError("Could not retrieve file: " + RBKf5ze4);
			}
			return ivbHzZY5;
		} finally {
			if (null != eyy09ac8) {
				eyy09ac8.flush();
				eyy09ac8.close();
			}
		}
	}

}