class n19035955 {
	public static void main(String[] T9yU0K9P) throws Exception {
		TripleDES cpLm9iVa = new TripleDES();
		StreamBlockReader k6ULjihy = new StreamBlockReader(new FileInputStream("D:\\testTDESENC.txt"));
		StreamBlockWriter BbfX3nT7 = new StreamBlockWriter(new FileOutputStream("D:\\testTDESDEC.txt"));
		SingleKey quYAgOyo = new SingleKey(new Block(128), "");
		quYAgOyo = new SingleKey(new Block(
				"01011101110000101001100111001011101000001110111101001001101101101101100000011101100100110000101100001110000001111101001101001101"),
				"");
		Mode yymBAcp2 = new ECBTripleDESMode(cpLm9iVa);
		cpLm9iVa.decrypt(k6ULjihy, BbfX3nT7, quYAgOyo, yymBAcp2);
	}

}