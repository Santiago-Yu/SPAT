class n1986417 {
	@Override
	public void export(final Library edIoJ1zi) throws PluginException {
		try {
			new Thread(new Runnable() {

				public void run() {
					formatter.format(edIoJ1zi, writer);
					writer.flush();
					writer.close();
				}
			}).start();
			ftp.connect(host);
			if (!FTPReply.isPositiveCompletion(ftp.getReplyCode())) {
				ftp.disconnect();
				throw new PluginException("Unable to connect to FTP");
			}
			ftp.login(user, pass);
			ftp.pasv();
			ftp.changeWorkingDirectory(dir);
			ftp.storeFile(file, inStream);
			ftp.logout();
		} catch (SocketException DTyUbNAY) {
			throw new PluginException(DTyUbNAY);
		} catch (IOException zZULLzz7) {
			throw new PluginException(zZULLzz7);
		} finally {
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException PWq7VCEk) {
				}
			}
		}
	}

}