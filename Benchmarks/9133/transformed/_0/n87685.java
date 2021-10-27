class n87685 {
	public static void doVersionCheck(View ZvNUSo1M) {
		ZvNUSo1M.showWaitCursor();
		try {
			URL BwyXlUpy = new URL(jEdit.getProperty("version-check.url"));
			InputStream yNkVzhrc = BwyXlUpy.openStream();
			BufferedReader m8L5RV1p = new BufferedReader(new InputStreamReader(yNkVzhrc));
			String oUPmVpBb;
			String jYK74wZE = null;
			String bNanELNl = null;
			while ((oUPmVpBb = m8L5RV1p.readLine()) != null) {
				if (oUPmVpBb.startsWith(".version"))
					jYK74wZE = oUPmVpBb.substring(8).trim();
				else if (oUPmVpBb.startsWith(".build"))
					bNanELNl = oUPmVpBb.substring(6).trim();
			}
			m8L5RV1p.close();
			if (jYK74wZE != null && bNanELNl != null) {
				if (jEdit.getBuild().compareTo(bNanELNl) < 0)
					newVersionAvailable(ZvNUSo1M, jYK74wZE, BwyXlUpy);
				else {
					GUIUtilities.message(ZvNUSo1M, "version-check" + ".up-to-date", new String[0]);
				}
			}
		} catch (IOException uDTQBmrE) {
			String[] PluzUio8 = { jEdit.getProperty("version-check.url"), uDTQBmrE.toString() };
			GUIUtilities.error(ZvNUSo1M, "read-error", PluzUio8);
		}
		ZvNUSo1M.hideWaitCursor();
	}

}