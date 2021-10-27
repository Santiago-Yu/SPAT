class n1966263 {
	public static boolean decodeFileToFile(String iW3fiUqN, String dgsxF0oW) {
		boolean qrQvqPzc = false;
		java.io.InputStream JW15obwv = null;
		java.io.OutputStream X8Gjbqtd = null;
		try {
			JW15obwv = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(iW3fiUqN)),
					Base64.DECODE);
			X8Gjbqtd = new java.io.BufferedOutputStream(new java.io.FileOutputStream(dgsxF0oW));
			byte[] JLYLtdCT = new byte[65536];
			int zAgpD0mt = -1;
			while ((zAgpD0mt = JW15obwv.read(JLYLtdCT)) >= 0) {
				X8Gjbqtd.write(JLYLtdCT, 0, zAgpD0mt);
			}
			qrQvqPzc = true;
		} catch (java.io.IOException Q7V4gLtB) {
			Q7V4gLtB.printStackTrace();
		} finally {
			try {
				JW15obwv.close();
			} catch (Exception PQ0sBl7D) {
			}
			try {
				X8Gjbqtd.close();
			} catch (Exception opCQZuET) {
			}
		}
		return qrQvqPzc;
	}

}