class n1629748 {
	public static void main(String[] args) throws Exception {
		StreamBlockReader reader = new StreamBlockReader(new FileInputStream("D:\\test.txt"));
		DES des = new DES();
		SingleKey key = new SingleKey(new Block(64), "");
		StreamBlockWriter writer = new StreamBlockWriter(new FileOutputStream("D:\\test1.txt"));
		Mode mode = new ECBDESMode(des);
		key = new SingleKey(new Block("1111111100000000111111110000000011111111000000001111111100000000"), "");
		des.encrypt(reader, writer, key, mode);
	}

}