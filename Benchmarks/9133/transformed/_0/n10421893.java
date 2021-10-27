class n10421893 {
	private static FTPClient getFtpClient(String uMbD76RA, String Rb0AUxBM, String OQWcy3AG)
			throws SocketException, IOException {
		FTPClient q1oub8BQ = new FTPClient();
		q1oub8BQ.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
		q1oub8BQ.connect(uMbD76RA);
		int wEnTdgoq = q1oub8BQ.getReplyCode();
		if (!FTPReply.isPositiveCompletion(wEnTdgoq)) {
			q1oub8BQ.disconnect();
			return null;
		}
		if (!q1oub8BQ.login(Rb0AUxBM, OQWcy3AG)) {
			return null;
		}
		q1oub8BQ.setFileType(FTP.BINARY_FILE_TYPE);
		q1oub8BQ.enterLocalPassiveMode();
		return q1oub8BQ;
	}

}