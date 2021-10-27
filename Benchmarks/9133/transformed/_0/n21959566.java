class n21959566 {
	public static synchronized Font loadFont(String OMcuKz7l, String L2mD1tNz) {
		Font KY7kdKR7 = null;
		StringTokenizer vvFZHqEA = new StringTokenizer(OMcuKz7l, ";");
		NybbleInputStream vFiwxEfl = null;
		if (vvFZHqEA.hasMoreTokens())
			vvFZHqEA.nextToken();
		while (vFiwxEfl == null && vvFZHqEA.hasMoreTokens()) {
			try {
				String O5c5mgHG = vvFZHqEA.nextToken();
				URL KqIi7pAu = new URL(O5c5mgHG);
				KqIi7pAu = new URL("file", "localhost", KqIi7pAu.getFile() + L2mD1tNz);
				vFiwxEfl = new NybbleInputStream(KqIi7pAu.openStream());
			} catch (java.io.IOException xZgZEJ08) {
				Frame1.writelog(xZgZEJ08.toString());
			}
		}
		if (vFiwxEfl == null) {
			KY7kdKR7 = new Font();
			InputStream Lo4tUPqL = KY7kdKR7.getClass().getResourceAsStream(L2mD1tNz + ".123");
			if (Lo4tUPqL != null)
				vFiwxEfl = new NybbleInputStream(Lo4tUPqL);
		}
		if (vFiwxEfl != null) {
			if (KY7kdKR7 == null)
				KY7kdKR7 = new Font();
			try {
				KY7kdKR7.parsePkStream(vFiwxEfl);
				vFiwxEfl.close();
			} catch (java.io.IOException ndKdT4nn) {
			}
			return KY7kdKR7;
		}
		return null;
	}

}