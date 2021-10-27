class n16540473 {
	public static void copyFile(File Bb6tcBGH, File MfHA2pks) throws IOException {
		if (!MfHA2pks.exists()) {
			MfHA2pks.createNewFile();
		}
		FileChannel wh7bJIy1 = null;
		FileChannel DjxGJBKe = null;
		try {
			wh7bJIy1 = new FileInputStream(Bb6tcBGH).getChannel();
			DjxGJBKe = new FileOutputStream(MfHA2pks).getChannel();
			DjxGJBKe.transferFrom(wh7bJIy1, 0, wh7bJIy1.size());
		} finally {
			if (wh7bJIy1 != null) {
				wh7bJIy1.close();
			}
			if (DjxGJBKe != null) {
				DjxGJBKe.close();
			}
		}
	}

}