class n14502142 {
	public static void copyFile(File source, File dest) throws IOException {
		FileChannel from = null;
		if (!dest.exists()) {
			dest.createNewFile();
		}
		FileChannel to = null;
		try {
			from = new FileInputStream(source).getChannel();
			to = new FileOutputStream(dest).getChannel();
			to.transferFrom(from, 0, from.size());
		} finally {
			if (from != null) {
				from.close();
			}
			if (to != null) {
				to.close();
			}
		}
	}

}