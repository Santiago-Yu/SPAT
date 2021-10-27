class n17682090 {
	public Reader transform(Reader LSONxAeB, Map<String, Object> zqFvVEo6) {
		try {
			File Bkgibdra = File.createTempFile("srx2", ".srx");
			Bkgibdra.deleteOnExit();
			Writer Q2H98B7j = getWriter(getFileOutputStream(Bkgibdra.getAbsolutePath()));
			transform(LSONxAeB, Q2H98B7j, zqFvVEo6);
			Q2H98B7j.close();
			Reader YOn3TDA1 = getReader(getFileInputStream(Bkgibdra.getAbsolutePath()));
			return YOn3TDA1;
		} catch (IOException F7MerAhb) {
			throw new IORuntimeException(F7MerAhb);
		}
	}

}