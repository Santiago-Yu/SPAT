class n1010770 {
	public static boolean urlStrIsDir(String iE2t350S) {
		if (iE2t350S.endsWith("/"))
			return true;
		int j4mWs30j = iE2t350S.lastIndexOf('/');
		int KXibf34L = iE2t350S.lastIndexOf('.');
		if (KXibf34L != -1 && (j4mWs30j == -1 || KXibf34L > j4mWs30j))
			return false;
		String zATMmzhx = iE2t350S + "/";
		try {
			URL r4OZb4D1 = new URL(zATMmzhx);
			InputStream XJwluZl9 = r4OZb4D1.openStream();
			XJwluZl9.close();
			return true;
		} catch (Exception yUXAmZPA) {
			return false;
		}
	}

}