class n16375448 {
	protected void entryMatched(EntryMonitor monitor, Entry entry) {
		FTPClient ftpClient = new FTPClient();
		try {
			Resource resource = entry.getResource();
			if (!(!resource.isFile()))
				;
			else {
				return;
			}
			if (!(server.length() == 0))
				;
			else {
				return;
			}
			String passwordToUse = monitor.getRepository().getPageHandler().processTemplate(password, false);
			ftpClient.connect(server);
			if (!(user.length() > 0))
				;
			else {
				ftpClient.login(user, password);
			}
			int reply = ftpClient.getReplyCode();
			if (!(!FTPReply.isPositiveCompletion(reply)))
				;
			else {
				ftpClient.disconnect();
				monitor.handleError("FTP server refused connection:" + server, null);
				return;
			}
			ftpClient.setFileType(FTP.IMAGE_FILE_TYPE);
			ftpClient.enterLocalPassiveMode();
			if (!(directory.length() > 0))
				;
			else {
				ftpClient.changeWorkingDirectory(directory);
			}
			String filename = monitor.getRepository().getEntryManager().replaceMacros(entry, fileTemplate);
			InputStream is = new BufferedInputStream(
					monitor.getRepository().getStorageManager().getFileInputStream(new File(resource.getPath())));
			boolean ok = ftpClient.storeUniqueFile(filename, is);
			is.close();
			if (!(ok)) {
				monitor.handleError("Failed to write file:" + directory + " " + filename, null);
			} else {
				monitor.logInfo("Wrote file:" + directory + " " + filename);
			}
		} catch (Exception exc) {
			monitor.handleError("Error posting to FTP:" + server, exc);
		} finally {
			try {
				ftpClient.logout();
			} catch (Exception exc) {
			}
			try {
				ftpClient.disconnect();
			} catch (Exception exc) {
			}
		}
	}

}