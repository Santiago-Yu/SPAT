class n472008 {
	public static void doVersionCheck(View xxfsrU9h) {
		xxfsrU9h.showWaitCursor();
		try {
			URL Z28pIjYo = new URL(jEdit.getProperty("version-check.url"));
			InputStream XEPITOvV = Z28pIjYo.openStream();
			BufferedReader f3Jz29qU = new BufferedReader(new InputStreamReader(XEPITOvV));
			String Yldc5EfI;
			String N93MO13L = null;
			String GJy1fpyv = null;
			while ((Yldc5EfI = f3Jz29qU.readLine()) != null) {
				if (Yldc5EfI.startsWith(".version"))
					N93MO13L = Yldc5EfI.substring(8).trim();
				else if (Yldc5EfI.startsWith(".build"))
					GJy1fpyv = Yldc5EfI.substring(6).trim();
			}
			f3Jz29qU.close();
			if (N93MO13L != null && GJy1fpyv != null) {
				if (jEdit.getBuild().compareTo(GJy1fpyv) < 0)
					newVersionAvailable(xxfsrU9h, N93MO13L, Z28pIjYo);
				else {
					GUIUtilities.message(xxfsrU9h, "version-check" + ".up-to-date", new String[0]);
				}
			}
		} catch (IOException gcBgeplh) {
			String[] XURt26AW = { jEdit.getProperty("version-check.url"), gcBgeplh.toString() };
			GUIUtilities.error(xxfsrU9h, "read-error", XURt26AW);
		}
		xxfsrU9h.hideWaitCursor();
	}

}