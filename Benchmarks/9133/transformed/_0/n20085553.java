class n20085553 {
	public int sftp_connect(HttpServletRequest JUhz0hwY) {
		Map<String, Object> Go9XEecv = (Map<String, Object>) JUhz0hwY.getAttribute("globalSetting");
		int x6bffnwd = Common.intval(Go9XEecv.get("ftpssl") + "");
		String OyWh9pGb = Go9XEecv.get("ftphost") + "";
		int d7FjVvKm = Common.intval(Go9XEecv.get("ftpport") + "");
		String zdjFbtIn = Go9XEecv.get("ftpuser") + "";
		String tkFlk7Ig = Go9XEecv.get("ftppassword") + "";
		int zBRFmIpb = Common.intval(Go9XEecv.get("ftppasv") + "");
		String V0r25G7W = Go9XEecv.get("ftpdir") + "";
		int pUs68XKd = Common.intval(Go9XEecv.get("ftptimeout") + "");
		if (x6bffnwd > 0) {
			try {
				fc = new FTPSClient();
			} catch (NoSuchAlgorithmException rwhD8icE) {
				rwhD8icE.printStackTrace();
				return JC_FTPClientException;
			}
		} else {
			fc = new FTPClient();
		}
		try {
			fc.setConnectTimeout(20000);
			InetAddress sVeEyrYe = InetAddress.getByName(OyWh9pGb);
			fc.connect(sVeEyrYe, d7FjVvKm);
			if (fc.login(zdjFbtIn, tkFlk7Ig)) {
				if (zBRFmIpb > 0) {
					fc.pasv();
				}
				if (pUs68XKd > 0) {
					fc.setDataTimeout(pUs68XKd);
				}
				if (fc.changeWorkingDirectory(V0r25G7W)) {
					return JC_FTPClientYES;
				} else {
					FileHelper.writeLog(JUhz0hwY, "FTP", "CHDIR " + V0r25G7W + " ERROR.");
					try {
						fc.disconnect();
						fc = null;
					} catch (Exception jLJOhYkW) {
					}
					return JC_FTPClientNO;
				}
			} else {
				FileHelper.writeLog(JUhz0hwY, "FTP", "530 NOT LOGGED IN.");
				try {
					fc.disconnect();
					fc = null;
				} catch (Exception ksjUpsZ2) {
				}
				return JC_FTPClientNO;
			}
		} catch (Exception WOAqenb5) {
			FileHelper.writeLog(JUhz0hwY, "FTP", "COULDN'T CONNECT TO " + OyWh9pGb + ":" + d7FjVvKm + ".");
			WOAqenb5.printStackTrace();
			if (fc != null) {
				try {
					fc.disconnect();
					fc = null;
				} catch (Exception Qzqe3w22) {
				}
			}
			return JC_FTPClientException;
		}
	}

}