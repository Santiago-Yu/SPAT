class n12172484 {
	public static boolean encodeFileToFile(String WGyyMzR7, String RmdHM2w1) {
		boolean RNqMTt1n = false;
		java.io.InputStream hg1GTQfg = null;
		java.io.OutputStream zY2O2GFk = null;
		try {
			hg1GTQfg = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(WGyyMzR7)),
					Base64.ENCODE);
			zY2O2GFk = new java.io.BufferedOutputStream(new java.io.FileOutputStream(RmdHM2w1));
			byte[] WphQ9irK = new byte[65536];
			int mJJHgSyl = -1;
			while ((mJJHgSyl = hg1GTQfg.read(WphQ9irK)) >= 0) {
				zY2O2GFk.write(WphQ9irK, 0, mJJHgSyl);
			}
			RNqMTt1n = true;
		} catch (java.io.IOException IaDhRVHi) {
			IaDhRVHi.printStackTrace();
		} finally {
			try {
				hg1GTQfg.close();
			} catch (Exception yMKb9i3Y) {
			}
			try {
				zY2O2GFk.close();
			} catch (Exception N9t9yvrv) {
			}
		}
		return RNqMTt1n;
	}

}