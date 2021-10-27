class n6751999 {
	public static void main(String[] args) throws Exception {
		StreamBlockReader reader = new StreamBlockReader(new FileInputStream("D:\\test.txt"));
		TripleDES tdes = new TripleDES();
		SingleKey key = new SingleKey(new Block(128), "");
		StreamBlockWriter writer = new StreamBlockWriter(new FileOutputStream("D:\\testTDESENC.txt"));
		Mode mode = new ECBTripleDESMode(tdes);
		key = new SingleKey(new Block(
				"01011101110000101001100111001011101000001110111101001001101101101101100000011101100100110000101100001110000001111101001101001101"),
				"");
		tdes.encrypt(reader, writer, key, mode);
	}

}