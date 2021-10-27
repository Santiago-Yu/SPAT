class n350482 {
	public static void doVersionCheck(View x9E2I4uQ) {
		x9E2I4uQ.showWaitCursor();
		try {
			URL qskv8vYX = new URL(jEdit.getProperty("version-check.url"));
			InputStream okmVT20q = qskv8vYX.openStream();
			BufferedReader j6hmJQ8Y = new BufferedReader(new InputStreamReader(okmVT20q));
			String wJgY1c42;
			String VdLxmyX5 = null;
			String UB8Buujv = null;
			while ((wJgY1c42 = j6hmJQ8Y.readLine()) != null) {
				if (wJgY1c42.startsWith(".build"))
					VdLxmyX5 = wJgY1c42.substring(6).trim();
				else if (wJgY1c42.startsWith(".stablebuild"))
					UB8Buujv = wJgY1c42.substring(12).trim();
			}
			j6hmJQ8Y.close();
			if (VdLxmyX5 != null && UB8Buujv != null) {
				doVersionCheck(x9E2I4uQ, UB8Buujv, VdLxmyX5);
			}
		} catch (IOException dfDRHoY2) {
			String[] fpAJ4WCl = { jEdit.getProperty("version-check.url"), dfDRHoY2.toString() };
			GUIUtilities.error(x9E2I4uQ, "read-error", fpAJ4WCl);
		}
		x9E2I4uQ.hideWaitCursor();
	}

}