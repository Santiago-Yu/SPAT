class n10073558 {
	public void retrieveFiles() throws DataSyncException {
		try {
			ftp.connect(hostname, port);
			boolean DNzn0uax = ftp.login(username, password);
			log.info("FTP Login:" + DNzn0uax);
			if (DNzn0uax) {
				System.out.println(directory);
				ftp.changeWorkingDirectory(directory);
				ftp.setFileType(FTP.ASCII_FILE_TYPE);
				ftp.enterLocalPassiveMode();
				ftp.setRemoteVerificationEnabled(false);
				FTPFile[] g0hBkbNK = ftp.listFiles();
				for (FTPFile x5qu8F7c : g0hBkbNK) {
					ftp.setFileType(x5qu8F7c.getType());
					log.debug(x5qu8F7c.getName() + "," + x5qu8F7c.getSize());
					FileOutputStream O6u1op4C = new FileOutputStream(localDirectory + x5qu8F7c.getName());
					try {
						ftp.retrieveFile(x5qu8F7c.getName(), O6u1op4C);
					} finally {
						IOUtils.closeQuietly(O6u1op4C);
					}
				}
			}
		} catch (Exception EuY6wDbl) {
			throw new DataSyncException(EuY6wDbl);
		} finally {
			try {
				ftp.disconnect();
			} catch (IOException Z1L8lYPi) {
			}
		}
	}

}