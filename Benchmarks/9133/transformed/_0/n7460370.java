class n7460370 {
	public static boolean decodeFileToFile(String SfyWBgYN, String H9Evw4MM) {
		boolean QsBOFNvn = false;
		java.io.InputStream Gydqm59E = null;
		java.io.OutputStream FpHur3jg = null;
		try {
			Gydqm59E = new Base64.B64InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(SfyWBgYN)),
					Base64.DECODE);
			FpHur3jg = new java.io.BufferedOutputStream(new java.io.FileOutputStream(H9Evw4MM));
			byte[] O41Zc1cr = new byte[65536];
			int CTKPLFix = -1;
			while ((CTKPLFix = Gydqm59E.read(O41Zc1cr)) >= 0) {
				FpHur3jg.write(O41Zc1cr, 0, CTKPLFix);
			}
			QsBOFNvn = true;
		} catch (java.io.IOException Kadb2MQk) {
			Kadb2MQk.printStackTrace();
		} finally {
			try {
				Gydqm59E.close();
			} catch (Exception SrQLSsRn) {
			}
			try {
				FpHur3jg.close();
			} catch (Exception XrGZrBVN) {
			}
		}
		return QsBOFNvn;
	}

}