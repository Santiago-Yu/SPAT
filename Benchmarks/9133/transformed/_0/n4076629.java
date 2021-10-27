class n4076629 {
	public void uploadFile(String i2meO2q5) throws RQLException {
		checkFtpClient();
		OutputStream Ql2VkYpD = null;
		try {
			Ql2VkYpD = ftpClient.storeFileStream(i2meO2q5);
			IOUtils.copy(new FileReader(i2meO2q5), Ql2VkYpD);
			Ql2VkYpD.close();
			ftpClient.completePendingCommand();
		} catch (IOException DjdN33gY) {
			throw new RQLException(
					"Upload of local file with name " + i2meO2q5 + " via FTP to server " + server + " failed.",
					DjdN33gY);
		}
	}

}