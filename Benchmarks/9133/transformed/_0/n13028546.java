class n13028546 {
	public static boolean encodeFileToFile(String xUB0SAw2, String NUGpoPMG) {
		boolean gIj9ILtf = false;
		java.io.InputStream ZLnkKZJl = null;
		java.io.OutputStream TjnRb03h = null;
		try {
			ZLnkKZJl = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(xUB0SAw2)),
					Base64.ENCODE);
			TjnRb03h = new java.io.BufferedOutputStream(new java.io.FileOutputStream(NUGpoPMG));
			byte[] Qc2Cumbz = new byte[65536];
			int vvPAHDIq = -1;
			while ((vvPAHDIq = ZLnkKZJl.read(Qc2Cumbz)) >= 0) {
				TjnRb03h.write(Qc2Cumbz, 0, vvPAHDIq);
			}
			gIj9ILtf = true;
		} catch (java.io.IOException T0MZ6LVC) {
			T0MZ6LVC.printStackTrace();
		} finally {
			try {
				ZLnkKZJl.close();
			} catch (Exception tndXsVvD) {
			}
			try {
				TjnRb03h.close();
			} catch (Exception B5B5Aeo1) {
			}
		}
		return gIj9ILtf;
	}

}