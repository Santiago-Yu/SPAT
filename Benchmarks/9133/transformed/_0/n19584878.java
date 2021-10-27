class n19584878 {
	public static boolean decodeFileToFile(String wRW9k7JQ, String ygOzZwqm) {
		boolean K9SNZj6B = false;
		java.io.InputStream fGbsrLGx = null;
		java.io.OutputStream OoXM7Ldp = null;
		try {
			fGbsrLGx = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(wRW9k7JQ)),
					Base64.DECODE);
			OoXM7Ldp = new java.io.BufferedOutputStream(new java.io.FileOutputStream(ygOzZwqm));
			byte[] qRQWUoTM = new byte[65536];
			int CmxWtU7D = -1;
			while ((CmxWtU7D = fGbsrLGx.read(qRQWUoTM)) >= 0) {
				OoXM7Ldp.write(qRQWUoTM, 0, CmxWtU7D);
			}
			K9SNZj6B = true;
		} catch (java.io.IOException ilj8B8DL) {
			ilj8B8DL.printStackTrace();
		} finally {
			try {
				fGbsrLGx.close();
			} catch (Exception FulKUE6T) {
			}
			try {
				OoXM7Ldp.close();
			} catch (Exception v87EHtXj) {
			}
		}
		return K9SNZj6B;
	}

}