class n12678589 {
	public static boolean decodeFileToFile(String iZV0DdlJ, String Ph2AE5BX) {
		boolean NfUE4Zks = false;
		java.io.InputStream XIkgDBBe = null;
		java.io.OutputStream r8EawutC = null;
		try {
			XIkgDBBe = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(iZV0DdlJ)),
					Base64.DECODE);
			r8EawutC = new java.io.BufferedOutputStream(new java.io.FileOutputStream(Ph2AE5BX));
			byte[] Vix8hq3P = new byte[65536];
			int n5FmHpL5 = -1;
			while ((n5FmHpL5 = XIkgDBBe.read(Vix8hq3P)) >= 0) {
				r8EawutC.write(Vix8hq3P, 0, n5FmHpL5);
			}
			NfUE4Zks = true;
		} catch (java.io.IOException b32diM2w) {
			b32diM2w.printStackTrace();
		} finally {
			try {
				XIkgDBBe.close();
			} catch (Exception A4vde4j3) {
			}
			try {
				r8EawutC.close();
			} catch (Exception vWoUvvPc) {
			}
		}
		return NfUE4Zks;
	}

}