class n2396188 {
	public static Vector getMetaKeywordsFromURL(String hsVwAZPd) throws Exception {
		URL v6NEYRiz = new URL(hsVwAZPd);
		URLConnection uEbdSJgR = v6NEYRiz.openConnection();
		InputStreamReader Eny5x99F = new InputStreamReader(uEbdSJgR.getInputStream());
		BufferedReader arCtfojH = new BufferedReader(Eny5x99F);
		String vXeFF1SO = null;
		String LhEg11vK = null;
		int XLuHJ36q = -1;
		String nXQKreWz = null;
		int ZSKPQPQ5 = -1;
		String[] tPvWLwXF = null;
		while ((vXeFF1SO = arCtfojH.readLine()) != null) {
			LhEg11vK = vXeFF1SO.toLowerCase();
			ZSKPQPQ5 = LhEg11vK.indexOf("<meta name=\"keywords\" content=\"");
			if (ZSKPQPQ5 != -1) {
				ZSKPQPQ5 = "<meta name=\"keywords\" content=\"".length();
				nXQKreWz = vXeFF1SO.substring(ZSKPQPQ5, vXeFF1SO.indexOf("\">", ZSKPQPQ5));
				nXQKreWz = nXQKreWz.replace(',', ' ');
				tPvWLwXF = Parser.extractWordsFromSpacedList(nXQKreWz);
			}
			XLuHJ36q = LhEg11vK.indexOf("<body");
			if (XLuHJ36q != -1)
				break;
		}
		Vector sNYMwtpF = new Vector(tPvWLwXF.length);
		for (int rU7uU4Zz = 0; rU7uU4Zz < tPvWLwXF.length; rU7uU4Zz++)
			sNYMwtpF.add(tPvWLwXF[rU7uU4Zz]);
		return sNYMwtpF;
	}

}