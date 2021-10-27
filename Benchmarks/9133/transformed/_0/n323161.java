class n323161 {
	public static void doVersionCheck(View UzMrbwXu) {
		UzMrbwXu.showWaitCursor();
		try {
			URL s5KLrcCD = new URL(jEdit.getProperty("version-check.url"));
			InputStream upXSiL7X = s5KLrcCD.openStream();
			BufferedReader My4XlSS2 = new BufferedReader(new InputStreamReader(upXSiL7X));
			String f7xPYYWR;
			String CoXITfI7 = null;
			String izPsKanA = null;
			while ((f7xPYYWR = My4XlSS2.readLine()) != null) {
				if (f7xPYYWR.startsWith(".build"))
					CoXITfI7 = f7xPYYWR.substring(6).trim();
				else if (f7xPYYWR.startsWith(".stablebuild"))
					izPsKanA = f7xPYYWR.substring(12).trim();
			}
			My4XlSS2.close();
			if (CoXITfI7 != null && izPsKanA != null) {
				doVersionCheck(UzMrbwXu, izPsKanA, CoXITfI7);
			}
		} catch (IOException NjJ8shG7) {
			String[] bFdJYJVD = { jEdit.getProperty("version-check.url"), NjJ8shG7.toString() };
			GUIUtilities.error(UzMrbwXu, "read-error", bFdJYJVD);
		}
		UzMrbwXu.hideWaitCursor();
	}

}