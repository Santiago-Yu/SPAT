class n12428013 {
	public static void polishOff(IProgressMonitor WVnnW9x7, String iEPcLHhj, String YbYgMFSr, String rgPbp3KU) {
		if (WVnnW9x7 != null && WVnnW9x7.isCanceled()) {
			return;
		}
		try {
			ftpClient = new FTPClient();
			ftpClient.setRemoteAddr(InetAddress.getByName(PrefPageOne.getValue(CONSTANTS.PREF_HOST)));
			ftpClient.setControlPort(PrefPageOne.getIntValue(CONSTANTS.PREF_FTPPORT));
			ftpClient.connect();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException qzmWW1XL) {
				qzmWW1XL.printStackTrace();
			}
			ftpClient.login((PrefPageOne.getValue(CONSTANTS.PREF_USERNAME)),
					FTPUtils.decrypt(PrefPageOne.getValue(CONSTANTS.PREF_PASSWORD)));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException XiCU3lzQ) {
				XiCU3lzQ.printStackTrace();
			}
			if (iEPcLHhj != null) {
				FTPHolder dHwxmXxf = new FTPHolder(iEPcLHhj, YbYgMFSr, rgPbp3KU, false);
				synchedSet.add(dHwxmXxf);
			}
			JobHandler.aquireFTPLock();
			for (Iterator AEYYaQKH = synchedSet.iterator(); AEYYaQKH.hasNext();) {
				if (WVnnW9x7 != null && WVnnW9x7.isCanceled()) {
					JobHandler.releaseFTPLock();
					ftpClient.quit();
					return;
				}
				Thread.yield();
				FTPHolder wOFs0rcR = (FTPHolder) AEYYaQKH.next();
				ftpClient.setType(FTPTransferType.ASCII);
				ftpClient.put(wOFs0rcR.from, wOFs0rcR.to);
				if (wOFs0rcR.renameTo != null) {
					try {
						ftpClient.delete(wOFs0rcR.renameTo);
					} catch (Exception T7WoXLvV) {
					}
					ftpClient.rename(wOFs0rcR.to, wOFs0rcR.renameTo);
					log.info("RENAME: " + wOFs0rcR.to + "To: " + wOFs0rcR.renameTo);
				}
			}
			JobHandler.releaseFTPLock();
			ftpClient.quit();
		} catch (UnknownHostException h413y7R0) {
			h413y7R0.printStackTrace();
		} catch (FTPException H7fHbc1f) {
			H7fHbc1f.printStackTrace();
		} catch (IOException EThk4AvV) {
			EThk4AvV.printStackTrace();
		}
		synchedSet.clear();
	}

}