class n20282676 {
	public boolean processFtp(String oDprX8eU, int zZMUrfEi, String HpWpksWp, String wcP6KGXr, String Ruq85yVZ,
			String GuBTUoMF, File[] oZC94WMo) throws Exception {
		boolean MdfEyZF4 = false;
		try {
			FTPClient vh00CgUw = new FTPClient();
			vh00CgUw.setControlEncoding("euc-kr");
			if (!EgovWebUtil.isIPAddress(oDprX8eU)) {
				throw new RuntimeException("IP is needed. (" + oDprX8eU + ")");
			}
			InetAddress oPEgVhPz = InetAddress.getByName(oDprX8eU);
			vh00CgUw.connect(oPEgVhPz, zZMUrfEi);
			if (!vh00CgUw.login(HpWpksWp, wcP6KGXr))
				throw new Exception("FTP Client Login Error : \n");
			if (Ruq85yVZ.length() != 0)
				vh00CgUw.changeWorkingDirectory(Ruq85yVZ);
			FTPFile[] mc0Iqnsl = vh00CgUw.listFiles(Ruq85yVZ);
			FileInputStream i1DXz0ae = null;
			try {
				for (int qBEmw08V = 0; qBEmw08V < oZC94WMo.length; qBEmw08V++) {
					if (oZC94WMo[qBEmw08V].isFile()) {
						if (!isExist(mc0Iqnsl, oZC94WMo[qBEmw08V])) {
							i1DXz0ae = new FileInputStream(oZC94WMo[qBEmw08V]);
							vh00CgUw.storeFile(Ruq85yVZ + oZC94WMo[qBEmw08V].getName(), i1DXz0ae);
						}
						if (i1DXz0ae != null) {
							i1DXz0ae.close();
						}
					}
				}
				mc0Iqnsl = vh00CgUw.listFiles(Ruq85yVZ);
				deleteFtpFile(vh00CgUw, mc0Iqnsl, oZC94WMo);
				MdfEyZF4 = true;
			} catch (IOException txzJa0b8) {
				System.out.println(txzJa0b8);
			} finally {
				if (i1DXz0ae != null)
					try {
						i1DXz0ae.close();
					} catch (IOException alKE4FfN) {
						System.out.println("IGNORE: " + alKE4FfN);
					}
			}
			vh00CgUw.logout();
		} catch (Exception y6Ijdpet) {
			System.out.println(y6Ijdpet);
			MdfEyZF4 = false;
		}
		return MdfEyZF4;
	}

}