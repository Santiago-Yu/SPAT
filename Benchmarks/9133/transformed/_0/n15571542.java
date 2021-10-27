class n15571542 {
	public static boolean decodeFileToFile(String pVjnZSR9, String sOc8TyO0) {
		boolean RPaBUHPH = false;
		java.io.InputStream NSuvDvlb = null;
		java.io.OutputStream gKb3Vxfu = null;
		try {
			NSuvDvlb = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(pVjnZSR9)),
					Base64.DECODE);
			gKb3Vxfu = new java.io.BufferedOutputStream(new java.io.FileOutputStream(sOc8TyO0));
			byte[] IlYkH5LJ = new byte[65536];
			int MVBeTqpJ = -1;
			while ((MVBeTqpJ = NSuvDvlb.read(IlYkH5LJ)) >= 0) {
				gKb3Vxfu.write(IlYkH5LJ, 0, MVBeTqpJ);
			}
			RPaBUHPH = true;
		} catch (java.io.IOException IqQciDut) {
			IqQciDut.printStackTrace();
		} finally {
			try {
				NSuvDvlb.close();
			} catch (Exception w6YHmNmN) {
			}
			try {
				gKb3Vxfu.close();
			} catch (Exception mfih5BrV) {
			}
		}
		return RPaBUHPH;
	}

}