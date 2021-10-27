class n6304370 {
	public static String[] viewFilesToImport(HttpSession session) {
		CofaxToolsUser user = (CofaxToolsUser) session.getAttribute("user");
		FTPClient ftp = new FTPClient();
		String importFTPServer = (String) user.workingPubConfigElementsHash.get("IMPORTFTPSERVER") + "";
		String importFTPLogin = (String) user.workingPubConfigElementsHash.get("IMPORTFTPLOGIN") + "";
		String importFTPPassword = (String) user.workingPubConfigElementsHash.get("IMPORTFTPPASSWORD") + "";
		String importFTPFilePath = (String) user.workingPubConfigElementsHash.get("IMPORTFTPFILEPATH");
		String[] dirList = null;
		boolean loggedIn = false;
		if (importFTPServer.equals("") || importFTPLogin.equals("") || importFTPPassword.equals("")) {
			return dirList;
		}
		try {
			int reply;
			ftp.connect(importFTPServer);
			CofaxToolsUtil.log("CofaxToolsFTP viewFilesToImport connecting: " + ftp.getReplyString());
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.logout();
				ftp.disconnect();
				CofaxToolsUtil.log("CofaxToolsFTP viewFilesToImport ERROR: FTP server refused connection.");
			} else {
				loggedIn = ftp.login(importFTPLogin, importFTPPassword);
				CofaxToolsUtil
						.log("CofaxToolsFTP viewFilesToImport Logging in: " + importFTPLogin + " " + importFTPPassword);
			}
			if (loggedIn) {
				try {
					ftp.changeWorkingDirectory(importFTPFilePath);
					CofaxToolsUtil.log("CofaxToolsFTP viewFilesToImport changing dir: " + importFTPFilePath);
					if (!FTPReply.isPositiveCompletion(reply)) {
						CofaxToolsUtil.log("ERROR: cannot change directory");
					}
					ArrayList tmpArray = new ArrayList();
					FTPFile[] remoteFileList = ftp.listFiles();
					for (int i = 0; i < remoteFileList.length; i++) {
						FTPFile testFile = remoteFileList[i];
						if (testFile.getType() == FTP.ASCII_FILE_TYPE) {
							tmpArray.add(testFile.getName());
						}
					}
					dirList = (String[]) tmpArray.toArray(new String[0]);
					ftp.logout();
					ftp.disconnect();
				} catch (java.io.IOException e) {
					CofaxToolsUtil.log("CofaxToolsFTP viewFilesToImport cannot read directory: " + importFTPFilePath);
				}
			}
		} catch (IOException e) {
			CofaxToolsUtil.log("CofaxToolsFTP viewFilesToImport could not connect to server: " + e);
		}
		return (dirList);
	}

}