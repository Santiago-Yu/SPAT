class n2396194 {
	public static Vector getKeywordsFromURLFast(String JIhJruu7) throws Exception {
		URL TiSXlpgF = new URL(JIhJruu7);
		URLConnection lx89SlY6 = TiSXlpgF.openConnection();
		InputStreamReader HAGL8Ft7 = new InputStreamReader(lx89SlY6.getInputStream());
		BufferedReader cMymz60Y = new BufferedReader(HAGL8Ft7);
		String CygFdWZa = null;
		String cIX5z6N2 = null;
		String EitEw4OI = null;
		Vector tU43Ypx6 = new Vector(1000);
		int LJMT2p4A = -1;
		int YDRzqVue = -1;
		boolean ZwDRurYl = false;
		int wjcdBNyw = -1;
		while ((CygFdWZa = cMymz60Y.readLine()) != null) {
			EitEw4OI = CygFdWZa.toLowerCase();
			YDRzqVue = EitEw4OI.indexOf("<title");
			if (YDRzqVue != -1) {
				wjcdBNyw = EitEw4OI.indexOf("</title>");
				cIX5z6N2 = CygFdWZa.substring((YDRzqVue + 7), (wjcdBNyw == -1 ? CygFdWZa.length() : wjcdBNyw));
			}
			LJMT2p4A = EitEw4OI.indexOf("<body");
			if (LJMT2p4A != -1) {
				ZwDRurYl = true;
				CygFdWZa = CygFdWZa.substring(LJMT2p4A + 5);
				break;
			}
		}
		boolean Ujr5LajN = false;
		wjcdBNyw = -1;
		String[] FblUxRz9;
		if (ZwDRurYl == false) {
			if (cIX5z6N2 != null) {
				tU43Ypx6 = new Vector();
				FblUxRz9 = extractWordsFromSpacedList(cIX5z6N2);
				for (int awXbWJzz = 0; awXbWJzz < FblUxRz9.length; awXbWJzz++)
					tU43Ypx6.addElement(FblUxRz9[awXbWJzz]);
				tU43Ypx6.addElement(cIX5z6N2);
				return tU43Ypx6;
			} else {
				return null;
			}
		}
		StringBuffer CZpzl9hV = new StringBuffer(35);
		do {
			EitEw4OI = CygFdWZa.toLowerCase();
			wjcdBNyw = EitEw4OI.indexOf("</body>");
			if (wjcdBNyw != -1) {
				extractOutsideTextFast(CygFdWZa.substring(0, wjcdBNyw), '<', '>', tU43Ypx6, Ujr5LajN, CZpzl9hV);
				break;
			}
			Ujr5LajN = extractOutsideTextFast(CygFdWZa, '<', '>', tU43Ypx6, Ujr5LajN, CZpzl9hV);
		} while ((CygFdWZa = cMymz60Y.readLine()) != null);
		if (cIX5z6N2 != null)
			tU43Ypx6.addElement(cIX5z6N2);
		return tU43Ypx6;
	}

}