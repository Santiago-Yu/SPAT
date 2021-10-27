class n848240 {
	public static void doVersionCheck(View PyfD2BBD) {
		PyfD2BBD.showWaitCursor();
		try {
			URL Kp6Org75 = new URL(jEdit.getProperty("version-check.url"));
			InputStream mxpyJDtD = Kp6Org75.openStream();
			BufferedReader XFdhr5kD = new BufferedReader(new InputStreamReader(mxpyJDtD));
			String BXrNLn9L;
			String YBQZ6Cf9 = null;
			String hLRs5BkC = null;
			while ((BXrNLn9L = XFdhr5kD.readLine()) != null) {
				if (BXrNLn9L.startsWith(".version"))
					YBQZ6Cf9 = BXrNLn9L.substring(8).trim();
				else if (BXrNLn9L.startsWith(".build"))
					hLRs5BkC = BXrNLn9L.substring(6).trim();
			}
			XFdhr5kD.close();
			if (YBQZ6Cf9 != null && hLRs5BkC != null) {
				if (jEdit.getBuild().compareTo(hLRs5BkC) < 0)
					newVersionAvailable(PyfD2BBD, YBQZ6Cf9, Kp6Org75);
				else {
					GUIUtilities.message(PyfD2BBD, "version-check" + ".up-to-date", new String[0]);
				}
			}
		} catch (IOException eqEHNXuH) {
			String[] OJnGaA5b = { jEdit.getProperty("version-check.url"), eqEHNXuH.toString() };
			GUIUtilities.error(PyfD2BBD, "read-error", OJnGaA5b);
		}
		PyfD2BBD.hideWaitCursor();
	}

}