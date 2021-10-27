class n13783899 {
	public static boolean decodeFileToFile(String pdmDx6Jq, String t5chIEb3) {
		boolean kkUbVbxK = false;
		java.io.InputStream LqZqB9fl = null;
		java.io.OutputStream a5o4s9IX = null;
		try {
			LqZqB9fl = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(pdmDx6Jq)),
					Base64.DECODE);
			a5o4s9IX = new java.io.BufferedOutputStream(new java.io.FileOutputStream(t5chIEb3));
			byte[] gOSZdpXO = new byte[65536];
			int o50Ds8U5 = -1;
			while ((o50Ds8U5 = LqZqB9fl.read(gOSZdpXO)) >= 0) {
				a5o4s9IX.write(gOSZdpXO, 0, o50Ds8U5);
			}
			kkUbVbxK = true;
		} catch (java.io.IOException uOKcXPgh) {
			uOKcXPgh.printStackTrace();
		} finally {
			try {
				LqZqB9fl.close();
			} catch (Exception BgRbp7Hd) {
			}
			try {
				a5o4s9IX.close();
			} catch (Exception ZyqH0h7v) {
			}
		}
		return kkUbVbxK;
	}

}