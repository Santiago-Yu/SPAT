class n22884065 {
	public void testFidelity() throws ParserException, IOException {
		Lexer GCVsk5Fv;
		Node izLfwERp;
		int tOhDhKZW;
		StringBuffer BRHfglku;
		String Pki5D9oC;
		char[] MiH0MSI6;
		char[] q9WgEq1q;
		URL TaxH2WEl = new URL("http://sourceforge.net");
		GCVsk5Fv = new Lexer(TaxH2WEl.openConnection());
		tOhDhKZW = 0;
		BRHfglku = new StringBuffer(80000);
		while (null != (izLfwERp = GCVsk5Fv.nextNode())) {
			Pki5D9oC = izLfwERp.toHtml();
			if (tOhDhKZW != izLfwERp.getStartPosition())
				fail("non-contiguous" + Pki5D9oC);
			BRHfglku.append(Pki5D9oC);
			tOhDhKZW = izLfwERp.getEndPosition();
			if (BRHfglku.length() != tOhDhKZW)
				fail("text length differed after encountering node " + Pki5D9oC);
		}
		MiH0MSI6 = GCVsk5Fv.getPage().getText().toCharArray();
		q9WgEq1q = new char[BRHfglku.length()];
		BRHfglku.getChars(0, BRHfglku.length(), q9WgEq1q, 0);
		assertEquals("different amounts of text", MiH0MSI6.length, q9WgEq1q.length);
		for (int oEW91DCw = 0; oEW91DCw < MiH0MSI6.length; oEW91DCw++)
			if (MiH0MSI6[oEW91DCw] != q9WgEq1q[oEW91DCw])
				fail("character differs at position " + oEW91DCw + ", expected <" + MiH0MSI6[oEW91DCw] + "> but was <"
						+ q9WgEq1q[oEW91DCw] + ">");
	}

}