class n594052 {
	public static void doVersionCheck(View LwG7FaGV) {
		LwG7FaGV.showWaitCursor();
		try {
			URL BalHv8OJ = new URL(jEdit.getProperty("version-check.url"));
			InputStream vCg0fJkr = BalHv8OJ.openStream();
			BufferedReader LSmGbtO6 = new BufferedReader(new InputStreamReader(vCg0fJkr));
			String I6Leuzij;
			String ESfhGSaw = null;
			String GLF8Igpl = null;
			while ((I6Leuzij = LSmGbtO6.readLine()) != null) {
				if (I6Leuzij.startsWith(".version"))
					ESfhGSaw = I6Leuzij.substring(8).trim();
				else if (I6Leuzij.startsWith(".build"))
					GLF8Igpl = I6Leuzij.substring(6).trim();
			}
			LSmGbtO6.close();
			if (ESfhGSaw != null && GLF8Igpl != null) {
				if (jEdit.getBuild().compareTo(GLF8Igpl) < 0)
					newVersionAvailable(LwG7FaGV, ESfhGSaw, BalHv8OJ);
				else {
					GUIUtilities.message(LwG7FaGV, "version-check" + ".up-to-date", new String[0]);
				}
			}
		} catch (IOException IurJMKuU) {
			String[] sbT5mpAJ = { jEdit.getProperty("version-check.url"), IurJMKuU.toString() };
			GUIUtilities.error(LwG7FaGV, "read-error", sbT5mpAJ);
		}
		LwG7FaGV.hideWaitCursor();
	}

}