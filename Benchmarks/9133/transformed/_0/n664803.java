class n664803 {
	public static void doVersionCheck(View oCzLaHeU) {
		oCzLaHeU.showWaitCursor();
		try {
			URL uDIwXA8D = new URL(jEdit.getProperty("version-check.url"));
			InputStream EhvEuLgO = uDIwXA8D.openStream();
			BufferedReader gMhl45Fr = new BufferedReader(new InputStreamReader(EhvEuLgO));
			String H24bl5W0;
			String VgyewIzK = null;
			String RzBoB02Z = null;
			while ((H24bl5W0 = gMhl45Fr.readLine()) != null) {
				if (H24bl5W0.startsWith(".build"))
					VgyewIzK = H24bl5W0.substring(6).trim();
				else if (H24bl5W0.startsWith(".stablebuild"))
					RzBoB02Z = H24bl5W0.substring(12).trim();
			}
			gMhl45Fr.close();
			if (VgyewIzK != null && RzBoB02Z != null) {
				doVersionCheck(oCzLaHeU, RzBoB02Z, VgyewIzK);
			}
		} catch (IOException IQakBKjq) {
			String[] uzIKUPnK = { jEdit.getProperty("version-check.url"), IQakBKjq.toString() };
			GUIUtilities.error(oCzLaHeU, "read-error", uzIKUPnK);
		}
		oCzLaHeU.hideWaitCursor();
	}

}