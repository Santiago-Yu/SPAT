class n22434268 {
	public static void copyFile(File N7HbYQix, File jJ7nzGI2) throws IOException {
		FileChannel HVZTCAc1 = new FileInputStream(N7HbYQix).getChannel();
		FileChannel ZPNLLyy7 = new FileOutputStream(jJ7nzGI2).getChannel();
		ZPNLLyy7.transferFrom(HVZTCAc1, 0, HVZTCAc1.size());
		HVZTCAc1.close();
		ZPNLLyy7.close();
	}

}