class n14168494 {
	public static void copyFile(File cwq0vzjX, File DsYW0Hsv) throws IOException {
		FileChannel L36OWIS6 = new FileInputStream(DsYW0Hsv).getChannel();
		FileChannel lZeHwuev = new FileOutputStream(cwq0vzjX).getChannel();
		lZeHwuev.transferFrom(L36OWIS6, 0, L36OWIS6.size());
		L36OWIS6.close();
		lZeHwuev.close();
	}

}