class n4629990 {
	private String logonToServer(FTPClient BAdi9S7r, String dpQtWyGX, int BAwiTF2T) {
		String Gmumq8U2 = null;
		noRetriesSoFar = 0;
		while (true) {
			try {
				BAdi9S7r.connect(dpQtWyGX, ftpPort);
				int TYbOXDkz = BAdi9S7r.getReplyCode();
				if (!FTPReply.isPositiveCompletion(TYbOXDkz)) {
					BAdi9S7r.disconnect();
					throw new IOException();
				}
				if (!BAdi9S7r.login(user, password)) {
					throw new IOException();
				}
				Gmumq8U2 = BAdi9S7r.printWorkingDirectory();
				msgEntry.setAppContext("logonToServer()");
				msgEntry.setMessageText("Logged into FTP server " + dpQtWyGX + ":" + ftpPort + " as user " + user);
				logger.logProcess(msgEntry);
				break;
			} catch (IOException y20ajEpe) {
				logoutAndDisconnect(BAdi9S7r);
				if (noRetriesSoFar++ < BAwiTF2T) {
					waitBetweenRetry();
					notifyAndStartWaitingFlag = false;
				} else {
					notifyAndStartWaitingFlag = true;
					errEntry.setThrowable(y20ajEpe);
					errEntry.setAppContext("logonToServer()");
					errEntry.setAppMessage("Unable to login after " + (noRetriesSoFar - 1) + " retries. Max Retries.\n"
							+ "Address:" + dpQtWyGX + "\n" + "User:" + user);
					errEntry.setSubjectSendEmail(
							"Unable to login to " + dpQtWyGX + " after " + (noRetriesSoFar - 1) + " retries.");
					logger.logError(errEntry);
					break;
				}
			}
		}
		return Gmumq8U2;
	}

}