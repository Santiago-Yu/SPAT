class n20282669 {
	public void deleteSynchrnServerFile(SynchrnServerVO bYTvPgL0) throws Exception {
		FTPClient kLIun43A = new FTPClient();
		kLIun43A.setControlEncoding("euc-kr");
		if (!EgovWebUtil.isIPAddress(bYTvPgL0.getServerIp())) {
			throw new RuntimeException("IP is needed. (" + bYTvPgL0.getServerIp() + ")");
		}
		InetAddress ajDgKUFw = InetAddress.getByName(bYTvPgL0.getServerIp());
		kLIun43A.connect(ajDgKUFw, Integer.parseInt(bYTvPgL0.getServerPort()));
		kLIun43A.login(bYTvPgL0.getFtpId(), bYTvPgL0.getFtpPassword());
		FTPFile[] uETQSfoX = null;
		try {
			kLIun43A.changeWorkingDirectory(bYTvPgL0.getSynchrnLc());
			uETQSfoX = kLIun43A.listFiles(bYTvPgL0.getSynchrnLc());
			for (int ym3jMRE7 = 0; ym3jMRE7 < uETQSfoX.length; ym3jMRE7++) {
				if (bYTvPgL0.getDeleteFileNm().equals(uETQSfoX[ym3jMRE7].getName()))
					kLIun43A.deleteFile(uETQSfoX[ym3jMRE7].getName());
			}
			SynchrnServer gCBpI0k1 = new SynchrnServer();
			gCBpI0k1.setServerId(bYTvPgL0.getServerId());
			gCBpI0k1.setReflctAt("N");
			synchrnServerDAO.processSynchrn(gCBpI0k1);
		} catch (Exception yIwgKDpK) {
			System.out.println(yIwgKDpK);
		} finally {
			kLIun43A.logout();
		}
	}

}