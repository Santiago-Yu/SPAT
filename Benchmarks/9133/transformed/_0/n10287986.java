class n10287986 {
	public static boolean encodeFileToFile(String uXokr6oy, String XATHHSFz) {
		boolean sb5RpRVA = false;
		java.io.InputStream Uigiy7sd = null;
		java.io.OutputStream E2dvS8Xa = null;
		try {
			Uigiy7sd = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(uXokr6oy)),
					Base64.ENCODE);
			E2dvS8Xa = new java.io.BufferedOutputStream(new java.io.FileOutputStream(XATHHSFz));
			byte[] ucENHGTY = new byte[65536];
			int aWboYv3J = -1;
			while ((aWboYv3J = Uigiy7sd.read(ucENHGTY)) >= 0) {
				E2dvS8Xa.write(ucENHGTY, 0, aWboYv3J);
			}
			sb5RpRVA = true;
		} catch (java.io.IOException cVw7rNZB) {
			cVw7rNZB.printStackTrace();
		} finally {
			try {
				Uigiy7sd.close();
			} catch (Exception BC9r9b4Q) {
			}
			try {
				E2dvS8Xa.close();
			} catch (Exception hrpP3VFl) {
			}
		}
		return sb5RpRVA;
	}

}