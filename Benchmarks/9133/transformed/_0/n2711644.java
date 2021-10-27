class n2711644 {
	public static boolean encodeFileToFile(String gcBIRKpk, String COCIWnBf) {
		boolean y3yXhs2E = false;
		java.io.InputStream Tal4kPeN = null;
		java.io.OutputStream eCAAweVD = null;
		try {
			Tal4kPeN = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(gcBIRKpk)),
					Base64.ENCODE);
			eCAAweVD = new java.io.BufferedOutputStream(new java.io.FileOutputStream(COCIWnBf));
			byte[] EySwYpN7 = new byte[65536];
			int Ile8cAtu = -1;
			while ((Ile8cAtu = Tal4kPeN.read(EySwYpN7)) >= 0) {
				eCAAweVD.write(EySwYpN7, 0, Ile8cAtu);
			}
			y3yXhs2E = true;
		} catch (java.io.IOException KbHSe8ef) {
			KbHSe8ef.printStackTrace();
		} finally {
			try {
				Tal4kPeN.close();
			} catch (Exception Wjn0lGuk) {
			}
			try {
				eCAAweVD.close();
			} catch (Exception KNJxo1pd) {
			}
		}
		return y3yXhs2E;
	}

}