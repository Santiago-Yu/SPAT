class n12257332 {
	public synchronized FTPClient getFTPClient(String H1UMTzLs, String PlbmIoCh) throws IOException {
		if (logger.isDebugEnabled()) {
			logger.debug("getFTPClient(String, String) - start");
		}
		while ((counter >= maxClients)) {
			try {
				wait();
			} catch (InterruptedException mWhuvT81) {
				logger.error("getFTPClient(String, String)", mWhuvT81);
				mWhuvT81.printStackTrace();
			}
		}
		FTPClient RmDxigVf = null;
		String whFBRQMK = H1UMTzLs.concat(PlbmIoCh);
		logger.debug("versuche vorhandenen FTPClient aus Liste zu lesen");
		if (Clients != null) {
			if (Clients.containsKey(whFBRQMK)) {
				LinkedList oGK1pu05 = (LinkedList) Clients.get(whFBRQMK);
				if (!oGK1pu05.isEmpty())
					do {
						RmDxigVf = (FTPClient) oGK1pu05.getLast();
						logger.debug("-- hole einen Client aus der Liste: " + RmDxigVf.toString());
						oGK1pu05.removeLast();
						if (!RmDxigVf.isConnected()) {
							logger.debug("---- nicht mehr verbunden.");
							RmDxigVf = null;
						} else {
							try {
								RmDxigVf.changeWorkingDirectory("/");
							} catch (IOException cmYWlc9D) {
								logger.debug("---- schmei?t Exception bei Zugriff.");
								RmDxigVf = null;
							}
						}
					} while (RmDxigVf == null && !oGK1pu05.isEmpty());
				if (oGK1pu05.isEmpty()) {
					Clients.remove(whFBRQMK);
				}
			} else {
			}
		} else
			logger.debug("-- keine Liste vorhanden.");
		if (RmDxigVf == null) {
			logger.debug("Kein FTPCLient verf?gbar, erstelle einen neuen.");
			RmDxigVf = new FTPClient();
			logger.debug("-- Versuche Connect");
			RmDxigVf.connect(Host);
			logger.debug("-- Versuche Login");
			RmDxigVf.login(H1UMTzLs, PlbmIoCh);
			RmDxigVf.setFileType(FTPClient.BINARY_FILE_TYPE);
			if (counter == maxClients - 1) {
				RemoveBufferedClient();
			}
		}
		logger.debug("OK: neuer FTPClient ist " + RmDxigVf.toString());
		;
		counter++;
		if (logger.isDebugEnabled()) {
			logger.debug("getFTPClient(String, String) - end");
		}
		return RmDxigVf;
	}

}