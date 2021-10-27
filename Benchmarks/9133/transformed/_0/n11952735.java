class n11952735 {
	public static boolean copyFile(String ZNExurHr, String NPXI7s1d) {
		FileChannel pQKYf8lS = null;
		FileChannel x3DvsvZ9 = null;
		boolean skyX0ZRc = false;
		try {
			pQKYf8lS = new FileInputStream(ZNExurHr).getChannel();
			x3DvsvZ9 = new FileOutputStream(NPXI7s1d).getChannel();
			x3DvsvZ9.transferFrom(pQKYf8lS, 0, pQKYf8lS.size());
			skyX0ZRc = true;
		} catch (Throwable rBWbEOxy) {
			logger.log(Level.SEVERE, "Exception in copyFile", rBWbEOxy);
		} finally {
			try {
				if (pQKYf8lS != null)
					pQKYf8lS.close();
			} catch (Throwable f8MJmkcW) {
			}
			try {
				if (x3DvsvZ9 != null)
					x3DvsvZ9.close();
			} catch (Throwable bDjxQKM2) {
			}
		}
		return skyX0ZRc;
	}

}