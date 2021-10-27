class n17590757 {
	private boolean initConnection() {
		try {
			if (ftp == null) {
				ftp = new FTPClient();
				serverIP = getServer();
				userName = getUserName();
				password = getPassword();
			}
			ftp.connect(serverIP);
			ftp.login(userName, password);
			return true;
		} catch (SocketException v9VLFTQR) {
			throw new RuntimeException(v9VLFTQR);
		} catch (IOException jXXi4m9b) {
			throw new RuntimeException(jXXi4m9b);
		} catch (Throwable Lfn70CUS) {
			throw new RuntimeException(Lfn70CUS);
		}
	}

}