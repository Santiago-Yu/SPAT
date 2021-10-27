class n21488869 {
	public static boolean decodeFileToFile(String UPDupruw, String Oj9qGXHs) {
		boolean ymGb1ehS = false;
		java.io.InputStream KrGe4ypN = null;
		java.io.OutputStream aaA8H4PI = null;
		try {
			KrGe4ypN = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(UPDupruw)),
					Base64.DECODE);
			aaA8H4PI = new java.io.BufferedOutputStream(new java.io.FileOutputStream(Oj9qGXHs));
			byte[] owd8wX5v = new byte[65536];
			int fLJwk5T6 = -1;
			while ((fLJwk5T6 = KrGe4ypN.read(owd8wX5v)) >= 0) {
				aaA8H4PI.write(owd8wX5v, 0, fLJwk5T6);
			}
			ymGb1ehS = true;
		} catch (java.io.IOException ZGtBJJIe) {
			ZGtBJJIe.printStackTrace();
		} finally {
			try {
				KrGe4ypN.close();
			} catch (Exception kuCR85KQ) {
			}
			try {
				aaA8H4PI.close();
			} catch (Exception kQQDLkxn) {
			}
		}
		return ymGb1ehS;
	}

}