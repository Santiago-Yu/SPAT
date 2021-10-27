class n396354 {
	public static void doVersionCheck(View l1iA7Gbq) {
		l1iA7Gbq.showWaitCursor();
		try {
			URL VkXt5s4H = new URL(jEdit.getProperty("version-check.url"));
			InputStream ffeq18xG = VkXt5s4H.openStream();
			BufferedReader krsXWZYj = new BufferedReader(new InputStreamReader(ffeq18xG));
			String lnoADRYR;
			String IP5nWLos = null;
			String Kr6E31xA = null;
			while ((lnoADRYR = krsXWZYj.readLine()) != null) {
				if (lnoADRYR.startsWith(".build"))
					IP5nWLos = lnoADRYR.substring(6).trim();
				else if (lnoADRYR.startsWith(".stablebuild"))
					Kr6E31xA = lnoADRYR.substring(12).trim();
			}
			krsXWZYj.close();
			if (IP5nWLos != null && Kr6E31xA != null) {
				doVersionCheck(l1iA7Gbq, Kr6E31xA, IP5nWLos);
			}
		} catch (IOException XalWiJiS) {
			String[] NXdDvprT = { jEdit.getProperty("version-check.url"), XalWiJiS.toString() };
			GUIUtilities.error(l1iA7Gbq, "read-error", NXdDvprT);
		}
		l1iA7Gbq.hideWaitCursor();
	}

}