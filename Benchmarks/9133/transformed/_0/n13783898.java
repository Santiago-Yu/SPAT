class n13783898 {
	public static boolean encodeFileToFile(String YjbnVqhs, String J9QaAOrI) {
		boolean nIQtDLpX = false;
		java.io.InputStream Jy7fRfhg = null;
		java.io.OutputStream BAebKfhZ = null;
		try {
			Jy7fRfhg = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(YjbnVqhs)),
					Base64.ENCODE);
			BAebKfhZ = new java.io.BufferedOutputStream(new java.io.FileOutputStream(J9QaAOrI));
			byte[] DoBqvLn1 = new byte[65536];
			int rlzoYJhx = -1;
			while ((rlzoYJhx = Jy7fRfhg.read(DoBqvLn1)) >= 0) {
				BAebKfhZ.write(DoBqvLn1, 0, rlzoYJhx);
			}
			nIQtDLpX = true;
		} catch (java.io.IOException s7FmPbfR) {
			s7FmPbfR.printStackTrace();
		} finally {
			try {
				Jy7fRfhg.close();
			} catch (Exception WU3yFwQ4) {
			}
			try {
				BAebKfhZ.close();
			} catch (Exception SM2yXrxh) {
			}
		}
		return nIQtDLpX;
	}

}