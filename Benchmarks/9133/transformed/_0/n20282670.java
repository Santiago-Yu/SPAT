class n20282670 {
	public void downloadFtpFile(SynchrnServerVO nZSBtlSH, String tzcxGbZj) throws Exception {
		FTPClient pEmSBB5M = new FTPClient();
		pEmSBB5M.setControlEncoding("euc-kr");
		if (!EgovWebUtil.isIPAddress(nZSBtlSH.getServerIp())) {
			throw new RuntimeException("IP is needed. (" + nZSBtlSH.getServerIp() + ")");
		}
		InetAddress Rv0FHTN0 = InetAddress.getByName(nZSBtlSH.getServerIp());
		pEmSBB5M.connect(Rv0FHTN0, Integer.parseInt(nZSBtlSH.getServerPort()));
		pEmSBB5M.login(nZSBtlSH.getFtpId(), nZSBtlSH.getFtpPassword());
		pEmSBB5M.changeWorkingDirectory(nZSBtlSH.getSynchrnLc());
		File mrP4pVAy = new File(EgovWebUtil.filePathBlackList(nZSBtlSH.getFilePath() + tzcxGbZj));
		OutputStream IUtPzGE9 = null;
		try {
			IUtPzGE9 = new FileOutputStream(mrP4pVAy);
			pEmSBB5M.retrieveFile(tzcxGbZj, IUtPzGE9);
		} catch (Exception qJDonAGR) {
			System.out.println(qJDonAGR);
		} finally {
			if (IUtPzGE9 != null)
				IUtPzGE9.close();
		}
		pEmSBB5M.logout();
	}

}