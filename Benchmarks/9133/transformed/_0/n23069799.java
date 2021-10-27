class n23069799 {
	public static void copyFile(File WEOqGCDm, File faBSreQe) throws IOException {
		if (!faBSreQe.exists()) {
			faBSreQe.createNewFile();
		}
		FileChannel jZMETKvO = null;
		FileChannel YIv9E0Ae = null;
		try {
			jZMETKvO = new FileInputStream(WEOqGCDm).getChannel();
			YIv9E0Ae = new FileOutputStream(faBSreQe).getChannel();
			YIv9E0Ae.transferFrom(jZMETKvO, 0, jZMETKvO.size());
		} finally {
			if (jZMETKvO != null) {
				jZMETKvO.close();
			}
			if (YIv9E0Ae != null) {
				YIv9E0Ae.close();
			}
		}
	}

}