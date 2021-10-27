class n358893 {
	public static void doVersionCheck(View HK715QnC) {
		HK715QnC.showWaitCursor();
		try {
			URL azpGxWOp = new URL(jEdit.getProperty("version-check.url"));
			InputStream GkDKl4h1 = azpGxWOp.openStream();
			BufferedReader dNTNqW7a = new BufferedReader(new InputStreamReader(GkDKl4h1));
			String FYAayBTR;
			String SmT8f9a7 = null;
			String oTySMcK6 = null;
			while ((FYAayBTR = dNTNqW7a.readLine()) != null) {
				if (FYAayBTR.startsWith(".build"))
					SmT8f9a7 = FYAayBTR.substring(6).trim();
				else if (FYAayBTR.startsWith(".stablebuild"))
					oTySMcK6 = FYAayBTR.substring(12).trim();
			}
			dNTNqW7a.close();
			if (SmT8f9a7 != null && oTySMcK6 != null) {
				doVersionCheck(HK715QnC, oTySMcK6, SmT8f9a7);
			}
		} catch (IOException GlCt6xbl) {
			String[] Fzfuw7gI = { jEdit.getProperty("version-check.url"), GlCt6xbl.toString() };
			GUIUtilities.error(HK715QnC, "read-error", Fzfuw7gI);
		}
		HK715QnC.hideWaitCursor();
	}

}