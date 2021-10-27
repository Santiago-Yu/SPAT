class n130541 {
	public static void doVersionCheck(View hV4yj4fj) {
		hV4yj4fj.showWaitCursor();
		try {
			URL xjgG3uNb = new URL(jEdit.getProperty("version-check.url"));
			InputStream qfohiEi9 = xjgG3uNb.openStream();
			BufferedReader LdyqkiwG = new BufferedReader(new InputStreamReader(qfohiEi9));
			String mFpF6hkZ;
			String mEc5VU9l = null;
			String ScrGc8EL = null;
			while ((mFpF6hkZ = LdyqkiwG.readLine()) != null) {
				if (mFpF6hkZ.startsWith(".build"))
					mEc5VU9l = mFpF6hkZ.substring(6).trim();
				else if (mFpF6hkZ.startsWith(".stablebuild"))
					ScrGc8EL = mFpF6hkZ.substring(12).trim();
			}
			LdyqkiwG.close();
			if (mEc5VU9l != null && ScrGc8EL != null) {
				doVersionCheck(hV4yj4fj, ScrGc8EL, mEc5VU9l);
			}
		} catch (IOException yRFYGwb9) {
			String[] H0x3W09k = { jEdit.getProperty("version-check.url"), yRFYGwb9.toString() };
			GUIUtilities.error(hV4yj4fj, "read-error", H0x3W09k);
		}
		hV4yj4fj.hideWaitCursor();
	}

}