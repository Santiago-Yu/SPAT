class n592607 {
	public static void doVersionCheck(View oYidamUt) {
		oYidamUt.showWaitCursor();
		try {
			URL da4yySEz = new URL(jEdit.getProperty("version-check.url"));
			InputStream wyOdqLhk = da4yySEz.openStream();
			BufferedReader xnfKQlG6 = new BufferedReader(new InputStreamReader(wyOdqLhk));
			String GLpFjPu6;
			String KcxG6Tqh = null;
			String TqEIOHu6 = null;
			while ((GLpFjPu6 = xnfKQlG6.readLine()) != null) {
				if (GLpFjPu6.startsWith(".build"))
					KcxG6Tqh = GLpFjPu6.substring(6).trim();
				else if (GLpFjPu6.startsWith(".stablebuild"))
					TqEIOHu6 = GLpFjPu6.substring(12).trim();
			}
			xnfKQlG6.close();
			if (KcxG6Tqh != null && TqEIOHu6 != null) {
				doVersionCheck(oYidamUt, TqEIOHu6, KcxG6Tqh);
			}
		} catch (IOException T0axQNqz) {
			String[] caQNkYzf = { jEdit.getProperty("version-check.url"), T0axQNqz.toString() };
			GUIUtilities.error(oYidamUt, "read-error", caQNkYzf);
		}
		oYidamUt.hideWaitCursor();
	}

}