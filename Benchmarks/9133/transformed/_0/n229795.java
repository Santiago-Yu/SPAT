class n229795 {
	public static void doVersionCheck(View jgQBuuP0) {
		jgQBuuP0.showWaitCursor();
		try {
			URL qYUA76Cg = new URL(jEdit.getProperty("version-check.url"));
			InputStream yGZ79m11 = qYUA76Cg.openStream();
			BufferedReader GZZhMZfz = new BufferedReader(new InputStreamReader(yGZ79m11));
			String D64Rk1UP;
			String U0U8MFed = null;
			String Y675UolG = null;
			while ((D64Rk1UP = GZZhMZfz.readLine()) != null) {
				if (D64Rk1UP.startsWith(".version"))
					U0U8MFed = D64Rk1UP.substring(8).trim();
				else if (D64Rk1UP.startsWith(".build"))
					Y675UolG = D64Rk1UP.substring(6).trim();
			}
			GZZhMZfz.close();
			if (U0U8MFed != null && Y675UolG != null) {
				if (jEdit.getBuild().compareTo(Y675UolG) < 0)
					newVersionAvailable(jgQBuuP0, U0U8MFed, qYUA76Cg);
				else {
					GUIUtilities.message(jgQBuuP0, "version-check" + ".up-to-date", new String[0]);
				}
			}
		} catch (IOException jUyCuJ3P) {
			String[] G4u3Rbtn = { jEdit.getProperty("version-check.url"), jUyCuJ3P.toString() };
			GUIUtilities.error(jgQBuuP0, "read-error", G4u3Rbtn);
		}
		jgQBuuP0.hideWaitCursor();
	}

}