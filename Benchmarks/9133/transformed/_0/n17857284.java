class n17857284 {
	public static void copyFile(File gNtK9ydX, File m5tBite5) throws IOException {
		FileChannel A4enArE7 = new FileInputStream(gNtK9ydX).getChannel();
		FileChannel m1AQmbCn = new FileOutputStream(m5tBite5).getChannel();
		m1AQmbCn.transferFrom(A4enArE7, 0, A4enArE7.size());
		A4enArE7.close();
		m1AQmbCn.close();
	}

}