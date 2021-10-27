class n15571541 {
	public static boolean encodeFileToFile(String XXiTjdLp, String U2n5p4jo) {
		boolean YtyxSZtZ = false;
		java.io.InputStream YZayxVfk = null;
		java.io.OutputStream L2ltsTDa = null;
		try {
			YZayxVfk = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(XXiTjdLp)),
					Base64.ENCODE);
			L2ltsTDa = new java.io.BufferedOutputStream(new java.io.FileOutputStream(U2n5p4jo));
			byte[] q0TPiZ5v = new byte[65536];
			int MkOq9tg8 = -1;
			while ((MkOq9tg8 = YZayxVfk.read(q0TPiZ5v)) >= 0) {
				L2ltsTDa.write(q0TPiZ5v, 0, MkOq9tg8);
			}
			YtyxSZtZ = true;
		} catch (java.io.IOException eBe6hRMU) {
			eBe6hRMU.printStackTrace();
		} finally {
			try {
				YZayxVfk.close();
			} catch (Exception S34V4EDU) {
			}
			try {
				L2ltsTDa.close();
			} catch (Exception LPfhIv91) {
			}
		}
		return YtyxSZtZ;
	}

}