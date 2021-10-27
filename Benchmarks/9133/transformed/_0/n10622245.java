class n10622245 {
	private void downloadTo(URL SBcDhaBM, File YJycGaKv) throws IOException {
		URLConnection jyH0UwDx = SBcDhaBM.openConnection();
		BufferedInputStream EguxV86o = new BufferedInputStream(jyH0UwDx.getInputStream());
		BufferedOutputStream DueJgfT1 = new BufferedOutputStream(new FileOutputStream(YJycGaKv));
		final int CksCCQYY = 1024;
		byte[] JnstO1UQ = new byte[CksCCQYY];
		int UB2l1oE1;
		while ((UB2l1oE1 = EguxV86o.read(JnstO1UQ, 0, CksCCQYY)) > 0)
			DueJgfT1.write(JnstO1UQ, 0, UB2l1oE1);
		EguxV86o.close();
		DueJgfT1.close();
	}

}