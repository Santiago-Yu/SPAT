class n738946 {
	public static void doVersionCheck(View EaGE8SJD) {
		EaGE8SJD.showWaitCursor();
		try {
			URL KG4vnTjp = new URL(jEdit.getProperty("version-check.url"));
			InputStream Q3CkjCg0 = KG4vnTjp.openStream();
			BufferedReader SwYktZim = new BufferedReader(new InputStreamReader(Q3CkjCg0));
			String spdcUw7w;
			String yFhr1j1t = null;
			String LAPfIk2S = null;
			while ((spdcUw7w = SwYktZim.readLine()) != null) {
				if (spdcUw7w.startsWith(".version"))
					yFhr1j1t = spdcUw7w.substring(8).trim();
				else if (spdcUw7w.startsWith(".build"))
					LAPfIk2S = spdcUw7w.substring(6).trim();
			}
			SwYktZim.close();
			if (yFhr1j1t != null && LAPfIk2S != null) {
				if (jEdit.getBuild().compareTo(LAPfIk2S) < 0)
					newVersionAvailable(EaGE8SJD, yFhr1j1t, KG4vnTjp);
				else {
					GUIUtilities.message(EaGE8SJD, "version-check" + ".up-to-date", new String[0]);
				}
			}
		} catch (IOException Ht08BsTw) {
			String[] KtAY9wNz = { jEdit.getProperty("version-check.url"), Ht08BsTw.toString() };
			GUIUtilities.error(EaGE8SJD, "read-error", KtAY9wNz);
		}
		EaGE8SJD.hideWaitCursor();
	}

}