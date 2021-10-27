class n8778961 {
	public static boolean encodeFileToFile(String jZsAgX2i, String UjpxPsw2) {
		boolean tUhgsnos = false;
		java.io.InputStream mO0JUmhn = null;
		java.io.OutputStream z0o3zXyd = null;
		try {
			mO0JUmhn = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(jZsAgX2i)),
					Base64.ENCODE);
			z0o3zXyd = new java.io.BufferedOutputStream(new java.io.FileOutputStream(UjpxPsw2));
			byte[] TofnJ6QS = new byte[65536];
			int KEfB4sFT = -1;
			while ((KEfB4sFT = mO0JUmhn.read(TofnJ6QS)) >= 0) {
				z0o3zXyd.write(TofnJ6QS, 0, KEfB4sFT);
			}
			tUhgsnos = true;
		} catch (java.io.IOException qLhlr2US) {
			qLhlr2US.printStackTrace();
		} finally {
			try {
				mO0JUmhn.close();
			} catch (Exception RXlZhn0v) {
			}
			try {
				z0o3zXyd.close();
			} catch (Exception EvRueDZD) {
			}
		}
		return tUhgsnos;
	}

}