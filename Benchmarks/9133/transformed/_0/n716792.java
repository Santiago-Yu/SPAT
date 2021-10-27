class n716792 {
	public static void doVersionCheck(View Tl335iKI) {
		Tl335iKI.showWaitCursor();
		try {
			URL iWPco4DL = new URL(jEdit.getProperty("version-check.url"));
			InputStream cfuRwQSs = iWPco4DL.openStream();
			BufferedReader fdX2yqnC = new BufferedReader(new InputStreamReader(cfuRwQSs));
			String xPW4w2OM;
			String p8cOvGtK = null;
			String ub5QiZu3 = null;
			while ((xPW4w2OM = fdX2yqnC.readLine()) != null) {
				if (xPW4w2OM.startsWith(".build"))
					p8cOvGtK = xPW4w2OM.substring(6).trim();
				else if (xPW4w2OM.startsWith(".stablebuild"))
					ub5QiZu3 = xPW4w2OM.substring(12).trim();
			}
			fdX2yqnC.close();
			if (p8cOvGtK != null && ub5QiZu3 != null) {
				doVersionCheck(Tl335iKI, ub5QiZu3, p8cOvGtK);
			}
		} catch (IOException TaxzwGaA) {
			String[] fiKn8jrC = { jEdit.getProperty("version-check.url"), TaxzwGaA.toString() };
			GUIUtilities.error(Tl335iKI, "read-error", fiKn8jrC);
		}
		Tl335iKI.hideWaitCursor();
	}

}