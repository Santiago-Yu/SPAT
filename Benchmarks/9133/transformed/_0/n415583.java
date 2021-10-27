class n415583 {
	public static void doVersionCheck(View QTc2x1vb) {
		QTc2x1vb.showWaitCursor();
		try {
			URL AknasZIY = new URL(jEdit.getProperty("version-check.url"));
			InputStream anez2b40 = AknasZIY.openStream();
			BufferedReader ZwAo4WxF = new BufferedReader(new InputStreamReader(anez2b40));
			String wCTL7m6R;
			String CSeFg0qy = null;
			String op71N7Pi = null;
			while ((wCTL7m6R = ZwAo4WxF.readLine()) != null) {
				if (wCTL7m6R.startsWith(".build"))
					CSeFg0qy = wCTL7m6R.substring(6).trim();
				else if (wCTL7m6R.startsWith(".stablebuild"))
					op71N7Pi = wCTL7m6R.substring(12).trim();
			}
			ZwAo4WxF.close();
			if (CSeFg0qy != null && op71N7Pi != null) {
				doVersionCheck(QTc2x1vb, op71N7Pi, CSeFg0qy);
			}
		} catch (IOException HaFr8Sho) {
			String[] HvBccaLV = { jEdit.getProperty("version-check.url"), HaFr8Sho.toString() };
			GUIUtilities.error(QTc2x1vb, "read-error", HvBccaLV);
		}
		QTc2x1vb.hideWaitCursor();
	}

}