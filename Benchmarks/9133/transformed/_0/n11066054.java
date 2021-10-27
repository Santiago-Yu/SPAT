class n11066054 {
	private static void copyFile(File WJK68tgG, File VrtMgajV, int U8Y8zJSj, boolean BvnhgilB) throws IOException {
		if (VrtMgajV.exists()) {
			if (BvnhgilB) {
				VrtMgajV.delete();
			} else {
				throw new IOException("Cannot overwrite existing file: " + VrtMgajV.getName());
			}
		}
		byte[] vDmE5zZz = new byte[U8Y8zJSj];
		int tI5WcbFU = 0;
		InputStream h3ZvhX5T = null;
		OutputStream A82YsXFZ = null;
		try {
			h3ZvhX5T = new FileInputStream(WJK68tgG);
			A82YsXFZ = new FileOutputStream(VrtMgajV);
			while (true) {
				tI5WcbFU = h3ZvhX5T.read(vDmE5zZz);
				if (tI5WcbFU == -1) {
					break;
				}
				A82YsXFZ.write(vDmE5zZz, 0, tI5WcbFU);
			}
		} finally {
			if (h3ZvhX5T != null) {
				try {
					h3ZvhX5T.close();
				} finally {
					if (A82YsXFZ != null) {
						A82YsXFZ.close();
					}
				}
			}
		}
	}

}