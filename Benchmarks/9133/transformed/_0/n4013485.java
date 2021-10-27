class n4013485 {
	void copyFileOnPeer(String j9PuUxIp, RServerInfo OjBCwqaR, boolean liflUXQN) throws IOException {
		RFile ACuRGRsh = new RFile(j9PuUxIp);
		OutputStream AseJCP96 = null;
		FileInputStream QS6oJrg7 = null;
		try {
			QS6oJrg7 = fileManager.openFileRead(j9PuUxIp);
			AseJCP96 = localClient.openWrite(ACuRGRsh, false, WriteMode.TRANSACTED, 1, OjBCwqaR, !liflUXQN);
			IOUtils.copyLarge(QS6oJrg7, AseJCP96);
			AseJCP96.close();
			AseJCP96 = null;
		} finally {
			if (QS6oJrg7 != null) {
				try {
					QS6oJrg7.close();
				} catch (Throwable PbhZOcrN) {
				}
			}
			if (AseJCP96 != null) {
				try {
					AseJCP96.close();
				} catch (Throwable BIorkuPd) {
				}
			}
		}
	}

}