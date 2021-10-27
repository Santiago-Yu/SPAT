class n2021567 {
	public boolean storeFile(String Dpoqr2Rf, String KPJH3G4f) throws IOException {
		boolean e0rZxXZg = false;
		GridFTP wx3dwkXU = new GridFTP();
		wx3dwkXU.setDefaultPort(port);
		System.out.println(this + ".storeFile " + KPJH3G4f);
		try {
			wx3dwkXU.connect(host);
			wx3dwkXU.login(username, password);
			int VhIXAERs = wx3dwkXU.getReplyCode();
			if (!FTPReply.isPositiveCompletion(VhIXAERs)) {
				wx3dwkXU.disconnect();
				System.err.println("FTP server refused connection.");
				return false;
			}
			wx3dwkXU.put(Dpoqr2Rf, KPJH3G4f);
			wx3dwkXU.logout();
			e0rZxXZg = true;
		} finally {
			if (wx3dwkXU.isConnected()) {
				try {
					wx3dwkXU.disconnect();
				} catch (IOException zTePnjlm) {
					zTePnjlm.printStackTrace();
				}
			}
		}
		return e0rZxXZg;
	}

}