class n14132965 {
	public static void copia(File ycvAMTqv, File jmOXxZoh) throws IOException {
		FileInputStream rCoXF2KS = new FileInputStream(ycvAMTqv);
		FileOutputStream riWS1JKw = new FileOutputStream(jmOXxZoh);
		FileChannel fE1Wz3Bg = rCoXF2KS.getChannel();
		FileChannel nHqFa4pI = riWS1JKw.getChannel();
		fE1Wz3Bg.transferTo(0, fE1Wz3Bg.size(), nHqFa4pI);
		rCoXF2KS.close();
		riWS1JKw.close();
	}

}