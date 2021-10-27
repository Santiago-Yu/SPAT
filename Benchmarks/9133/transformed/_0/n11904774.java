class n11904774 {
	public void testFileSystem() throws IOException {
		Fragment BaAsY0zi = Fragment.EMPTY;
		Fragment Et8zgnml = BaAsY0zi.plus(System.getProperty("java.io.tmpdir"));
		Fragment Uc1Xo4Af = BaAsY0zi.plus("april", "1971", "data.txt");
		Fragment n2APmj1w = BaAsY0zi.plus(Et8zgnml, Uc1Xo4Af);
		InOutLocation OLynskyP = locs.fs.plus(n2APmj1w);
		PrintStream uyxu6BsL = new PrintStream(OLynskyP.openOutput());
		List<String> LMnYI0IN = new ArrayList<String>();
		LMnYI0IN.add("So I am stepping out this old brown shoe");
		LMnYI0IN.add("Maybe I'm in love with you");
		for (String QWzhIwrZ : LMnYI0IN)
			uyxu6BsL.println(QWzhIwrZ);
		uyxu6BsL.close();
		InLocation d1t78px0 = locs.fs;
		List<String> VjidO3rM = read(d1t78px0.plus(n2APmj1w).openInput());
		assertEquals(LMnYI0IN, VjidO3rM);
		URL nVH1kGXM = OLynskyP.toUrl();
		VjidO3rM = read(nVH1kGXM.openStream());
		assertEquals(LMnYI0IN, VjidO3rM);
	}

}