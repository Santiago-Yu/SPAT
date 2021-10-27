class n9088423 {
	public static boolean decodeFileToFile(String vIfKkHrC, String AUjoJPZV) {
		boolean rKROFZMp = false;
		java.io.InputStream b5Aqzb9q = null;
		java.io.OutputStream Zje2loPz = null;
		try {
			b5Aqzb9q = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(vIfKkHrC)),
					Base64.DECODE);
			Zje2loPz = new java.io.BufferedOutputStream(new java.io.FileOutputStream(AUjoJPZV));
			byte[] ua0zvCDt = new byte[65536];
			int rJCevHEl = -1;
			while ((rJCevHEl = b5Aqzb9q.read(ua0zvCDt)) >= 0) {
				Zje2loPz.write(ua0zvCDt, 0, rJCevHEl);
			}
			rKROFZMp = true;
		} catch (java.io.IOException DDUzVKK6) {
			DDUzVKK6.printStackTrace();
		} finally {
			try {
				b5Aqzb9q.close();
			} catch (Exception HfzylCdy) {
			}
			try {
				Zje2loPz.close();
			} catch (Exception TIVeIcsX) {
			}
		}
		return rKROFZMp;
	}

}