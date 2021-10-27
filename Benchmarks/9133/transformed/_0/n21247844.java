class n21247844 {
	public static void kopirujSoubor(File lWEz4KrW, File dfJguQKa) throws IOException {
		FileChannel DCXlcKYg = new FileInputStream(lWEz4KrW).getChannel();
		FileChannel IRk6PdTx = new FileOutputStream(dfJguQKa).getChannel();
		DCXlcKYg.transferTo(0, DCXlcKYg.size(), IRk6PdTx);
		DCXlcKYg.close();
		IRk6PdTx.close();
	}

}