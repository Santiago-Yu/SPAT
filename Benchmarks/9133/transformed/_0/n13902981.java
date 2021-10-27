class n13902981 {
	public static boolean decodeFileToFile(String JoZtxCRG, String LQQ8QPW5) {
		boolean nmLcpbdR = false;
		java.io.InputStream lb6vxzI3 = null;
		java.io.OutputStream pK290PYw = null;
		try {
			lb6vxzI3 = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(JoZtxCRG)),
					Base64.DECODE);
			pK290PYw = new java.io.BufferedOutputStream(new java.io.FileOutputStream(LQQ8QPW5));
			byte[] N0irk27P = new byte[65536];
			int bELb580d = -1;
			while ((bELb580d = lb6vxzI3.read(N0irk27P)) >= 0) {
				pK290PYw.write(N0irk27P, 0, bELb580d);
			}
			nmLcpbdR = true;
		} catch (java.io.IOException iD49nMNv) {
			iD49nMNv.printStackTrace();
		} finally {
			try {
				lb6vxzI3.close();
			} catch (Exception BYEbqHgj) {
			}
			try {
				pK290PYw.close();
			} catch (Exception giv9pSb2) {
			}
		}
		return nmLcpbdR;
	}

}