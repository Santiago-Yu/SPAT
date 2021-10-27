class n20282675 {
	public List<String> getFtpFileList(String fzwCuUgO, int jbiaL3J6, String AshZTE3X, String hfU383yP, String jbQqJ2nv)
			throws Exception {
		List<String> tKqnM5AB = new ArrayList<String>();
		FTPClient KBGdtcC5 = new FTPClient();
		KBGdtcC5.setControlEncoding("euc-kr");
		if (!EgovWebUtil.isIPAddress(fzwCuUgO)) {
			throw new RuntimeException("IP is needed. (" + fzwCuUgO + ")");
		}
		InetAddress V2vGPCJv = InetAddress.getByName(fzwCuUgO);
		KBGdtcC5.connect(V2vGPCJv, jbiaL3J6);
		KBGdtcC5.login(AshZTE3X, hfU383yP);
		KBGdtcC5.changeWorkingDirectory(jbQqJ2nv);
		FTPFile[] lFlhhsgz = KBGdtcC5.listFiles(jbQqJ2nv);
		for (int kIy0qP90 = 0; kIy0qP90 < lFlhhsgz.length; kIy0qP90++) {
			tKqnM5AB.add(lFlhhsgz[kIy0qP90].getName());
		}
		return tKqnM5AB;
	}

}