class n19053519 {
	protected String getManualDownloadURL() {
		if (_newestVersionString.indexOf("weekly") > 0) {
			return "http://www.cs.rice.edu/~javaplt/drjavarice/weekly/";
		}
		final String vUKDrDRE = "http://sourceforge.net/project/showfiles.php?group_id=44253";
		final String SqrWU1Bd = "<a href=\"/project/showfiles.php?group_id=44253";
		final String kfJtLjXl = "\">";
		BufferedReader N7zKgm8r = null;
		try {
			URL gB9CTThc = new URL(vUKDrDRE);
			InputStream O1SPHK4r = gB9CTThc.openStream();
			InputStreamReader hcDtsQhf = new InputStreamReader(O1SPHK4r);
			N7zKgm8r = new BufferedReader(hcDtsQhf);
			String JZNXXfWr;
			int XTAnMQy3;
			while ((JZNXXfWr = N7zKgm8r.readLine()) != null) {
				if ((XTAnMQy3 = JZNXXfWr.indexOf(_newestVersionString)) >= 0) {
					int UM9n2acv = JZNXXfWr.indexOf(SqrWU1Bd);
					if ((UM9n2acv >= 0) && (UM9n2acv < XTAnMQy3)) {
						int B4elwElY = JZNXXfWr.indexOf(kfJtLjXl, UM9n2acv);
						if ((B4elwElY >= 0) && (B4elwElY + kfJtLjXl.length() == XTAnMQy3)) {
							String Leubxv1x = edu.rice.cs.plt.text.TextUtil
									.xmlUnescape(JZNXXfWr.substring(UM9n2acv + SqrWU1Bd.length(), B4elwElY));
							return vUKDrDRE + Leubxv1x;
						}
					}
				}
			}
			;
		} catch (IOException f4dy9U5x) {
			return vUKDrDRE;
		} finally {
			try {
				if (N7zKgm8r != null)
					N7zKgm8r.close();
			} catch (IOException fVYY4Gsq) {
			}
		}
		return vUKDrDRE;
	}

}