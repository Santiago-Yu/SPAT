class n338138 {
	public static void doVersionCheck(View P6nDS2mh) {
		P6nDS2mh.showWaitCursor();
		try {
			URL TLrT68ax = new URL(jEdit.getProperty("version-check.url"));
			InputStream lLNoCV8U = TLrT68ax.openStream();
			BufferedReader KAZkARmx = new BufferedReader(new InputStreamReader(lLNoCV8U));
			String vYBwoFvG;
			String CUEYbNYZ = null;
			String JJAiEfXY = null;
			while ((vYBwoFvG = KAZkARmx.readLine()) != null) {
				if (vYBwoFvG.startsWith(".build"))
					CUEYbNYZ = vYBwoFvG.substring(6).trim();
				else if (vYBwoFvG.startsWith(".stablebuild"))
					JJAiEfXY = vYBwoFvG.substring(12).trim();
			}
			KAZkARmx.close();
			if (CUEYbNYZ != null && JJAiEfXY != null) {
				doVersionCheck(P6nDS2mh, JJAiEfXY, CUEYbNYZ);
			}
		} catch (IOException KNm87vaw) {
			String[] TVTviURe = { jEdit.getProperty("version-check.url"), KNm87vaw.toString() };
			GUIUtilities.error(P6nDS2mh, "read-error", TVTviURe);
		}
		P6nDS2mh.hideWaitCursor();
	}

}