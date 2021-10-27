class n854534 {
	public static void doVersionCheck(View W6YxrDRF) {
		W6YxrDRF.showWaitCursor();
		try {
			URL BK0xLTAs = new URL(jEdit.getProperty("version-check.url"));
			InputStream iK7CC60T = BK0xLTAs.openStream();
			BufferedReader xkpkfTlI = new BufferedReader(new InputStreamReader(iK7CC60T));
			String w2bDnodo;
			String RVqYetp8 = null;
			String uNguvTtM = null;
			while ((w2bDnodo = xkpkfTlI.readLine()) != null) {
				if (w2bDnodo.startsWith(".version"))
					RVqYetp8 = w2bDnodo.substring(8).trim();
				else if (w2bDnodo.startsWith(".build"))
					uNguvTtM = w2bDnodo.substring(6).trim();
			}
			xkpkfTlI.close();
			if (RVqYetp8 != null && uNguvTtM != null) {
				if (jEdit.getBuild().compareTo(uNguvTtM) < 0)
					newVersionAvailable(W6YxrDRF, RVqYetp8, BK0xLTAs);
				else {
					GUIUtilities.message(W6YxrDRF, "version-check" + ".up-to-date", new String[0]);
				}
			}
		} catch (IOException TJiZ0p8d) {
			String[] TVBbIjl0 = { jEdit.getProperty("version-check.url"), TJiZ0p8d.toString() };
			GUIUtilities.error(W6YxrDRF, "read-error", TVBbIjl0);
		}
		W6YxrDRF.hideWaitCursor();
	}

}