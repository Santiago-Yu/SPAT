class n831649 {
	public static boolean encodeFileToFile(String gBi4VqmY, String qgRsLBat) {
		boolean ZmBEDPCL = false;
		java.io.InputStream KOUF4hm5 = null;
		java.io.OutputStream xd5yCpq0 = null;
		try {
			KOUF4hm5 = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(gBi4VqmY)),
					Base64.ENCODE);
			xd5yCpq0 = new java.io.BufferedOutputStream(new java.io.FileOutputStream(qgRsLBat));
			byte[] Uu2VP2TJ = new byte[65536];
			int cWrhIpDs = -1;
			while ((cWrhIpDs = KOUF4hm5.read(Uu2VP2TJ)) >= 0) {
				xd5yCpq0.write(Uu2VP2TJ, 0, cWrhIpDs);
			}
			ZmBEDPCL = true;
		} catch (java.io.IOException eWYLV7Hb) {
			eWYLV7Hb.printStackTrace();
		} finally {
			try {
				KOUF4hm5.close();
			} catch (Exception YWOweHvo) {
			}
			try {
				xd5yCpq0.close();
			} catch (Exception YQEI95Wz) {
			}
		}
		return ZmBEDPCL;
	}

}