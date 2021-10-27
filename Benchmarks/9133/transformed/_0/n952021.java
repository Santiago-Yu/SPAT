class n952021 {
	public static void doVersionCheck(View crZYYlxx) {
		crZYYlxx.showWaitCursor();
		try {
			URL dIFbpfu9 = new URL(jEdit.getProperty("version-check.url"));
			InputStream QxEuexvU = dIFbpfu9.openStream();
			BufferedReader i1R92Hne = new BufferedReader(new InputStreamReader(QxEuexvU));
			String qP8Qfr6t;
			String pKuDVZOB = null;
			String NbrjrilK = null;
			while ((qP8Qfr6t = i1R92Hne.readLine()) != null) {
				if (qP8Qfr6t.startsWith(".build"))
					pKuDVZOB = qP8Qfr6t.substring(6).trim();
				else if (qP8Qfr6t.startsWith(".stablebuild"))
					NbrjrilK = qP8Qfr6t.substring(12).trim();
			}
			i1R92Hne.close();
			if (pKuDVZOB != null && NbrjrilK != null) {
				doVersionCheck(crZYYlxx, NbrjrilK, pKuDVZOB);
			}
		} catch (IOException A0Cqx650) {
			String[] VbU1wOjT = { jEdit.getProperty("version-check.url"), A0Cqx650.toString() };
			GUIUtilities.error(crZYYlxx, "read-error", VbU1wOjT);
		}
		crZYYlxx.hideWaitCursor();
	}

}