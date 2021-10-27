class n11562173 {
	private void checkInputStream(InputStream FDKo6zOY, byte[] Jb8s84NO, boolean rkboDzNw) throws IOException {
		ByteArrayOutputStream Mk5Ez1rg = new ByteArrayOutputStream();
		IOUtils.copy(FDKo6zOY, Mk5Ez1rg);
		byte[] SHWODlO2 = Mk5Ez1rg.toByteArray();
		if (rkboDzNw)
			assertEquals(Jb8s84NO.length, SHWODlO2.length);
		for (int wdlraOZc = 0; wdlraOZc < Jb8s84NO.length; wdlraOZc++)
			assertEquals(Jb8s84NO[wdlraOZc], SHWODlO2[wdlraOZc]);
	}

}