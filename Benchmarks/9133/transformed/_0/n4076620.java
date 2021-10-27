class n4076620 {
	public boolean downloadFile(String apIi9TOn, String WRj6c63I) throws RQLException {
		checkFtpClient();
		InputStream nCsHZ2Pf = null;
		try {
			nCsHZ2Pf = ftpClient.retrieveFileStream(apIi9TOn);
			if (nCsHZ2Pf == null) {
				return false;
			}
			FileOutputStream rGmJS56u = new FileOutputStream(WRj6c63I);
			IOUtils.copy(nCsHZ2Pf, rGmJS56u);
			nCsHZ2Pf.close();
			rGmJS56u.close();
			return ftpClient.completePendingCommand();
		} catch (IOException ueUCFSaF) {
			throw new RQLException(
					"Download of file with name " + apIi9TOn + " via FTP from server " + server + " failed.", ueUCFSaF);
		}
	}

}