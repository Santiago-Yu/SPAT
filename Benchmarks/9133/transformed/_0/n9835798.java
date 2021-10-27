class n9835798 {
	public static void saveFile(final URL cdG4G3Jw, final File gMmNhtSN) throws IOException {
		final InputStream rnymbs0g = cdG4G3Jw.openStream();
		final FileOutputStream xnaC2vie = new FileOutputStream(gMmNhtSN);
		byte[] dZiD8JU8 = new byte[8 * 1024];
		int TcdRfnAw;
		while ((TcdRfnAw = rnymbs0g.read(dZiD8JU8)) != -1) {
			xnaC2vie.write(dZiD8JU8, 0, TcdRfnAw);
		}
		rnymbs0g.close();
		xnaC2vie.close();
	}

}