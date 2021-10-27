class n11825739 {
	public static void copyFile(String ISDMngmV, String coAgiHYw, boolean xyNnjfYB) throws IOException {
		FileChannel n5m4tWmr = new FileInputStream(ISDMngmV).getChannel();
		FileChannel cygBTpiO = new FileOutputStream(coAgiHYw, xyNnjfYB).getChannel();
		ByteBuffer NDBPzXdr = ByteBuffer.allocate(BSIZE);
		while (n5m4tWmr.read(NDBPzXdr) != -1) {
			NDBPzXdr.flip();
			cygBTpiO.write(NDBPzXdr);
			NDBPzXdr.clear();
		}
	}

}