class n255401 {
	public static void doVersionCheck(View aQsOPBnV) {
		aQsOPBnV.showWaitCursor();
		try {
			URL TuPGp2Ze = new URL(jEdit.getProperty("version-check.url"));
			InputStream r5IFr35Y = TuPGp2Ze.openStream();
			BufferedReader bmweCvLp = new BufferedReader(new InputStreamReader(r5IFr35Y));
			String g8k5Bbjo;
			String yeeoLyH2 = null;
			String Ait6e3Rt = null;
			while ((g8k5Bbjo = bmweCvLp.readLine()) != null) {
				if (g8k5Bbjo.startsWith(".build"))
					yeeoLyH2 = g8k5Bbjo.substring(6).trim();
				else if (g8k5Bbjo.startsWith(".stablebuild"))
					Ait6e3Rt = g8k5Bbjo.substring(12).trim();
			}
			bmweCvLp.close();
			if (yeeoLyH2 != null && Ait6e3Rt != null) {
				doVersionCheck(aQsOPBnV, Ait6e3Rt, yeeoLyH2);
			}
		} catch (IOException BpqvOX4V) {
			String[] xrzHq6qu = { jEdit.getProperty("version-check.url"), BpqvOX4V.toString() };
			GUIUtilities.error(aQsOPBnV, "read-error", xrzHq6qu);
		}
		aQsOPBnV.hideWaitCursor();
	}

}