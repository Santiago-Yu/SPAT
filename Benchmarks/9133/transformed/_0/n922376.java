class n922376 {
	public static void doVersionCheck(View lnw4svGc) {
		lnw4svGc.showWaitCursor();
		try {
			URL SNIsgnlB = new URL(jEdit.getProperty("version-check.url"));
			InputStream YdXS0dVv = SNIsgnlB.openStream();
			BufferedReader z1nHyYgj = new BufferedReader(new InputStreamReader(YdXS0dVv));
			String c7gvIk97;
			String wxNP7mzw = null;
			String mILlx6nm = null;
			while ((c7gvIk97 = z1nHyYgj.readLine()) != null) {
				if (c7gvIk97.startsWith(".build"))
					wxNP7mzw = c7gvIk97.substring(6).trim();
				else if (c7gvIk97.startsWith(".stablebuild"))
					mILlx6nm = c7gvIk97.substring(12).trim();
			}
			z1nHyYgj.close();
			if (wxNP7mzw != null && mILlx6nm != null) {
				doVersionCheck(lnw4svGc, mILlx6nm, wxNP7mzw);
			}
		} catch (IOException NRBTdcpR) {
			String[] QZ4siMK7 = { jEdit.getProperty("version-check.url"), NRBTdcpR.toString() };
			GUIUtilities.error(lnw4svGc, "read-error", QZ4siMK7);
		}
		lnw4svGc.hideWaitCursor();
	}

}