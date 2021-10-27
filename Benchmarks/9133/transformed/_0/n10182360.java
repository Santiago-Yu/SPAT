class n10182360 {
	public void getDownloadInfo(String yA0LCQ9o) throws Exception {
		cl = new FTPClient();
		Authentication wv2o38ih = new FTPAuthentication();
		cl.connect(getHostName());
		while (!cl.login(wv2o38ih.getUser(), wv2o38ih.getPassword())) {
			log.debug("getDownloadInfo() - login error state: " + Arrays.asList(cl.getReplyStrings()));
			ap.setSite(getSite());
			wv2o38ih = ap.promptAuthentication();
			if (wv2o38ih == null)
				throw new Exception("User Cancelled Auth Operation");
		}
		AuthManager.putAuth(getSite(), wv2o38ih);
		cl.enterLocalPassiveMode();
		FTPFile AnWBVFCa = cl.listFiles(new URL(yA0LCQ9o).getFile())[0];
		setURL(yA0LCQ9o);
		setLastModified(AnWBVFCa.getTimestamp().getTimeInMillis());
		setSize(AnWBVFCa.getSize());
		setResumable(cl.rest("0") == 350);
		setRangeEnd(getSize() - 1);
	}

}