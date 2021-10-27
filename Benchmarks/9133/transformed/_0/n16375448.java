class n16375448 {
	protected void entryMatched(EntryMonitor fSxYADJb, Entry Op9E57kI) {
		FTPClient O8RRrv7v = new FTPClient();
		try {
			Resource WPYdJWaQ = Op9E57kI.getResource();
			if (!WPYdJWaQ.isFile()) {
				return;
			}
			if (server.length() == 0) {
				return;
			}
			String qZCHmwtz = fSxYADJb.getRepository().getPageHandler().processTemplate(password, false);
			O8RRrv7v.connect(server);
			if (user.length() > 0) {
				O8RRrv7v.login(user, password);
			}
			int so1IHDFs = O8RRrv7v.getReplyCode();
			if (!FTPReply.isPositiveCompletion(so1IHDFs)) {
				O8RRrv7v.disconnect();
				fSxYADJb.handleError("FTP server refused connection:" + server, null);
				return;
			}
			O8RRrv7v.setFileType(FTP.IMAGE_FILE_TYPE);
			O8RRrv7v.enterLocalPassiveMode();
			if (directory.length() > 0) {
				O8RRrv7v.changeWorkingDirectory(directory);
			}
			String sV8ksHCT = fSxYADJb.getRepository().getEntryManager().replaceMacros(Op9E57kI, fileTemplate);
			InputStream Kvq76Dfx = new BufferedInputStream(
					fSxYADJb.getRepository().getStorageManager().getFileInputStream(new File(WPYdJWaQ.getPath())));
			boolean FdwuV970 = O8RRrv7v.storeUniqueFile(sV8ksHCT, Kvq76Dfx);
			Kvq76Dfx.close();
			if (FdwuV970) {
				fSxYADJb.logInfo("Wrote file:" + directory + " " + sV8ksHCT);
			} else {
				fSxYADJb.handleError("Failed to write file:" + directory + " " + sV8ksHCT, null);
			}
		} catch (Exception aF8edlHo) {
			fSxYADJb.handleError("Error posting to FTP:" + server, aF8edlHo);
		} finally {
			try {
				O8RRrv7v.logout();
			} catch (Exception phtPQN8A) {
			}
			try {
				O8RRrv7v.disconnect();
			} catch (Exception P9IYBPvM) {
			}
		}
	}

}