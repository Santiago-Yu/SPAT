class n901348 {
	public static void doVersionCheck(View yVu36NWw) {
		yVu36NWw.showWaitCursor();
		try {
			URL yewXCBCa = new URL(jEdit.getProperty("version-check.url"));
			InputStream Ss7Kvaho = yewXCBCa.openStream();
			BufferedReader UpnFzr3L = new BufferedReader(new InputStreamReader(Ss7Kvaho));
			String u8GB4mMf;
			String MtQtEncG = null;
			String tA2XyUEr = null;
			while ((u8GB4mMf = UpnFzr3L.readLine()) != null) {
				if (u8GB4mMf.startsWith(".build"))
					MtQtEncG = u8GB4mMf.substring(6).trim();
				else if (u8GB4mMf.startsWith(".stablebuild"))
					tA2XyUEr = u8GB4mMf.substring(12).trim();
			}
			UpnFzr3L.close();
			if (MtQtEncG != null && tA2XyUEr != null) {
				doVersionCheck(yVu36NWw, tA2XyUEr, MtQtEncG);
			}
		} catch (IOException c8nY5r8O) {
			String[] DiqubCck = { jEdit.getProperty("version-check.url"), c8nY5r8O.toString() };
			GUIUtilities.error(yVu36NWw, "read-error", DiqubCck);
		}
		yVu36NWw.hideWaitCursor();
	}

}