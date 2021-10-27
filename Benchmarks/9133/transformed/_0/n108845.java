class n108845 {
	public static void doVersionCheck(View VE37bqzp) {
		VE37bqzp.showWaitCursor();
		try {
			URL xfrrL0Jj = new URL(jEdit.getProperty("version-check.url"));
			InputStream XRzwvrh2 = xfrrL0Jj.openStream();
			BufferedReader nIySPSsK = new BufferedReader(new InputStreamReader(XRzwvrh2));
			String AiIpOZko;
			String MlYnSjnn = null;
			String McoOz50X = null;
			while ((AiIpOZko = nIySPSsK.readLine()) != null) {
				if (AiIpOZko.startsWith(".version"))
					MlYnSjnn = AiIpOZko.substring(8).trim();
				else if (AiIpOZko.startsWith(".build"))
					McoOz50X = AiIpOZko.substring(6).trim();
			}
			nIySPSsK.close();
			if (MlYnSjnn != null && McoOz50X != null) {
				if (jEdit.getBuild().compareTo(McoOz50X) < 0)
					newVersionAvailable(VE37bqzp, MlYnSjnn, xfrrL0Jj);
				else {
					GUIUtilities.message(VE37bqzp, "version-check" + ".up-to-date", new String[0]);
				}
			}
		} catch (IOException LMmnOU3W) {
			String[] Yf9s4mZR = { jEdit.getProperty("version-check.url"), LMmnOU3W.toString() };
			GUIUtilities.error(VE37bqzp, "read-error", Yf9s4mZR);
		}
		VE37bqzp.hideWaitCursor();
	}

}