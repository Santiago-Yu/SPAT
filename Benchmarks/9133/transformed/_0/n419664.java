class n419664 {
	public static void doVersionCheck(View leVuP4xr) {
		leVuP4xr.showWaitCursor();
		try {
			URL aSQ8iHp5 = new URL(jEdit.getProperty("version-check.url"));
			InputStream ZXfxJcaA = aSQ8iHp5.openStream();
			BufferedReader Ui1mczKJ = new BufferedReader(new InputStreamReader(ZXfxJcaA));
			String v9em63bY;
			String nb6CNKYr = null;
			String TRkYc3h4 = null;
			while ((v9em63bY = Ui1mczKJ.readLine()) != null) {
				if (v9em63bY.startsWith(".build"))
					nb6CNKYr = v9em63bY.substring(6).trim();
				else if (v9em63bY.startsWith(".stablebuild"))
					TRkYc3h4 = v9em63bY.substring(12).trim();
			}
			Ui1mczKJ.close();
			if (nb6CNKYr != null && TRkYc3h4 != null) {
				doVersionCheck(leVuP4xr, TRkYc3h4, nb6CNKYr);
			}
		} catch (IOException o7MR9cVK) {
			String[] M3a4TBCM = { jEdit.getProperty("version-check.url"), o7MR9cVK.toString() };
			GUIUtilities.error(leVuP4xr, "read-error", M3a4TBCM);
		}
		leVuP4xr.hideWaitCursor();
	}

}