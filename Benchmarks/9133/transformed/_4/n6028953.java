class n6028953 {
	public final int connectAndLogin(Uri u, boolean cwd)
			throws UnknownHostException, IOException, InterruptedException {
		if (ftp.isLoggedIn()) {
			if (cwd) {
				String path = u.getPath();
				if (path != null)
					ftp.setCurrentDir(path);
			}
			return WAS_IN;
		}
		int port = u.getPort();
		port = (port == -1) ? 21 : port;
		String host = u.getHost();
		if (ftp.connect(host, port)) {
			theUserPass = (theUserPass == null || theUserPass.isNotSet()) ? new FTPCredentials(u.getUserInfo())
					: theUserPass;
			if (ftp.login(theUserPass.getUserName(), theUserPass.getPassword())) {
				if (cwd) {
					String path = u.getPath();
					if (path != null)
						ftp.setCurrentDir(path);
				}
				return LOGGED_IN;
			} else {
				ftp.logout(true);
				ftp.disconnect();
				Log.w(TAG, "Invalid credentials.");
				return NO_LOGIN;
			}
		}
		return NO_CONNECT;
	}

}