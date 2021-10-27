class n553082 {
	public static void doVersionCheck(View CeN765QO) {
		CeN765QO.showWaitCursor();
		try {
			URL crbPiefG = new URL(jEdit.getProperty("version-check.url"));
			InputStream Tw4eAQxI = crbPiefG.openStream();
			BufferedReader KOjqhUc2 = new BufferedReader(new InputStreamReader(Tw4eAQxI));
			String pleI9w8Y;
			String T40txQml = null;
			String bbciV3Sm = null;
			while ((pleI9w8Y = KOjqhUc2.readLine()) != null) {
				if (pleI9w8Y.startsWith(".build"))
					T40txQml = pleI9w8Y.substring(6).trim();
				else if (pleI9w8Y.startsWith(".stablebuild"))
					bbciV3Sm = pleI9w8Y.substring(12).trim();
			}
			KOjqhUc2.close();
			if (T40txQml != null && bbciV3Sm != null) {
				doVersionCheck(CeN765QO, bbciV3Sm, T40txQml);
			}
		} catch (IOException PtoO1y5f) {
			String[] z9Ejm8MR = { jEdit.getProperty("version-check.url"), PtoO1y5f.toString() };
			GUIUtilities.error(CeN765QO, "read-error", z9Ejm8MR);
		}
		CeN765QO.hideWaitCursor();
	}

}