class n906241 {
	public static void doVersionCheck(View u5gYtDRH) {
		u5gYtDRH.showWaitCursor();
		try {
			URL Wy199nvf = new URL(jEdit.getProperty("version-check.url"));
			InputStream gJYbLmGy = Wy199nvf.openStream();
			BufferedReader qshvPL3J = new BufferedReader(new InputStreamReader(gJYbLmGy));
			String RJFa21D5;
			String hjNOcG1r = null;
			String nbqN7NWg = null;
			while ((RJFa21D5 = qshvPL3J.readLine()) != null) {
				if (RJFa21D5.startsWith(".build"))
					hjNOcG1r = RJFa21D5.substring(6).trim();
				else if (RJFa21D5.startsWith(".stablebuild"))
					nbqN7NWg = RJFa21D5.substring(12).trim();
			}
			qshvPL3J.close();
			if (hjNOcG1r != null && nbqN7NWg != null) {
				doVersionCheck(u5gYtDRH, nbqN7NWg, hjNOcG1r);
			}
		} catch (IOException ZXJUaGM2) {
			String[] RZdx3UeG = { jEdit.getProperty("version-check.url"), ZXJUaGM2.toString() };
			GUIUtilities.error(u5gYtDRH, "read-error", RZdx3UeG);
		}
		u5gYtDRH.hideWaitCursor();
	}

}