class n21733173 {
	private void downloadFtp(File file, URL jurl) throws SocketException, IOException {
		System.out.println("downloadFtp(" + file + ", " + jurl + ")");
		FTPClient client = new FTPClient();
		client.addProtocolCommandListener(new ProtocolCommandListener() {

			public void protocolCommandSent(ProtocolCommandEvent event) {
				System.out.println("downloadFtp: " + event.getMessage());
			}

			public void protocolReplyReceived(ProtocolCommandEvent event) {
				System.out.println("downloadFtp: " + event.getMessage());
			}
		});
		try {
			if (-1 == jurl.getPort())
				client.connect(jurl.getHost(), FTP.DEFAULT_PORT);
			else
				client.connect(jurl.getHost(), jurl.getPort());
			int reply = client.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				client.disconnect();
				throw new IOException("FTP server refused connection.");
			}
			if (!client.login("anonymous", "anonymous")) {
				client.logout();
				throw new IOException("Authentication failure.");
			}
			client.setFileType(FTP.BINARY_FILE_TYPE);
			client.enterLocalPassiveMode();
			FileOutputStream out = new FileOutputStream(file);
			boolean ok = client.retrieveFile(jurl.getPath(), out);
			out.close();
			client.logout();
			if (!ok) {
				throw new IOException("File transfer failure.");
			}
		} catch (IOException e) {
			throw e;
		} finally {
			if (client.isConnected()) {
				try {
					client.disconnect();
				} catch (IOException e) {
				}
			}
		}
	}

}