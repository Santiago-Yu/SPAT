class n2575374 {
	public static void copy(File itv7E1h0, File eCd63NPN) throws Exception {
		FileChannel braAJeUq = new FileInputStream(itv7E1h0).getChannel();
		FileChannel fuDth6aU = new FileOutputStream(eCd63NPN).getChannel();
		braAJeUq.transferTo(0, braAJeUq.size(), fuDth6aU);
		braAJeUq.close();
		fuDth6aU.close();
	}

}