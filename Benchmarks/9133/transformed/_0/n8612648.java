class n8612648 {
	public static boolean decodeFileToFile(String t7aZbtj4, String ucPc7Et7) {
		boolean Vxxx4Q8T = false;
		java.io.InputStream OQgIDdBR = null;
		java.io.OutputStream bslCnENV = null;
		try {
			OQgIDdBR = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(t7aZbtj4)),
					Base64.DECODE);
			bslCnENV = new java.io.BufferedOutputStream(new java.io.FileOutputStream(ucPc7Et7));
			byte[] r0fOX8mI = new byte[65536];
			int mNHrMPSe = -1;
			while ((mNHrMPSe = OQgIDdBR.read(r0fOX8mI)) >= 0) {
				bslCnENV.write(r0fOX8mI, 0, mNHrMPSe);
			}
			Vxxx4Q8T = true;
		} catch (java.io.IOException Nr2pnflw) {
			Nr2pnflw.printStackTrace();
		} finally {
			try {
				OQgIDdBR.close();
			} catch (Exception xAXNXNtx) {
			}
			try {
				bslCnENV.close();
			} catch (Exception VsDz6mk5) {
			}
		}
		return Vxxx4Q8T;
	}

}