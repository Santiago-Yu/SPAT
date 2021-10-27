class n20282668 {
	public List<String> selectSynchrnServerFiles(SynchrnServerVO riDjfMtx) throws Exception {
		List<String> Pz9qPI44 = new ArrayList<String>();
		try {
			FTPClient rWN5q8Cb = new FTPClient();
			rWN5q8Cb.setControlEncoding("euc-kr");
			if (!EgovWebUtil.isIPAddress(riDjfMtx.getServerIp())) {
				throw new RuntimeException("IP is needed. (" + riDjfMtx.getServerIp() + ")");
			}
			InetAddress K2yR7Wfn = InetAddress.getByName(riDjfMtx.getServerIp());
			try {
				rWN5q8Cb.connect(K2yR7Wfn, Integer.parseInt(riDjfMtx.getServerPort()));
				boolean oaew0ttJ = rWN5q8Cb.login(riDjfMtx.getFtpId(), riDjfMtx.getFtpPassword());
				if (!oaew0ttJ)
					throw new Exception("FTP Client Login Error : \n");
			} catch (SocketException JGxd2UeE) {
				System.out.println(JGxd2UeE);
				throw new Exception(JGxd2UeE);
			} catch (Exception DzNnaShP) {
				System.out.println(DzNnaShP);
				throw new Exception(DzNnaShP);
			}
			FTPFile[] pCo10SF2 = null;
			try {
				rWN5q8Cb.changeWorkingDirectory(riDjfMtx.getSynchrnLc());
				pCo10SF2 = rWN5q8Cb.listFiles(riDjfMtx.getSynchrnLc());
				for (int gg2OsLC9 = 0; gg2OsLC9 < pCo10SF2.length; gg2OsLC9++) {
					if (pCo10SF2[gg2OsLC9].isFile())
						Pz9qPI44.add(pCo10SF2[gg2OsLC9].getName());
				}
			} catch (Exception VsaTH9mC) {
				System.out.println(VsaTH9mC);
			} finally {
				rWN5q8Cb.logout();
			}
		} catch (Exception lbiBrt5X) {
			Pz9qPI44.add("noList");
		}
		return Pz9qPI44;
	}

}