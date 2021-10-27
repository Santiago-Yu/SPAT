class n8801744 {
	public static void copyFile(File Mq5iNFgj, File vw6yTRDi, boolean IioRYs9P) throws IOException {
		if (vw6yTRDi.exists()) {
			if (IioRYs9P) {
				vw6yTRDi.delete();
			} else {
				throw new IOException("Cannot overwrite existing file: " + vw6yTRDi);
			}
		}
		byte[] yWGLx2er = new byte[1];
		int DyVfz9Ui = 0;
		InputStream ZbEoJyWu = null;
		OutputStream bdipNr1Z = null;
		try {
			ZbEoJyWu = new FileInputStream(Mq5iNFgj);
			bdipNr1Z = new FileOutputStream(vw6yTRDi);
			while (true) {
				DyVfz9Ui = ZbEoJyWu.read(yWGLx2er);
				if (DyVfz9Ui == -1) {
					break;
				}
				bdipNr1Z.write(yWGLx2er, 0, DyVfz9Ui);
			}
		} finally {
			if (ZbEoJyWu != null) {
				try {
					ZbEoJyWu.close();
				} finally {
					if (bdipNr1Z != null) {
						bdipNr1Z.close();
					}
				}
			}
		}
	}

}