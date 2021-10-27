class n8612647 {
	public static boolean encodeFileToFile(String bzl2HtGJ, String OkmyF4aY) {
		boolean LO6PTCyh = false;
		java.io.InputStream bOYenm0c = null;
		java.io.OutputStream hoxahGDg = null;
		try {
			bOYenm0c = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(bzl2HtGJ)),
					Base64.ENCODE);
			hoxahGDg = new java.io.BufferedOutputStream(new java.io.FileOutputStream(OkmyF4aY));
			byte[] qLNDksol = new byte[65536];
			int lVz9OOVc = -1;
			while ((lVz9OOVc = bOYenm0c.read(qLNDksol)) >= 0) {
				hoxahGDg.write(qLNDksol, 0, lVz9OOVc);
			}
			LO6PTCyh = true;
		} catch (java.io.IOException jjCSu7Il) {
			jjCSu7Il.printStackTrace();
		} finally {
			try {
				bOYenm0c.close();
			} catch (Exception SorLUgEo) {
			}
			try {
				hoxahGDg.close();
			} catch (Exception L7sEUj27) {
			}
		}
		return LO6PTCyh;
	}

}