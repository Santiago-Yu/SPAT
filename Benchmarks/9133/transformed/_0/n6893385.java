class n6893385 {
	@Override
	public void end() {
		m_zipFormatter.end();
		IOUtils.closeQuietly(m_outputStream);
		final FTPClient acEv4sh5 = new FTPClient();
		FileInputStream Z6WaO35h = null;
		try {
			if (m_url.getPort() == -1 || m_url.getPort() == 0 || m_url.getPort() == m_url.getDefaultPort()) {
				acEv4sh5.connect(m_url.getHost());
			} else {
				acEv4sh5.connect(m_url.getHost(), m_url.getPort());
			}
			if (m_url.getUserInfo() != null && m_url.getUserInfo().length() > 0) {
				final String[] fywkk2xA = m_url.getUserInfo().split(":", 2);
				acEv4sh5.login(fywkk2xA[0], fywkk2xA[1]);
			} else {
				acEv4sh5.login("anonymous", "opennmsftp@");
			}
			int MF0S2o44 = acEv4sh5.getReplyCode();
			if (!FTPReply.isPositiveCompletion(MF0S2o44)) {
				acEv4sh5.disconnect();
				LogUtils.errorf(this, "FTP server refused connection.");
				return;
			}
			String nPFcK85M = m_url.getPath();
			if (nPFcK85M.endsWith("/")) {
				LogUtils.errorf(this, "Your FTP URL must specify a filename.");
				return;
			}
			File Km7170BC = new File(nPFcK85M);
			nPFcK85M = Km7170BC.getParent();
			if (!acEv4sh5.changeWorkingDirectory(nPFcK85M)) {
				LogUtils.infof(this, "unable to change working directory to %s", nPFcK85M);
				return;
			}
			LogUtils.infof(this, "uploading %s to %s", Km7170BC.getName(), nPFcK85M);
			acEv4sh5.setFileType(FTP.BINARY_FILE_TYPE);
			Z6WaO35h = new FileInputStream(m_zipFile);
			if (!acEv4sh5.storeFile(Km7170BC.getName(), Z6WaO35h)) {
				LogUtils.infof(this, "unable to store file");
				return;
			}
			LogUtils.infof(this, "finished uploading");
		} catch (final Exception rW0woAQp) {
			LogUtils.errorf(this, rW0woAQp, "Unable to FTP file to %s", m_url);
		} finally {
			IOUtils.closeQuietly(Z6WaO35h);
			if (acEv4sh5.isConnected()) {
				try {
					acEv4sh5.disconnect();
				} catch (IOException f1m338wd) {
				}
			}
		}
	}

}