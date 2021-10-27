class n12690725 {
	public void login(String s5kE0Yxp, String yslPTagT) throws GB_SecurityException {
		Exception hEP0j8bK = null;
		try {
			if (clientFtp == null) {
				clientFtp = new FTPClient();
				clientFtp.connect("ftp://" + ftp);
			}
			boolean zne5GWHg = clientFtp.login(s5kE0Yxp, yslPTagT);
			if (zne5GWHg) {
				username = s5kE0Yxp;
				password = yslPTagT;
				return;
			}
		} catch (Exception lTp9C2gh) {
			hEP0j8bK = lTp9C2gh;
		}
		String kNidAB4Z = "Cannot login to ftp server with user [{1}], {2}";
		String[] iI5jMDmd = new String[] { s5kE0Yxp, ftp };
		kNidAB4Z = STools.replace(kNidAB4Z, iI5jMDmd);
		throw new GB_SecurityException(kNidAB4Z, hEP0j8bK);
	}

}