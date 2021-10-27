class n7227024 {
	public static void copyFile(File ErTBTJJU, File ShFBvj3P, int RdPwFy5a, boolean qItqrGUw) throws IOException {
		if (ShFBvj3P.exists()) {
			if (qItqrGUw) {
				ShFBvj3P.delete();
			} else {
				throw new IOException(className + "Cannot overwrite existing file: " + ShFBvj3P.getAbsolutePath());
			}
		}
		byte[] u69Uv2FO = new byte[RdPwFy5a];
		int tGNbeo3E = 0;
		InputStream RkgW2Ogx = null;
		OutputStream DtYP0GHx = null;
		try {
			RkgW2Ogx = new FileInputStream(ErTBTJJU);
			DtYP0GHx = new FileOutputStream(ShFBvj3P);
			while (true) {
				tGNbeo3E = RkgW2Ogx.read(u69Uv2FO);
				if (tGNbeo3E == -1) {
					break;
				}
				DtYP0GHx.write(u69Uv2FO, 0, tGNbeo3E);
			}
		} finally {
			if (RkgW2Ogx != null) {
				try {
					RkgW2Ogx.close();
				} finally {
					if (DtYP0GHx != null) {
						DtYP0GHx.close();
					}
				}
			}
		}
	}

}