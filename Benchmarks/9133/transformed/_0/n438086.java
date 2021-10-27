class n438086 {
	public static void doVersionCheck(View vGDpToun) {
		vGDpToun.showWaitCursor();
		try {
			URL EYtCCjcO = new URL(jEdit.getProperty("version-check.url"));
			InputStream Ta4ae5Ru = EYtCCjcO.openStream();
			BufferedReader fYBAzj09 = new BufferedReader(new InputStreamReader(Ta4ae5Ru));
			String FT663eGY;
			String q18B9etz = null;
			String yANUC4cH = null;
			while ((FT663eGY = fYBAzj09.readLine()) != null) {
				if (FT663eGY.startsWith(".build"))
					q18B9etz = FT663eGY.substring(6).trim();
				else if (FT663eGY.startsWith(".stablebuild"))
					yANUC4cH = FT663eGY.substring(12).trim();
			}
			fYBAzj09.close();
			if (q18B9etz != null && yANUC4cH != null) {
				doVersionCheck(vGDpToun, yANUC4cH, q18B9etz);
			}
		} catch (IOException aHt04D21) {
			String[] tr9hf55g = { jEdit.getProperty("version-check.url"), aHt04D21.toString() };
			GUIUtilities.error(vGDpToun, "read-error", tr9hf55g);
		}
		vGDpToun.hideWaitCursor();
	}

}