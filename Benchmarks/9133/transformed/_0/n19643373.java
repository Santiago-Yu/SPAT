class n19643373 {
	public static boolean decodeFileToFile(String YCzltZvn, String t8pak94a) {
		boolean WoiMAfHf = false;
		java.io.InputStream LnXFeubk = null;
		java.io.OutputStream CRVMe0fC = null;
		try {
			LnXFeubk = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(YCzltZvn)),
					Base64.DECODE);
			CRVMe0fC = new java.io.BufferedOutputStream(new java.io.FileOutputStream(t8pak94a));
			byte[] nSJK33ly = new byte[65536];
			int Ln4ALNmb = -1;
			while ((Ln4ALNmb = LnXFeubk.read(nSJK33ly)) >= 0) {
				CRVMe0fC.write(nSJK33ly, 0, Ln4ALNmb);
			}
			WoiMAfHf = true;
		} catch (java.io.IOException t9kKEI3q) {
			logger.error(Logger.SECURITY_FAILURE, "Problem decoding file to file", t9kKEI3q);
		} finally {
			try {
				LnXFeubk.close();
			} catch (Exception AcjMFlpf) {
			}
			try {
				CRVMe0fC.close();
			} catch (Exception zyH3bNfI) {
			}
		}
		return WoiMAfHf;
	}

}