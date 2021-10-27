class n768490 {
	public static void doVersionCheck(View AsluNKnh) {
		AsluNKnh.showWaitCursor();
		try {
			URL p4Sa1HUv = new URL(jEdit.getProperty("version-check.url"));
			InputStream rHZPNKoi = p4Sa1HUv.openStream();
			BufferedReader BJ3zJSlJ = new BufferedReader(new InputStreamReader(rHZPNKoi));
			String KfEQdYiI;
			String mjY28rdV = null;
			String aGbqhhZS = null;
			while ((KfEQdYiI = BJ3zJSlJ.readLine()) != null) {
				if (KfEQdYiI.startsWith(".build"))
					mjY28rdV = KfEQdYiI.substring(6).trim();
				else if (KfEQdYiI.startsWith(".stablebuild"))
					aGbqhhZS = KfEQdYiI.substring(12).trim();
			}
			BJ3zJSlJ.close();
			if (mjY28rdV != null && aGbqhhZS != null) {
				doVersionCheck(AsluNKnh, aGbqhhZS, mjY28rdV);
			}
		} catch (IOException ctvBFH8Z) {
			String[] Bg8fT9Rz = { jEdit.getProperty("version-check.url"), ctvBFH8Z.toString() };
			GUIUtilities.error(AsluNKnh, "read-error", Bg8fT9Rz);
		}
		AsluNKnh.hideWaitCursor();
	}

}