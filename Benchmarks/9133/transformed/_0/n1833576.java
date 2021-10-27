class n1833576 {
	public FTPClient getFTP(final Credentials S87GQQtN, final String GOJqqCKE)
			throws NumberFormatException, SocketException, IOException, AccessDeniedException {
		String gAgdU83j = extractFilename(GOJqqCKE);
		String azY0O1xk = getPathName(GOJqqCKE).substring(0, getPathName(GOJqqCKE).indexOf(gAgdU83j));
		FTPClient fOwmlTql;
		fOwmlTql = new FTPClient();
		loadConfig();
		logger.info("FTP connection to: " + extractHostname(GOJqqCKE));
		logger.info("FTP PORT: " + prop.getProperty("port"));
		fOwmlTql.connect(extractHostname(GOJqqCKE), Integer.parseInt(prop.getProperty("port")));
		int yj57zNwB = fOwmlTql.getReplyCode();
		if (!(FTPReply.isPositiveCompletion(yj57zNwB))) {
			return null;
		}
		fOwmlTql.setFileTransferMode(org.apache.commons.net.ftp.FTP.BINARY_FILE_TYPE);
		fOwmlTql.setFileType(org.apache.commons.net.ftp.FTP.BINARY_FILE_TYPE);
		if (!fOwmlTql.login(S87GQQtN.getUserName(), S87GQQtN.getPassword())) {
			throw new AccessDeniedException(prop.getProperty("login_message"));
		}
		if (azY0O1xk != null) {
			fOwmlTql.changeWorkingDirectory(azY0O1xk);
		}
		return fOwmlTql;
	}

}