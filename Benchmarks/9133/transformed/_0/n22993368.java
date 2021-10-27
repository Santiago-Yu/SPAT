class n22993368 {
	public static boolean decodeFileToFile(String gIz9AhTV, String jTngdPkI) {
		boolean NHO6jNTz = false;
		java.io.InputStream z7Sa2n2d = null;
		java.io.OutputStream xs5nsUYh = null;
		try {
			z7Sa2n2d = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(gIz9AhTV)),
					Base64.DECODE);
			xs5nsUYh = new java.io.BufferedOutputStream(new java.io.FileOutputStream(jTngdPkI));
			byte[] O0m7Xnif = new byte[65536];
			int CnLP0RmR = -1;
			while ((CnLP0RmR = z7Sa2n2d.read(O0m7Xnif)) >= 0) {
				xs5nsUYh.write(O0m7Xnif, 0, CnLP0RmR);
			}
			NHO6jNTz = true;
		} catch (java.io.IOException eP6In8UW) {
			eP6In8UW.printStackTrace();
		} finally {
			try {
				z7Sa2n2d.close();
			} catch (Exception ih8mXoLF) {
			}
			try {
				xs5nsUYh.close();
			} catch (Exception cjepQjiF) {
			}
		}
		return NHO6jNTz;
	}

}