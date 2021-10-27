class n1966262 {
	public static boolean encodeFileToFile(String B9QnBTZe, String e8L5rWzn) {
		boolean QK2R2uSo = false;
		java.io.InputStream i7RXPLuB = null;
		java.io.OutputStream sLqE7wbT = null;
		try {
			i7RXPLuB = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(B9QnBTZe)),
					Base64.ENCODE);
			sLqE7wbT = new java.io.BufferedOutputStream(new java.io.FileOutputStream(e8L5rWzn));
			byte[] kizHItqK = new byte[65536];
			int UI7PHLXC = -1;
			while ((UI7PHLXC = i7RXPLuB.read(kizHItqK)) >= 0) {
				sLqE7wbT.write(kizHItqK, 0, UI7PHLXC);
			}
			QK2R2uSo = true;
		} catch (java.io.IOException OawzgHLP) {
			OawzgHLP.printStackTrace();
		} finally {
			try {
				i7RXPLuB.close();
			} catch (Exception Uuk8u2AY) {
			}
			try {
				sLqE7wbT.close();
			} catch (Exception oDAZN3zj) {
			}
		}
		return QK2R2uSo;
	}

}