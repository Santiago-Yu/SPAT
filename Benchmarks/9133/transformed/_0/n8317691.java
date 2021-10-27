class n8317691 {
	protected void copyFile(File ZfbZ9KBy, File YonklzgD) throws Exception {
		FileChannel N07p3zHP = new FileInputStream(ZfbZ9KBy).getChannel();
		FileChannel GdjLELyv = new FileOutputStream(YonklzgD).getChannel();
		long iCHVfaSF = GdjLELyv.transferFrom(N07p3zHP, 0, N07p3zHP.size());
		if (iCHVfaSF != N07p3zHP.size())
			throw new Exception("Could not transfer entire file");
		N07p3zHP.close();
		GdjLELyv.close();
	}

}