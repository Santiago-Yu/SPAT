class n442381 {
	public static void doVersionCheck(View PTZN9unj) {
		PTZN9unj.showWaitCursor();
		try {
			URL nOHJCARU = new URL(jEdit.getProperty("version-check.url"));
			InputStream qzaWFDYm = nOHJCARU.openStream();
			BufferedReader U5eFYyRB = new BufferedReader(new InputStreamReader(qzaWFDYm));
			String Ux8zyM1N;
			String yFlmnX0U = null;
			String gs3xXCsX = null;
			while ((Ux8zyM1N = U5eFYyRB.readLine()) != null) {
				if (Ux8zyM1N.startsWith(".build"))
					yFlmnX0U = Ux8zyM1N.substring(6).trim();
				else if (Ux8zyM1N.startsWith(".stablebuild"))
					gs3xXCsX = Ux8zyM1N.substring(12).trim();
			}
			U5eFYyRB.close();
			if (yFlmnX0U != null && gs3xXCsX != null) {
				doVersionCheck(PTZN9unj, gs3xXCsX, yFlmnX0U);
			}
		} catch (IOException MBpE7tqR) {
			String[] u94EHHAI = { jEdit.getProperty("version-check.url"), MBpE7tqR.toString() };
			GUIUtilities.error(PTZN9unj, "read-error", u94EHHAI);
		}
		PTZN9unj.hideWaitCursor();
	}

}