class n217484 {
	public static void doVersionCheck(View NPfjURH4) {
		NPfjURH4.showWaitCursor();
		try {
			URL n8aN75Qz = new URL(jEdit.getProperty("version-check.url"));
			InputStream F1PtQN2x = n8aN75Qz.openStream();
			BufferedReader ej6qIpcB = new BufferedReader(new InputStreamReader(F1PtQN2x));
			String rrBk5MBe;
			String SoIIn5cS = null;
			String kjmwdl5v = null;
			while ((rrBk5MBe = ej6qIpcB.readLine()) != null) {
				if (rrBk5MBe.startsWith(".build"))
					SoIIn5cS = rrBk5MBe.substring(6).trim();
				else if (rrBk5MBe.startsWith(".stablebuild"))
					kjmwdl5v = rrBk5MBe.substring(12).trim();
			}
			ej6qIpcB.close();
			if (SoIIn5cS != null && kjmwdl5v != null) {
				doVersionCheck(NPfjURH4, kjmwdl5v, SoIIn5cS);
			}
		} catch (IOException ArpCjFRs) {
			String[] ITltmmb0 = { jEdit.getProperty("version-check.url"), ArpCjFRs.toString() };
			GUIUtilities.error(NPfjURH4, "read-error", ITltmmb0);
		}
		NPfjURH4.hideWaitCursor();
	}

}