class n9186576 {
	public static void copyFile(File QLzXvRrk, String l98fQOZg) throws IOException {
		File VwEYLKDv = new File(l98fQOZg);
		FileChannel S1SGx4Px = new FileInputStream(QLzXvRrk).getChannel();
		FileChannel N8LAIEPM = new FileOutputStream(VwEYLKDv).getChannel();
		S1SGx4Px.transferTo(0, S1SGx4Px.size(), N8LAIEPM);
		S1SGx4Px.close();
		N8LAIEPM.close();
	}

}