class n4076620 {
	public boolean downloadFile(String sourceFilename, String targetFilename) throws RQLException {
		checkFtpClient();
		InputStream in = null;
		try {
			in = ftpClient.retrieveFileStream(sourceFilename);
			FileOutputStream target = new FileOutputStream(targetFilename);
			if (in == null) {
				return false;
			}
			IOUtils.copy(in, target);
			in.close();
			target.close();
			return ftpClient.completePendingCommand();
		} catch (IOException ex) {
			throw new RQLException(
					"Download of file with name " + sourceFilename + " via FTP from server " + server + " failed.", ex);
		}
	}

}