class n6319887 {
	public static void copyFile(File SjL9fgsE, File WzhrLr7w) throws IOException {
		FileChannel SEoNkA30 = new FileInputStream(SjL9fgsE).getChannel();
		FileChannel vbB3XQst = new FileOutputStream(WzhrLr7w).getChannel();
		try {
			SEoNkA30.transferTo(0, SEoNkA30.size(), vbB3XQst);
		} catch (IOException Ve9neXuU) {
			throw Ve9neXuU;
		} finally {
			if (SEoNkA30 != null)
				SEoNkA30.close();
			if (vbB3XQst != null)
				vbB3XQst.close();
		}
	}

}