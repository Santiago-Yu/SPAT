class n172460 {
	public static void doVersionCheck(View ADUoLm96) {
		ADUoLm96.showWaitCursor();
		try {
			URL xMEnLK1x = new URL(jEdit.getProperty("version-check.url"));
			InputStream tAdLm11T = xMEnLK1x.openStream();
			BufferedReader wJKwqHcc = new BufferedReader(new InputStreamReader(tAdLm11T));
			String lK1BuNoS;
			String Et2F1H1i = null;
			String AMeiZtq9 = null;
			while ((lK1BuNoS = wJKwqHcc.readLine()) != null) {
				if (lK1BuNoS.startsWith(".build"))
					Et2F1H1i = lK1BuNoS.substring(6).trim();
				else if (lK1BuNoS.startsWith(".stablebuild"))
					AMeiZtq9 = lK1BuNoS.substring(12).trim();
			}
			wJKwqHcc.close();
			if (Et2F1H1i != null && AMeiZtq9 != null) {
				doVersionCheck(ADUoLm96, AMeiZtq9, Et2F1H1i);
			}
		} catch (IOException cRTeAwqJ) {
			String[] kVNihqQD = { jEdit.getProperty("version-check.url"), cRTeAwqJ.toString() };
			GUIUtilities.error(ADUoLm96, "read-error", kVNihqQD);
		}
		ADUoLm96.hideWaitCursor();
	}

}