class n228865 {
	public static void doVersionCheck(View v6cExMCp) {
		v6cExMCp.showWaitCursor();
		try {
			URL AUgkLG3e = new URL(jEdit.getProperty("version-check.url"));
			InputStream deSh8f3r = AUgkLG3e.openStream();
			BufferedReader vfJNVzoy = new BufferedReader(new InputStreamReader(deSh8f3r));
			String QZOS07w5;
			String bXmTGeXC = null;
			String Ccc95Nt9 = null;
			while ((QZOS07w5 = vfJNVzoy.readLine()) != null) {
				if (QZOS07w5.startsWith(".build"))
					bXmTGeXC = QZOS07w5.substring(6).trim();
				else if (QZOS07w5.startsWith(".stablebuild"))
					Ccc95Nt9 = QZOS07w5.substring(12).trim();
			}
			vfJNVzoy.close();
			if (bXmTGeXC != null && Ccc95Nt9 != null) {
				doVersionCheck(v6cExMCp, Ccc95Nt9, bXmTGeXC);
			}
		} catch (IOException crQzUjWc) {
			String[] vnVsO28Q = { jEdit.getProperty("version-check.url"), crQzUjWc.toString() };
			GUIUtilities.error(v6cExMCp, "read-error", vnVsO28Q);
		}
		v6cExMCp.hideWaitCursor();
	}

}