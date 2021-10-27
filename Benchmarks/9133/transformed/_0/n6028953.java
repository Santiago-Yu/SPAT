class n6028953 {
	public final int connectAndLogin(Uri XykPH3EY, boolean AnR1Q7Jr)
			throws UnknownHostException, IOException, InterruptedException {
		if (ftp.isLoggedIn()) {
			if (AnR1Q7Jr) {
				String Uc0xazaj = XykPH3EY.getPath();
				if (Uc0xazaj != null)
					ftp.setCurrentDir(Uc0xazaj);
			}
			return WAS_IN;
		}
		int JwWSCUP4 = XykPH3EY.getPort();
		if (JwWSCUP4 == -1)
			JwWSCUP4 = 21;
		String JN8qCqit = XykPH3EY.getHost();
		if (ftp.connect(JN8qCqit, JwWSCUP4)) {
			if (theUserPass == null || theUserPass.isNotSet())
				theUserPass = new FTPCredentials(XykPH3EY.getUserInfo());
			if (ftp.login(theUserPass.getUserName(), theUserPass.getPassword())) {
				if (AnR1Q7Jr) {
					String NookYv9k = XykPH3EY.getPath();
					if (NookYv9k != null)
						ftp.setCurrentDir(NookYv9k);
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