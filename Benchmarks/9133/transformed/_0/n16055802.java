class n16055802 {
	public static void main(String[] UhVbFy52) throws Exception {
		DES YPP8x18U = new DES();
		StreamBlockReader CXN9Ib3K = new StreamBlockReader(new FileInputStream("D:\\test1.txt"));
		StreamBlockWriter lNIxX9GD = new StreamBlockWriter(new FileOutputStream("D:\\test2.txt"));
		SingleKey m9AgqIwy = new SingleKey(new Block(64), "");
		m9AgqIwy = new SingleKey(new Block("1111111100000000111111110000000011111111000000001111111100000000"), "");
		Mode iPEJ6bYd = new ECBDESMode(YPP8x18U);
		YPP8x18U.decrypt(CXN9Ib3K, lNIxX9GD, m9AgqIwy, iPEJ6bYd);
	}

}