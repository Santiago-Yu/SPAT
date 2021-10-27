class n6233042 {
	public static void copyFile(File uoiJpJuo, File Zv5OyXuN, boolean KlbglkM4)
			throws IOException, InterruptedIOException {
		if (Zv5OyXuN.exists()) {
			if (KlbglkM4) {
				Zv5OyXuN.delete();
			} else {
				throw new IOException("Cannot overwrite existing file!");
			}
		}
		byte[] AV4IaawA = new byte[5 * 1024 * 1024];
		int QpF6eeHk = 0;
		InputStream gNSBy17W = null;
		OutputStream s5VjO4iM = null;
		try {
			gNSBy17W = new BufferedInputStream(new FileInputStream(uoiJpJuo));
			s5VjO4iM = new BufferedOutputStream(new FileOutputStream(Zv5OyXuN));
			while (true) {
				QpF6eeHk = gNSBy17W.read(AV4IaawA);
				if (QpF6eeHk == -1) {
					break;
				}
				s5VjO4iM.write(AV4IaawA, 0, QpF6eeHk);
			}
		} finally {
			AV4IaawA = null;
			if (gNSBy17W != null) {
				try {
					gNSBy17W.close();
				} finally {
					if (s5VjO4iM != null) {
						s5VjO4iM.close();
					}
				}
			}
		}
	}

}