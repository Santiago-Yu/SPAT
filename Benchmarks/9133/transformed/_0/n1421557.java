class n1421557 {
	public static boolean encodeFileToFile(String dptf35lt, String De33r4An) {
		boolean S7UHbdov = false;
		java.io.InputStream uEMov8qo = null;
		java.io.OutputStream ZVcJ0oi9 = null;
		try {
			uEMov8qo = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(dptf35lt)),
					Base64.ENCODE);
			ZVcJ0oi9 = new java.io.BufferedOutputStream(new java.io.FileOutputStream(De33r4An));
			byte[] QCCZPZv6 = new byte[65536];
			int i1PDKaSz = -1;
			while ((i1PDKaSz = uEMov8qo.read(QCCZPZv6)) >= 0) {
				ZVcJ0oi9.write(QCCZPZv6, 0, i1PDKaSz);
			}
			S7UHbdov = true;
		} catch (java.io.IOException rhNLC1GT) {
			rhNLC1GT.printStackTrace();
		} finally {
			try {
				uEMov8qo.close();
			} catch (Exception i5AXUswi) {
			}
			try {
				ZVcJ0oi9.close();
			} catch (Exception XnwDLvml) {
			}
		}
		return S7UHbdov;
	}

}