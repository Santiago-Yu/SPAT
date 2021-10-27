class n443341 {
	public static void doVersionCheck(View EFcJfDd1) {
		EFcJfDd1.showWaitCursor();
		try {
			URL rpuv8QrA = new URL(jEdit.getProperty("version-check.url"));
			InputStream c00dAt73 = rpuv8QrA.openStream();
			BufferedReader KouwD2Pr = new BufferedReader(new InputStreamReader(c00dAt73));
			String PrWKoIEb;
			String mSpem9Rj = null;
			String fAhG1uDA = null;
			while ((PrWKoIEb = KouwD2Pr.readLine()) != null) {
				if (PrWKoIEb.startsWith(".version"))
					mSpem9Rj = PrWKoIEb.substring(8).trim();
				else if (PrWKoIEb.startsWith(".build"))
					fAhG1uDA = PrWKoIEb.substring(6).trim();
			}
			KouwD2Pr.close();
			if (mSpem9Rj != null && fAhG1uDA != null) {
				if (jEdit.getBuild().compareTo(fAhG1uDA) < 0)
					newVersionAvailable(EFcJfDd1, mSpem9Rj, rpuv8QrA);
				else {
					GUIUtilities.message(EFcJfDd1, "version-check" + ".up-to-date", new String[0]);
				}
			}
		} catch (IOException WaQDpxM8) {
			String[] HgNsSfsA = { jEdit.getProperty("version-check.url"), WaQDpxM8.toString() };
			GUIUtilities.error(EFcJfDd1, "read-error", HgNsSfsA);
		}
		EFcJfDd1.hideWaitCursor();
	}

}