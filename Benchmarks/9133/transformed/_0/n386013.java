class n386013 {
	public static void doVersionCheck(View MOPGUpmK) {
		MOPGUpmK.showWaitCursor();
		try {
			URL QhtMfu5R = new URL(jEdit.getProperty("version-check.url"));
			InputStream G6z0TtTF = QhtMfu5R.openStream();
			BufferedReader QZq40yBa = new BufferedReader(new InputStreamReader(G6z0TtTF));
			String Sfycq105;
			String PiBSNEMy = null;
			String GNU1iWND = null;
			while ((Sfycq105 = QZq40yBa.readLine()) != null) {
				if (Sfycq105.startsWith(".build"))
					PiBSNEMy = Sfycq105.substring(6).trim();
				else if (Sfycq105.startsWith(".stablebuild"))
					GNU1iWND = Sfycq105.substring(12).trim();
			}
			QZq40yBa.close();
			if (PiBSNEMy != null && GNU1iWND != null) {
				doVersionCheck(MOPGUpmK, GNU1iWND, PiBSNEMy);
			}
		} catch (IOException MvEA9GQR) {
			String[] oK4OcEPk = { jEdit.getProperty("version-check.url"), MvEA9GQR.toString() };
			GUIUtilities.error(MOPGUpmK, "read-error", oK4OcEPk);
		}
		MOPGUpmK.hideWaitCursor();
	}

}