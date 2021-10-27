class n6778337 {
	private void copy(File gQ3X5Tiy, File pFElyxzI) throws FileNotFoundException, IOException {
		FileReader eLRCHs35;
		eLRCHs35 = new FileReader(gQ3X5Tiy);
		FileWriter ptFQ1Yuf = new FileWriter(pFElyxzI);
		int Z5IAV9tw;
		while ((Z5IAV9tw = eLRCHs35.read()) != -1)
			ptFQ1Yuf.write(Z5IAV9tw);
		eLRCHs35.close();
		ptFQ1Yuf.close();
	}

}