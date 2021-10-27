class n19849797 {
	public static void copyFile(File C7fBj3zh, File QW6rfNNu) throws IOException {
		if (!QW6rfNNu.exists()) {
			QW6rfNNu.createNewFile();
		}
		FileChannel utRi9O22 = null;
		FileChannel lJLBIyOb = null;
		try {
			utRi9O22 = new FileInputStream(C7fBj3zh).getChannel();
			lJLBIyOb = new FileOutputStream(QW6rfNNu).getChannel();
			lJLBIyOb.transferFrom(utRi9O22, 0, utRi9O22.size());
		} finally {
			if (utRi9O22 != null) {
				utRi9O22.close();
			}
			if (lJLBIyOb != null) {
				lJLBIyOb.close();
			}
		}
	}

}