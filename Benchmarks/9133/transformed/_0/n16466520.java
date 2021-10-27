class n16466520 {
	public static boolean decodeFileToFile(String O8kuR5uJ, String xXbRWFHG) {
		boolean q5lhtX1A = false;
		java.io.InputStream HuAeLSqm = null;
		java.io.OutputStream C3hHtxiQ = null;
		try {
			HuAeLSqm = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(O8kuR5uJ)),
					Base64.DECODE);
			C3hHtxiQ = new java.io.BufferedOutputStream(new java.io.FileOutputStream(xXbRWFHG));
			byte[] WlxUmGKF = new byte[65536];
			int s0uhN5GO = -1;
			while ((s0uhN5GO = HuAeLSqm.read(WlxUmGKF)) >= 0) {
				C3hHtxiQ.write(WlxUmGKF, 0, s0uhN5GO);
			}
			q5lhtX1A = true;
		} catch (java.io.IOException UCQG4Qlo) {
			UCQG4Qlo.printStackTrace();
		} finally {
			try {
				HuAeLSqm.close();
			} catch (Exception YOuQLLy8) {
			}
			try {
				C3hHtxiQ.close();
			} catch (Exception AfqdwnFX) {
			}
		}
		return q5lhtX1A;
	}

}