class n12428012 {
	public static void putWithUserSettings(String DVhmQJAU, String wx4Mw1Je, String cupLrFfb, boolean WlYsPy3F,
			IProgressMonitor UKlCr2MB) {
		if (UKlCr2MB != null && UKlCr2MB.isCanceled()) {
			return;
		}
		FTPHolder nLr5JpMR = new FTPHolder(DVhmQJAU, wx4Mw1Je, cupLrFfb, WlYsPy3F);
		synchedSet.add(nLr5JpMR);
		int QEFV4Dou = PrefPageOne.getIntValue(CONSTANTS.PREF_FTPQUEUE);
		if (synchedSet.size() >= QEFV4Dou) {
			JobHandler.aquireFTPLock();
			try {
				ftpClient = new FTPClient();
				ftpClient.setRemoteAddr(InetAddress.getByName(PrefPageOne.getValue(CONSTANTS.PREF_HOST)));
				ftpClient.setControlPort(PrefPageOne.getIntValue(CONSTANTS.PREF_FTPPORT));
				ftpClient.connect();
				try {
					Thread.sleep(1500);
				} catch (InterruptedException yrDoAoWn) {
					yrDoAoWn.printStackTrace();
				}
				ftpClient.login((PrefPageOne.getValue(CONSTANTS.PREF_USERNAME)),
						FTPUtils.decrypt(PrefPageOne.getValue(CONSTANTS.PREF_PASSWORD)));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException JKAHVNGS) {
					JKAHVNGS.printStackTrace();
				}
				if (UKlCr2MB != null && UKlCr2MB.isCanceled()) {
					JobHandler.releaseFTPLock();
					ftpClient.quit();
					return;
				}
				synchronized (synchedSet) {
					for (Iterator Z8l1AJpm = synchedSet.iterator(); Z8l1AJpm.hasNext();) {
						if (UKlCr2MB != null && UKlCr2MB.isCanceled()) {
							JobHandler.releaseFTPLock();
							ftpClient.quit();
							return;
						}
						Thread.yield();
						FTPHolder kVwQPwdQ = (FTPHolder) Z8l1AJpm.next();
						if (kVwQPwdQ.binary) {
							ftpClient.setType(FTPTransferType.BINARY);
						} else {
							ftpClient.setType(FTPTransferType.ASCII);
						}
						ftpClient.put(kVwQPwdQ.from, kVwQPwdQ.to);
						if (kVwQPwdQ.renameTo != null) {
							try {
								ftpClient.delete(kVwQPwdQ.renameTo);
							} catch (Exception ihy9xS54) {
							}
							ftpClient.rename(kVwQPwdQ.to, kVwQPwdQ.renameTo);
							log.info("RENAME: " + kVwQPwdQ.to + "To: " + kVwQPwdQ.renameTo);
						}
					}
					synchedSet.clear();
				}
				JobHandler.releaseFTPLock();
				ftpClient.quit();
			} catch (UnknownHostException NnDUZfuP) {
				NnDUZfuP.printStackTrace();
			} catch (FTPException b0PlCGw5) {
				b0PlCGw5.printStackTrace();
			} catch (IOException tj35VKce) {
				tj35VKce.printStackTrace();
			}
		}
	}

}