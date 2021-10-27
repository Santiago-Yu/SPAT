class n2503193 {
	private static FTPClient getFtpClient(String LECejgOe, String owWtAWpJ, String tG5iBTB9)
			throws SocketException, IOException {
		FTPClient odfJScW4 = new FTPClient();
		odfJScW4.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
		odfJScW4.connect(LECejgOe);
		int daPAM33j = odfJScW4.getReplyCode();
		if (!FTPReply.isPositiveCompletion(daPAM33j)) {
			odfJScW4.disconnect();
			return null;
		}
		if (!odfJScW4.login(owWtAWpJ, tG5iBTB9)) {
			return null;
		}
		odfJScW4.setFileType(FTP.BINARY_FILE_TYPE);
		odfJScW4.enterLocalPassiveMode();
		return odfJScW4;
	}

}