class n447509 {
	public static void doVersionCheck(View gmCM6dvS) {
		gmCM6dvS.showWaitCursor();
		try {
			URL XAsAJXFB = new URL(jEdit.getProperty("version-check.url"));
			InputStream ypHU1Ow1 = XAsAJXFB.openStream();
			BufferedReader RsI35iLR = new BufferedReader(new InputStreamReader(ypHU1Ow1));
			String l89RZkz4;
			String VIwrjsQw = null;
			String pfbeOWmO = null;
			while ((l89RZkz4 = RsI35iLR.readLine()) != null) {
				if (l89RZkz4.startsWith(".build"))
					VIwrjsQw = l89RZkz4.substring(6).trim();
				else if (l89RZkz4.startsWith(".stablebuild"))
					pfbeOWmO = l89RZkz4.substring(12).trim();
			}
			RsI35iLR.close();
			if (VIwrjsQw != null && pfbeOWmO != null) {
				doVersionCheck(gmCM6dvS, pfbeOWmO, VIwrjsQw);
			}
		} catch (IOException zpiV2vwl) {
			String[] OK5cbIgu = { jEdit.getProperty("version-check.url"), zpiV2vwl.toString() };
			GUIUtilities.error(gmCM6dvS, "read-error", OK5cbIgu);
		}
		gmCM6dvS.hideWaitCursor();
	}

}