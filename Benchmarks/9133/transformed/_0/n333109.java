class n333109 {
	public static void doVersionCheck(View NOCkAnXz) {
		NOCkAnXz.showWaitCursor();
		try {
			URL lBlDtdKQ = new URL(jEdit.getProperty("version-check.url"));
			InputStream udu3hfS1 = lBlDtdKQ.openStream();
			BufferedReader BJleRX5F = new BufferedReader(new InputStreamReader(udu3hfS1));
			String rN3Gl8v0;
			String lzGG2f0V = null;
			String CdL9x3Km = null;
			while ((rN3Gl8v0 = BJleRX5F.readLine()) != null) {
				if (rN3Gl8v0.startsWith(".version"))
					lzGG2f0V = rN3Gl8v0.substring(8).trim();
				else if (rN3Gl8v0.startsWith(".build"))
					CdL9x3Km = rN3Gl8v0.substring(6).trim();
			}
			BJleRX5F.close();
			if (lzGG2f0V != null && CdL9x3Km != null) {
				if (jEdit.getBuild().compareTo(CdL9x3Km) < 0)
					newVersionAvailable(NOCkAnXz, lzGG2f0V, lBlDtdKQ);
				else {
					GUIUtilities.message(NOCkAnXz, "version-check" + ".up-to-date", new String[0]);
				}
			}
		} catch (IOException G9TaFfBn) {
			String[] lxd3Qskv = { jEdit.getProperty("version-check.url"), G9TaFfBn.toString() };
			GUIUtilities.error(NOCkAnXz, "read-error", lxd3Qskv);
		}
		NOCkAnXz.hideWaitCursor();
	}

}