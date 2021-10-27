class n21605296 {
	public void transport(File sGKg58Oy) throws TransportException {
		FTPClient m3MzOKF8 = new FTPClient();
		try {
			m3MzOKF8.connect(getOption("host"));
			m3MzOKF8.login(getOption("username"), getOption("password"));
			m3MzOKF8.changeWorkingDirectory(getOption("remotePath"));
			transportRecursive(m3MzOKF8, sGKg58Oy);
			m3MzOKF8.disconnect();
		} catch (Exception I630Q8XQ) {
			throw new TransportException(I630Q8XQ);
		}
	}

}