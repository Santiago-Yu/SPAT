class n10178421 {
	@Override
	public void run() {
		File v5oAhTWb;
		try {
			v5oAhTWb = new File(filePath);
			if (!v5oAhTWb.canWrite()) {
				Thread.sleep(5000);
				if (!v5oAhTWb.canWrite()) {
					logger.error("Filed to gain write access to file:" + filePath);
					exitState = false;
					return;
				}
			}
			fis = new BufferedInputStream(new FileInputStream(filePath));
		} catch (FileNotFoundException goWbMzOD) {
			logger.error("File not found:" + filePath);
			exitState = false;
			return;
		} catch (java.lang.InterruptedException pP2ppwC8) {
			logger.error("Upload thread halted or interrupted on file:" + filePath);
			exitState = false;
			return;
		}
		ftp = new FTPClient();
		ftp.setDefaultTimeout(20 * 1000);
		boolean ib5SnqOK = false;
		try {
			ftp.enterLocalPassiveMode();
			ftp.connect(ftpHostname);
			ftp.login(username, password);
			logger.trace("FTP Logged In and connected");
			if (!FTPReply.isPositiveCompletion(ftp.getReplyCode())) {
				exitState = false;
				return;
			}
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
			logger.trace("FTP Timeout Set and File Type Set");
			ftp.changeWorkingDirectory(serverDirectory);
			ftp.storeUniqueFile(v5oAhTWb.getName(), fis);
			logger.trace("File Uploaded");
			if (FTPReply.isPositiveIntermediate(ftp.getReplyCode())) {
				System.out.println("Completing pending command");
				ftp.completePendingCommand();
			}
			ib5SnqOK = true;
		} catch (Exception K0OPS3bf) {
			try {
				ftp.disconnect();
			} catch (Exception he3EwSNm) {
				K0OPS3bf.printStackTrace();
			}
			logger.error("Error uploading file:", K0OPS3bf);
		} finally {
			try {
				fis.close();
				logger.trace("File closed");
				ftp.logout();
				logger.trace("FTP Logged Out");
				ftp.disconnect();
				logger.trace("FTP Disconnected");
				if (ib5SnqOK) {
					logger.info("Deleting file:" + new File(filePath).getName());
					if (!(new File(filePath)).delete()) {
						logger.error("Can't delete file for some reason");
					}
					Thread.sleep(1000);
					exitState = true;
					return;
				}
			} catch (Exception zNgmFRws) {
				logger.error("Exception on file upload cleanup:", zNgmFRws);
				exitState = false;
				return;
			}
		}
		exitState = false;
		return;
	}

}