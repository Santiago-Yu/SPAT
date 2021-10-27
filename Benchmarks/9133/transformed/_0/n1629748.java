class n1629748 {
	public static void main(String[] DflSen4N) throws Exception {
		DES EXNDwoxj = new DES();
		StreamBlockReader DpiDnSvs = new StreamBlockReader(new FileInputStream("D:\\test.txt"));
		StreamBlockWriter O1kdEmBq = new StreamBlockWriter(new FileOutputStream("D:\\test1.txt"));
		SingleKey DBpauuiu = new SingleKey(new Block(64), "");
		DBpauuiu = new SingleKey(new Block("1111111100000000111111110000000011111111000000001111111100000000"), "");
		Mode R8358aFo = new ECBDESMode(EXNDwoxj);
		EXNDwoxj.encrypt(DpiDnSvs, O1kdEmBq, DBpauuiu, R8358aFo);
	}

}