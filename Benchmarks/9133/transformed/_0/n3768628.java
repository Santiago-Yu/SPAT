class n3768628 {
	public static boolean encodeFileToFile(String TTINExxu, String IMxODSHL) {
		boolean w2MyZMDF = false;
		java.io.InputStream DeUw6kfT = null;
		java.io.OutputStream mrlJeDf8 = null;
		try {
			DeUw6kfT = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(TTINExxu)),
					Base64.ENCODE);
			mrlJeDf8 = new java.io.BufferedOutputStream(new java.io.FileOutputStream(IMxODSHL));
			byte[] iE8Z7c7B = new byte[65536];
			int aRVSYAMs = -1;
			while ((aRVSYAMs = DeUw6kfT.read(iE8Z7c7B)) >= 0) {
				mrlJeDf8.write(iE8Z7c7B, 0, aRVSYAMs);
			}
			w2MyZMDF = true;
		} catch (java.io.IOException kxIJwWeK) {
			kxIJwWeK.printStackTrace();
		} finally {
			try {
				DeUw6kfT.close();
			} catch (Exception hn0gogfo) {
			}
			try {
				mrlJeDf8.close();
			} catch (Exception DLUn1qmX) {
			}
		}
		return w2MyZMDF;
	}

}