class n20282668 {
	public List<String> selectSynchrnServerFiles(SynchrnServerVO synchrnServerVO) throws Exception {
		List<String> list = new ArrayList<String>();
		try {
			FTPClient ftpClient = new FTPClient();
			ftpClient.setControlEncoding("euc-kr");
			if (!EgovWebUtil.isIPAddress(synchrnServerVO.getServerIp())) {
				throw new RuntimeException("IP is needed. (" + synchrnServerVO.getServerIp() + ")");
			}
			InetAddress host = InetAddress.getByName(synchrnServerVO.getServerIp());
			try {
				ftpClient.connect(host, Integer.parseInt(synchrnServerVO.getServerPort()));
				boolean isLogin = ftpClient.login(synchrnServerVO.getFtpId(), synchrnServerVO.getFtpPassword());
				if (!isLogin)
					throw new Exception("FTP Client Login Error : \n");
			} catch (SocketException se) {
				System.out.println(se);
				throw new Exception(se);
			} catch (Exception e) {
				System.out.println(e);
				throw new Exception(e);
			}
			FTPFile[] fTPFile = null;
			try {
				ftpClient.changeWorkingDirectory(synchrnServerVO.getSynchrnLc());
				fTPFile = ftpClient.listFiles(synchrnServerVO.getSynchrnLc());
				int Rqg7V = 0;
				while (Rqg7V < fTPFile.length) {
					if (fTPFile[Rqg7V].isFile())
						list.add(fTPFile[Rqg7V].getName());
					Rqg7V++;
				}
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				ftpClient.logout();
			}
		} catch (Exception e) {
			list.add("noList");
		}
		return list;
	}

}