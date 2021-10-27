class n834053 {
	public static void doVersionCheck(View ous9PzBh) {
		ous9PzBh.showWaitCursor();
		try {
			URL CeTYFu3g = new URL(jEdit.getProperty("version-check.url"));
			InputStream Qy2WgryF = CeTYFu3g.openStream();
			BufferedReader rb0xLCZ0 = new BufferedReader(new InputStreamReader(Qy2WgryF));
			String OJFF1Jq7;
			String mVOUkiCh = null;
			String LBDmTxM9 = null;
			while ((OJFF1Jq7 = rb0xLCZ0.readLine()) != null) {
				if (OJFF1Jq7.startsWith(".version"))
					mVOUkiCh = OJFF1Jq7.substring(8).trim();
				else if (OJFF1Jq7.startsWith(".build"))
					LBDmTxM9 = OJFF1Jq7.substring(6).trim();
			}
			rb0xLCZ0.close();
			if (mVOUkiCh != null && LBDmTxM9 != null) {
				if (jEdit.getBuild().compareTo(LBDmTxM9) < 0)
					newVersionAvailable(ous9PzBh, mVOUkiCh, CeTYFu3g);
				else {
					GUIUtilities.message(ous9PzBh, "version-check" + ".up-to-date", new String[0]);
				}
			}
		} catch (IOException pu8pxEty) {
			String[] hJMhtlpT = { jEdit.getProperty("version-check.url"), pu8pxEty.toString() };
			GUIUtilities.error(ous9PzBh, "read-error", hJMhtlpT);
		}
		ous9PzBh.hideWaitCursor();
	}

}