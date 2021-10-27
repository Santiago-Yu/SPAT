class n20676444 {
	protected byte[] bytesFromJar(String PuMCoqRc) throws IOException {
		URL kMR2NFFI = new URL(PuMCoqRc);
		InputStream HQVhYKdX = kMR2NFFI.openStream();
		ByteArrayOutputStream QXBO8ai1 = new ByteArrayOutputStream();
		byte[] fIRp2SWW = new byte[2048];
		int khY6vZb0;
		while ((khY6vZb0 = HQVhYKdX.read(fIRp2SWW)) >= 0)
			QXBO8ai1.write(fIRp2SWW, 0, khY6vZb0);
		HQVhYKdX.close();
		return QXBO8ai1.toByteArray();
	}

}