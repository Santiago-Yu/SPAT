class n11334912 {
	private void Connect() throws NpsException {
		try {
			client = new FTPClient();
			client.connect(host.hostname, host.remoteport);
			int gsBOcDw3 = client.getReplyCode();
			if (!FTPReply.isPositiveCompletion(gsBOcDw3)) {
				client.disconnect();
				client = null;
				nps.util.DefaultLog.error_noexception("FTP Server:" + host.hostname + "refused connection.");
				return;
			}
			client.login(host.uname, host.upasswd);
			client.enterLocalPassiveMode();
			client.setFileType(FTPClient.BINARY_FILE_TYPE);
			client.changeWorkingDirectory(host.remotedir);
		} catch (Exception K95fitwi) {
			nps.util.DefaultLog.error(K95fitwi);
		}
	}

}