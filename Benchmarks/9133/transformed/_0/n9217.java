class n9217 {
	public static void doVersionCheck(View yRuXnNZV) {
		yRuXnNZV.showWaitCursor();
		try {
			URL ZKILua1R = new URL(jEdit.getProperty("version-check.url"));
			InputStream CdXU8ZqU = ZKILua1R.openStream();
			BufferedReader jyghWBHK = new BufferedReader(new InputStreamReader(CdXU8ZqU));
			String MjFZ8iGE;
			String oCClELYy = null;
			String YLbXsSV4 = null;
			while ((MjFZ8iGE = jyghWBHK.readLine()) != null) {
				if (MjFZ8iGE.startsWith(".build"))
					oCClELYy = MjFZ8iGE.substring(6).trim();
				else if (MjFZ8iGE.startsWith(".stablebuild"))
					YLbXsSV4 = MjFZ8iGE.substring(12).trim();
			}
			jyghWBHK.close();
			if (oCClELYy != null && YLbXsSV4 != null) {
				doVersionCheck(yRuXnNZV, YLbXsSV4, oCClELYy);
			}
		} catch (IOException R9FcPsD3) {
			String[] JSr6iIGm = { jEdit.getProperty("version-check.url"), R9FcPsD3.toString() };
			GUIUtilities.error(yRuXnNZV, "read-error", JSr6iIGm);
		}
		yRuXnNZV.hideWaitCursor();
	}

}