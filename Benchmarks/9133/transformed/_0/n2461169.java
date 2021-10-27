class n2461169 {
	public static boolean decodeFileToFile(String vqudJ2ps, String p0afQRdT) {
		boolean FvpaP0kd = false;
		java.io.InputStream SzHys95B = null;
		java.io.OutputStream fDxvFAqC = null;
		try {
			SzHys95B = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(vqudJ2ps)),
					Base64.DECODE);
			fDxvFAqC = new java.io.BufferedOutputStream(new java.io.FileOutputStream(p0afQRdT));
			byte[] l9vFBPD2 = new byte[65536];
			int QGx9gcZJ = -1;
			while ((QGx9gcZJ = SzHys95B.read(l9vFBPD2)) >= 0) {
				fDxvFAqC.write(l9vFBPD2, 0, QGx9gcZJ);
			}
			FvpaP0kd = true;
		} catch (java.io.IOException iAYsZxpc) {
			iAYsZxpc.printStackTrace();
		} finally {
			try {
				SzHys95B.close();
			} catch (Exception Y6GN8kVu) {
			}
			try {
				fDxvFAqC.close();
			} catch (Exception INdclgSe) {
			}
		}
		return FvpaP0kd;
	}

}