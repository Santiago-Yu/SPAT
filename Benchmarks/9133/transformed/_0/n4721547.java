class n4721547 {
	public static void main(String[] mdjyCYIT) throws Exception {
		String Y8i4bsOE = "C:\\copy.sql";
		String OR152xQ3 = "C:\\copy.txt";
		FileInputStream igvw2Wc2 = new FileInputStream(Y8i4bsOE);
		FileOutputStream DbOoocPi = new FileOutputStream(OR152xQ3);
		FileChannel YPDaSRQW = igvw2Wc2.getChannel();
		FileChannel RqM68TWp = DbOoocPi.getChannel();
		ByteBuffer zkL0trhF = ByteBuffer.allocate(1024);
		while (true) {
			zkL0trhF.clear();
			int b8BvOT8U = YPDaSRQW.read(zkL0trhF);
			if (b8BvOT8U == -1) {
				break;
			}
			zkL0trhF.flip();
			RqM68TWp.write(zkL0trhF);
		}
	}

}