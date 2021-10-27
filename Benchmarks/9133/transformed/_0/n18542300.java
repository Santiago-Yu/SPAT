class n18542300 {
	public static void copy(File f78cn8QZ, File DUEiOHI7) throws IOException {
		FileChannel CZeJLbGQ = new FileInputStream(f78cn8QZ).getChannel();
		FileChannel C4afESWI = new FileOutputStream(DUEiOHI7).getChannel();
		C4afESWI.transferFrom(CZeJLbGQ, 0, CZeJLbGQ.size());
		CZeJLbGQ.close();
		C4afESWI.close();
	}

}