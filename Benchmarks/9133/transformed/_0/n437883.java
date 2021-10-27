class n437883 {
	public static void doVersionCheck(View LgncZUqM) {
		LgncZUqM.showWaitCursor();
		try {
			URL aiKeZtuo = new URL(jEdit.getProperty("version-check.url"));
			InputStream QvLnYHvV = aiKeZtuo.openStream();
			BufferedReader XObM2cmP = new BufferedReader(new InputStreamReader(QvLnYHvV));
			String LekUMVSz;
			String UB3beVSI = null;
			String jbRn7p19 = null;
			while ((LekUMVSz = XObM2cmP.readLine()) != null) {
				if (LekUMVSz.startsWith(".build"))
					UB3beVSI = LekUMVSz.substring(6).trim();
				else if (LekUMVSz.startsWith(".stablebuild"))
					jbRn7p19 = LekUMVSz.substring(12).trim();
			}
			XObM2cmP.close();
			if (UB3beVSI != null && jbRn7p19 != null) {
				doVersionCheck(LgncZUqM, jbRn7p19, UB3beVSI);
			}
		} catch (IOException xRIqJsJ9) {
			String[] LsMBzkce = { jEdit.getProperty("version-check.url"), xRIqJsJ9.toString() };
			GUIUtilities.error(LgncZUqM, "read-error", LsMBzkce);
		}
		LgncZUqM.hideWaitCursor();
	}

}