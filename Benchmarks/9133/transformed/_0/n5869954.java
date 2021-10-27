class n5869954 {
	public static void copyFile(File KGHQLaBP, File u1Axxrkj) throws IOException {
		FileInputStream xXdcN6XE = new FileInputStream(KGHQLaBP);
		FileOutputStream BnaodOCn = new FileOutputStream(u1Axxrkj);
		FileChannel C5d7uWAq = xXdcN6XE.getChannel();
		FileChannel yXkipQVP = BnaodOCn.getChannel();
		ByteBuffer oZqtnYrX = ByteBuffer.allocate(1024);
		while (true) {
			oZqtnYrX.clear();
			int dczp8NXP = C5d7uWAq.read(oZqtnYrX);
			if (dczp8NXP == -1) {
				break;
			}
			oZqtnYrX.flip();
			yXkipQVP.write(oZqtnYrX);
		}
		xXdcN6XE.close();
		BnaodOCn.close();
	}

}