class n832234 {
	public static void doVersionCheck(View egDAvvt6) {
		egDAvvt6.showWaitCursor();
		try {
			URL yfkg19l5 = new URL(jEdit.getProperty("version-check.url"));
			InputStream AKxeZoGi = yfkg19l5.openStream();
			BufferedReader wxP4IdFy = new BufferedReader(new InputStreamReader(AKxeZoGi));
			String eTcX6LL2;
			String IXDWY5g2 = null;
			String y1qBJLVM = null;
			while ((eTcX6LL2 = wxP4IdFy.readLine()) != null) {
				if (eTcX6LL2.startsWith(".version"))
					IXDWY5g2 = eTcX6LL2.substring(8).trim();
				else if (eTcX6LL2.startsWith(".build"))
					y1qBJLVM = eTcX6LL2.substring(6).trim();
			}
			wxP4IdFy.close();
			if (IXDWY5g2 != null && y1qBJLVM != null) {
				if (jEdit.getBuild().compareTo(y1qBJLVM) < 0)
					newVersionAvailable(egDAvvt6, IXDWY5g2, yfkg19l5);
				else {
					GUIUtilities.message(egDAvvt6, "version-check" + ".up-to-date", new String[0]);
				}
			}
		} catch (IOException nRm11WcU) {
			String[] LPfl24Qz = { jEdit.getProperty("version-check.url"), nRm11WcU.toString() };
			GUIUtilities.error(egDAvvt6, "read-error", LPfl24Qz);
		}
		egDAvvt6.hideWaitCursor();
	}

}