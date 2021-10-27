class n2721037 {
	public void SplitFile(File kFNYsC6Y, File QWRMO7iG, File WIkChY1P, long Sdb2c3If) throws IOException {
		FileInputStream Tn0qgOt5 = new FileInputStream(kFNYsC6Y);
		FileOutputStream ZzuAvZov = new FileOutputStream(QWRMO7iG);
		FileChannel HY13wrzb = Tn0qgOt5.getChannel();
		FileChannel Lre9hfZX = ZzuAvZov.getChannel();
		Lre9hfZX.transferFrom(HY13wrzb, 0, Sdb2c3If);
		Lre9hfZX.close();
		ZzuAvZov = new FileOutputStream(WIkChY1P);
		Lre9hfZX = ZzuAvZov.getChannel();
		Lre9hfZX.transferFrom(HY13wrzb, 0, HY13wrzb.size() - Sdb2c3If);
		Lre9hfZX.close();
		HY13wrzb.close();
	}

}