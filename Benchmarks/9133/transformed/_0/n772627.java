class n772627 {
	public static void doVersionCheck(View GcHeHfXF) {
		GcHeHfXF.showWaitCursor();
		try {
			URL PsX1oSco = new URL(jEdit.getProperty("version-check.url"));
			InputStream LcYNcJON = PsX1oSco.openStream();
			BufferedReader ZtWZ8jW8 = new BufferedReader(new InputStreamReader(LcYNcJON));
			String z5oK2Yf3;
			String hLZXnbF6 = null;
			String DTmsxnUr = null;
			while ((z5oK2Yf3 = ZtWZ8jW8.readLine()) != null) {
				if (z5oK2Yf3.startsWith(".version"))
					hLZXnbF6 = z5oK2Yf3.substring(8).trim();
				else if (z5oK2Yf3.startsWith(".build"))
					DTmsxnUr = z5oK2Yf3.substring(6).trim();
			}
			ZtWZ8jW8.close();
			if (hLZXnbF6 != null && DTmsxnUr != null) {
				if (jEdit.getBuild().compareTo(DTmsxnUr) < 0)
					newVersionAvailable(GcHeHfXF, hLZXnbF6, PsX1oSco);
				else {
					GUIUtilities.message(GcHeHfXF, "version-check" + ".up-to-date", new String[0]);
				}
			}
		} catch (IOException fMeNfUp5) {
			String[] v15WbM1r = { jEdit.getProperty("version-check.url"), fMeNfUp5.toString() };
			GUIUtilities.error(GcHeHfXF, "read-error", v15WbM1r);
		}
		GcHeHfXF.hideWaitCursor();
	}

}