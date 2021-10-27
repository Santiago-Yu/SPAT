class n6751999 {
	public static void main(String[] WlBODg8u) throws Exception {
		TripleDES SCBbfyJb = new TripleDES();
		StreamBlockReader K7yNcYhZ = new StreamBlockReader(new FileInputStream("D:\\test.txt"));
		StreamBlockWriter gqqii0hE = new StreamBlockWriter(new FileOutputStream("D:\\testTDESENC.txt"));
		SingleKey hWbDoyd0 = new SingleKey(new Block(128), "");
		hWbDoyd0 = new SingleKey(new Block(
				"01011101110000101001100111001011101000001110111101001001101101101101100000011101100100110000101100001110000001111101001101001101"),
				"");
		Mode o4AJxQgB = new ECBTripleDESMode(SCBbfyJb);
		SCBbfyJb.encrypt(K7yNcYhZ, gqqii0hE, hWbDoyd0, o4AJxQgB);
	}

}