class n20175752 {
	public void putFullDirectory(final String kNeV7XJ1, final String uVh1Pl1P, final String p0ADxrdh,
			final String OJRb4x9C, final String pp52XPGU) throws Exception {
		if (!Strings.isPopulated(kNeV7XJ1)) {
			Util.dspmsg("Need an FTP url.");
			return;
		}
		if (!Strings.isPopulated(uVh1Pl1P)) {
			Util.dspmsg("Need a remote directory.");
			return;
		}
		if (!Strings.isPopulated(p0ADxrdh)) {
			Util.dspmsg("Need a user ID.");
			return;
		}
		if (!Strings.isPopulated(OJRb4x9C)) {
			Util.dspmsg("Need a password.");
			return;
		}
		if (!Strings.isPopulated(pp52XPGU)) {
			Util.dspmsg("Need a local directory.");
			return;
		}
		FTPClient XQ1l65Dd = new FTPClient();
		XQ1l65Dd.connect(kNeV7XJ1);
		int MFnBvbNe = XQ1l65Dd.getReplyCode();
		if (!FTPReply.isPositiveCompletion(MFnBvbNe)) {
			Util.dspmsg("Could not connect, code: " + MFnBvbNe);
			XQ1l65Dd.disconnect();
			return;
		}
		if (!XQ1l65Dd.login(p0ADxrdh, OJRb4x9C)) {
			Util.dspmsg("Could not log on, userId: " + p0ADxrdh + " pwd: " + OJRb4x9C);
			return;
		}
		StringTokenizer g7Anqtsj = new StringTokenizer(uVh1Pl1P, "/");
		while (g7Anqtsj.hasMoreElements()) {
			if (!chgDir(XQ1l65Dd, g7Anqtsj.nextToken())) {
				return;
			}
		}
		XQ1l65Dd.setFileType(FTP.BINARY_FILE_TYPE);
		File OaqPbeg5 = new File(pp52XPGU);
		if (OaqPbeg5.isDirectory()) {
			FOR: for (File x7x5Gb5e : OaqPbeg5.listFiles()) {
				if (!put(XQ1l65Dd, x7x5Gb5e)) {
					break FOR;
				}
			}
		} else {
			put(XQ1l65Dd, OaqPbeg5);
		}
		XQ1l65Dd.logout();
		XQ1l65Dd.disconnect();
	}

}