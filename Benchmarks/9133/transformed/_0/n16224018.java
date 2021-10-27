class n16224018 {
	public static boolean decodeFileToFile(String WMBwKMZJ, String Mf29yC3e) {
		boolean JSZQrTdC = false;
		java.io.InputStream WBXYO7gJ = null;
		java.io.OutputStream b9rIPttb = null;
		try {
			WBXYO7gJ = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(WMBwKMZJ)),
					Base64.DECODE);
			b9rIPttb = new java.io.BufferedOutputStream(new java.io.FileOutputStream(Mf29yC3e));
			byte[] r6jH6CMO = new byte[65536];
			int qrBuAJrA = -1;
			while ((qrBuAJrA = WBXYO7gJ.read(r6jH6CMO)) >= 0) {
				b9rIPttb.write(r6jH6CMO, 0, qrBuAJrA);
			}
			JSZQrTdC = true;
		} catch (java.io.IOException ZYgT8PIH) {
			ZYgT8PIH.printStackTrace();
		} finally {
			try {
				WBXYO7gJ.close();
			} catch (Exception ofaqznIb) {
			}
			try {
				b9rIPttb.close();
			} catch (Exception uEM6SAj0) {
			}
		}
		return JSZQrTdC;
	}

}