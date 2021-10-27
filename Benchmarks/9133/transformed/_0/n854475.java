class n854475 {
	public static void doVersionCheck(View hIwxcTPm) {
		hIwxcTPm.showWaitCursor();
		try {
			URL PffQ0i4P = new URL(jEdit.getProperty("version-check.url"));
			InputStream AfjlTGSU = PffQ0i4P.openStream();
			BufferedReader m1QvTDgo = new BufferedReader(new InputStreamReader(AfjlTGSU));
			String yT3OX9xy;
			String OSbEsHLH = null;
			String ODfxsM8w = null;
			while ((yT3OX9xy = m1QvTDgo.readLine()) != null) {
				if (yT3OX9xy.startsWith(".build"))
					OSbEsHLH = yT3OX9xy.substring(6).trim();
				else if (yT3OX9xy.startsWith(".stablebuild"))
					ODfxsM8w = yT3OX9xy.substring(12).trim();
			}
			m1QvTDgo.close();
			if (OSbEsHLH != null && ODfxsM8w != null) {
				doVersionCheck(hIwxcTPm, ODfxsM8w, OSbEsHLH);
			}
		} catch (IOException WrjyWh6b) {
			String[] bqLDlkWc = { jEdit.getProperty("version-check.url"), WrjyWh6b.toString() };
			GUIUtilities.error(hIwxcTPm, "read-error", bqLDlkWc);
		}
		hIwxcTPm.hideWaitCursor();
	}

}