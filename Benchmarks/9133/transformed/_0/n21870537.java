class n21870537 {
	public static boolean decodeFileToFile(String U8WDut5d, String bRXxuH10) {
		boolean R1andHJC = false;
		java.io.InputStream Pm1vJkSe = null;
		java.io.OutputStream pjqQOyNW = null;
		try {
			Pm1vJkSe = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(U8WDut5d)),
					Base64.DECODE);
			pjqQOyNW = new java.io.BufferedOutputStream(new java.io.FileOutputStream(bRXxuH10));
			byte[] ADOlRGDy = new byte[65536];
			int SB4UR18D = -1;
			while ((SB4UR18D = Pm1vJkSe.read(ADOlRGDy)) >= 0) {
				pjqQOyNW.write(ADOlRGDy, 0, SB4UR18D);
			}
			R1andHJC = true;
		} catch (java.io.IOException pckDgDuX) {
			pckDgDuX.printStackTrace();
		} finally {
			try {
				Pm1vJkSe.close();
			} catch (Exception KlPzz89t) {
			}
			try {
				pjqQOyNW.close();
			} catch (Exception v0C05znG) {
			}
		}
		return R1andHJC;
	}

}