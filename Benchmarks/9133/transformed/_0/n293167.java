class n293167 {
	public static void doVersionCheck(View xdEszdHO) {
		xdEszdHO.showWaitCursor();
		try {
			URL kN6bBBEv = new URL(jEdit.getProperty("version-check.url"));
			InputStream ZVMNEHZX = kN6bBBEv.openStream();
			BufferedReader u272AH9j = new BufferedReader(new InputStreamReader(ZVMNEHZX));
			String oCD6kOe7;
			String qIvP5lDg = null;
			String UX31rfMf = null;
			while ((oCD6kOe7 = u272AH9j.readLine()) != null) {
				if (oCD6kOe7.startsWith(".version"))
					qIvP5lDg = oCD6kOe7.substring(8).trim();
				else if (oCD6kOe7.startsWith(".build"))
					UX31rfMf = oCD6kOe7.substring(6).trim();
			}
			u272AH9j.close();
			if (qIvP5lDg != null && UX31rfMf != null) {
				if (jEdit.getBuild().compareTo(UX31rfMf) < 0)
					newVersionAvailable(xdEszdHO, qIvP5lDg, kN6bBBEv);
				else {
					GUIUtilities.message(xdEszdHO, "version-check" + ".up-to-date", new String[0]);
				}
			}
		} catch (IOException nL7i5FGq) {
			String[] Niu8LBOy = { jEdit.getProperty("version-check.url"), nL7i5FGq.toString() };
			GUIUtilities.error(xdEszdHO, "read-error", Niu8LBOy);
		}
		xdEszdHO.hideWaitCursor();
	}

}