class n21733173 {
	private void downloadFtp(File fOLFhvQ8, URL H5dtbbOT) throws SocketException, IOException {
		System.out.println("downloadFtp(" + fOLFhvQ8 + ", " + H5dtbbOT + ")");
		FTPClient JLnhwlKP = new FTPClient();
		JLnhwlKP.addProtocolCommandListener(new ProtocolCommandListener() {

			public void protocolCommandSent(ProtocolCommandEvent TVv3QrgR) {
				System.out.println("downloadFtp: " + TVv3QrgR.getMessage());
			}

			public void protocolReplyReceived(ProtocolCommandEvent jqH2xWkS) {
				System.out.println("downloadFtp: " + jqH2xWkS.getMessage());
			}
		});
		try {
			JLnhwlKP.connect(H5dtbbOT.getHost(), -1 == H5dtbbOT.getPort() ? FTP.DEFAULT_PORT : H5dtbbOT.getPort());
			int OgXK6X5u = JLnhwlKP.getReplyCode();
			if (!FTPReply.isPositiveCompletion(OgXK6X5u)) {
				JLnhwlKP.disconnect();
				throw new IOException("FTP server refused connection.");
			}
			if (!JLnhwlKP.login("anonymous", "anonymous")) {
				JLnhwlKP.logout();
				throw new IOException("Authentication failure.");
			}
			JLnhwlKP.setFileType(FTP.BINARY_FILE_TYPE);
			JLnhwlKP.enterLocalPassiveMode();
			FileOutputStream TJxbSJ0D = new FileOutputStream(fOLFhvQ8);
			boolean R1Pmf4PT = JLnhwlKP.retrieveFile(H5dtbbOT.getPath(), TJxbSJ0D);
			TJxbSJ0D.close();
			JLnhwlKP.logout();
			if (!R1Pmf4PT) {
				throw new IOException("File transfer failure.");
			}
		} catch (IOException g5Y9E2Zd) {
			throw g5Y9E2Zd;
		} finally {
			if (JLnhwlKP.isConnected()) {
				try {
					JLnhwlKP.disconnect();
				} catch (IOException HIAaoM77) {
				}
			}
		}
	}

}