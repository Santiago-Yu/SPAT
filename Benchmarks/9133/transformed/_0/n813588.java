class n813588 {
	public static void doVersionCheck(View YwB8HBiN) {
		YwB8HBiN.showWaitCursor();
		try {
			URL DiUb2wmC = new URL(jEdit.getProperty("version-check.url"));
			InputStream imMWjjpW = DiUb2wmC.openStream();
			BufferedReader aPvVd9px = new BufferedReader(new InputStreamReader(imMWjjpW));
			String JBPQjlYL;
			String mpdJhsdB = null;
			String k2KltxCT = null;
			while ((JBPQjlYL = aPvVd9px.readLine()) != null) {
				if (JBPQjlYL.startsWith(".build"))
					mpdJhsdB = JBPQjlYL.substring(6).trim();
				else if (JBPQjlYL.startsWith(".stablebuild"))
					k2KltxCT = JBPQjlYL.substring(12).trim();
			}
			aPvVd9px.close();
			if (mpdJhsdB != null && k2KltxCT != null) {
				doVersionCheck(YwB8HBiN, k2KltxCT, mpdJhsdB);
			}
		} catch (IOException I9J2uzCz) {
			String[] F7hqa4ds = { jEdit.getProperty("version-check.url"), I9J2uzCz.toString() };
			GUIUtilities.error(YwB8HBiN, "read-error", F7hqa4ds);
		}
		YwB8HBiN.hideWaitCursor();
	}

}