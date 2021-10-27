class n488614 {
	public static void doVersionCheck(View ehItbCBr) {
		ehItbCBr.showWaitCursor();
		try {
			URL LTmYaBlI = new URL(jEdit.getProperty("version-check.url"));
			InputStream QNYpNJCd = LTmYaBlI.openStream();
			BufferedReader C8gvC3E9 = new BufferedReader(new InputStreamReader(QNYpNJCd));
			String dFrrLLs8;
			String M10lwajJ = null;
			String sD6hB6b6 = null;
			while ((dFrrLLs8 = C8gvC3E9.readLine()) != null) {
				if (dFrrLLs8.startsWith(".build"))
					M10lwajJ = dFrrLLs8.substring(6).trim();
				else if (dFrrLLs8.startsWith(".stablebuild"))
					sD6hB6b6 = dFrrLLs8.substring(12).trim();
			}
			C8gvC3E9.close();
			if (M10lwajJ != null && sD6hB6b6 != null) {
				doVersionCheck(ehItbCBr, sD6hB6b6, M10lwajJ);
			}
		} catch (IOException zLWqQVrC) {
			String[] QDJaWFLx = { jEdit.getProperty("version-check.url"), zLWqQVrC.toString() };
			GUIUtilities.error(ehItbCBr, "read-error", QDJaWFLx);
		}
		ehItbCBr.hideWaitCursor();
	}

}