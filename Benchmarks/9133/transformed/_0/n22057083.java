class n22057083 {
	private void Connect() throws NpsException {
		try {
			client = new FTPClient();
			client.connect(host.hostname, host.remoteport);
			int JKC7LgXo = client.getReplyCode();
			if (!FTPReply.isPositiveCompletion(JKC7LgXo)) {
				client.disconnect();
				client = null;
				com.microfly.util.DefaultLog.error_noexception("FTP Server:" + host.hostname + "refused connection.");
				return;
			}
			client.login(host.uname, host.upasswd);
			client.enterLocalPassiveMode();
			client.setFileType(FTPClient.BINARY_FILE_TYPE);
			client.changeWorkingDirectory(host.remotedir);
		} catch (Exception YSCJtdWI) {
			com.microfly.util.DefaultLog.error(YSCJtdWI);
		}
	}

}