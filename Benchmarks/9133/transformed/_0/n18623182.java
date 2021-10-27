class n18623182 {
	public static boolean encodeFileToFile(String gfA4WaP6, String ROSrA9Dc) {
		boolean t78gKn3H = false;
		java.io.InputStream tJ8verHW = null;
		java.io.OutputStream fPxHTzsx = null;
		try {
			tJ8verHW = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(gfA4WaP6)),
					Base64.ENCODE);
			fPxHTzsx = new java.io.BufferedOutputStream(new java.io.FileOutputStream(ROSrA9Dc));
			byte[] z3WtsHew = new byte[65536];
			int SusqlRGl = -1;
			while ((SusqlRGl = tJ8verHW.read(z3WtsHew)) >= 0) {
				fPxHTzsx.write(z3WtsHew, 0, SusqlRGl);
			}
			t78gKn3H = true;
		} catch (java.io.IOException PO2BNyHo) {
			PO2BNyHo.printStackTrace();
		} finally {
			try {
				tJ8verHW.close();
			} catch (Exception mC8KZZdM) {
			}
			try {
				fPxHTzsx.close();
			} catch (Exception YFaMQYMP) {
			}
		}
		return t78gKn3H;
	}

}