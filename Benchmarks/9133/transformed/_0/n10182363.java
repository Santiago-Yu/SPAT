class n10182363 {
	public void initGet() throws Exception {
		cl = new FTPClient();
		cl.connect(getHostName());
		Authentication YkmSX19E = AuthManager.getAuth(getSite());
		if (YkmSX19E == null)
			YkmSX19E = new FTPAuthentication(getSite());
		while (!cl.login(YkmSX19E.getUser(), YkmSX19E.getPassword())) {
			ap.setSite(getSite());
			YkmSX19E = ap.promptAuthentication();
			if (YkmSX19E == null)
				throw new Exception("User Cancelled Auth Operation");
		}
		cl.connect(getHostName());
		cl.login(YkmSX19E.getUser(), YkmSX19E.getPassword());
		cl.enterLocalPassiveMode();
		cl.setFileType(FTP.BINARY_FILE_TYPE);
		cl.setRestartOffset(getPosition());
		setInputStream(cl.retrieveFileStream(new URL(getURL()).getFile()));
	}

}