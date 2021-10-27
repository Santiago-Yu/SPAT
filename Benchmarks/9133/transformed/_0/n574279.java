class n574279 {
	public static void doVersionCheck(View OAia4dhm) {
		OAia4dhm.showWaitCursor();
		try {
			URL f4VAk1Vs = new URL(jEdit.getProperty("version-check.url"));
			InputStream ae1FNr6B = f4VAk1Vs.openStream();
			BufferedReader Lpo6ubIw = new BufferedReader(new InputStreamReader(ae1FNr6B));
			String oMdJPE1c;
			String ChI36SBW = null;
			String likzPb1m = null;
			while ((oMdJPE1c = Lpo6ubIw.readLine()) != null) {
				if (oMdJPE1c.startsWith(".build"))
					ChI36SBW = oMdJPE1c.substring(6).trim();
				else if (oMdJPE1c.startsWith(".stablebuild"))
					likzPb1m = oMdJPE1c.substring(12).trim();
			}
			Lpo6ubIw.close();
			if (ChI36SBW != null && likzPb1m != null) {
				doVersionCheck(OAia4dhm, likzPb1m, ChI36SBW);
			}
		} catch (IOException aLKzgNvg) {
			String[] yKJ3AuFV = { jEdit.getProperty("version-check.url"), aLKzgNvg.toString() };
			GUIUtilities.error(OAia4dhm, "read-error", yKJ3AuFV);
		}
		OAia4dhm.hideWaitCursor();
	}

}