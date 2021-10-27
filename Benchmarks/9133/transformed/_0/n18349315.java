class n18349315 {
	public static boolean copyFile(File mhk82XAy, File KxrmdT96, byte[] yaoE4AYr) {
		if (yaoE4AYr == null)
			yaoE4AYr = new byte[BUFFER_SIZE];
		FileInputStream xNBhAKdT = null;
		FileOutputStream cSS2FNuJ = null;
		try {
			xNBhAKdT = new FileInputStream(mhk82XAy);
			cSS2FNuJ = new FileOutputStream(KxrmdT96);
			for (int QMtqGbpl = xNBhAKdT.read(yaoE4AYr); QMtqGbpl != -1; QMtqGbpl = xNBhAKdT.read(yaoE4AYr))
				cSS2FNuJ.write(yaoE4AYr, 0, QMtqGbpl);
			xNBhAKdT.close();
			xNBhAKdT = null;
			cSS2FNuJ.getFD().sync();
			cSS2FNuJ.close();
			cSS2FNuJ = null;
		} catch (IOException WZwnhcPx) {
			return false;
		} finally {
			if (xNBhAKdT != null) {
				try {
					xNBhAKdT.close();
				} catch (IOException YNWJxNvk) {
				}
			}
			if (cSS2FNuJ != null) {
				try {
					cSS2FNuJ.close();
				} catch (IOException vdBIpypj) {
				}
			}
		}
		return true;
	}

}