class n11548510 {
	public static boolean encodeFileToFile(String czRQA6l0, String ZzFyjgkn) {
		boolean JDlalGOI = false;
		java.io.InputStream JTAJvjJF = null;
		java.io.OutputStream g1mHqIWu = null;
		try {
			JTAJvjJF = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(czRQA6l0)),
					Base64.ENCODE);
			g1mHqIWu = new java.io.BufferedOutputStream(new java.io.FileOutputStream(ZzFyjgkn));
			byte[] AknScTK1 = new byte[65536];
			int lbnsiHFn = -1;
			while ((lbnsiHFn = JTAJvjJF.read(AknScTK1)) >= 0) {
				g1mHqIWu.write(AknScTK1, 0, lbnsiHFn);
			}
			JDlalGOI = true;
		} catch (java.io.IOException RvhvfhCE) {
			RvhvfhCE.printStackTrace();
		} finally {
			try {
				JTAJvjJF.close();
			} catch (Exception PDT6GmAq) {
			}
			try {
				g1mHqIWu.close();
			} catch (Exception ycg31OrT) {
			}
		}
		return JDlalGOI;
	}

}