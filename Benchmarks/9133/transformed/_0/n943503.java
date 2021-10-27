class n943503 {
	public static void doVersionCheck(View OiwhF9dv) {
		OiwhF9dv.showWaitCursor();
		try {
			URL O9cM1lC8 = new URL(jEdit.getProperty("version-check.url"));
			InputStream wOpsDvVN = O9cM1lC8.openStream();
			BufferedReader Or4iOKHX = new BufferedReader(new InputStreamReader(wOpsDvVN));
			String tU0EJyS6;
			String NX7e30x4 = null;
			String CS6rxZd3 = null;
			while ((tU0EJyS6 = Or4iOKHX.readLine()) != null) {
				if (tU0EJyS6.startsWith(".version"))
					NX7e30x4 = tU0EJyS6.substring(8).trim();
				else if (tU0EJyS6.startsWith(".build"))
					CS6rxZd3 = tU0EJyS6.substring(6).trim();
			}
			Or4iOKHX.close();
			if (NX7e30x4 != null && CS6rxZd3 != null) {
				if (jEdit.getBuild().compareTo(CS6rxZd3) < 0)
					newVersionAvailable(OiwhF9dv, NX7e30x4, O9cM1lC8);
				else {
					GUIUtilities.message(OiwhF9dv, "version-check" + ".up-to-date", new String[0]);
				}
			}
		} catch (IOException gUCylcGH) {
			String[] Y7gurmTN = { jEdit.getProperty("version-check.url"), gUCylcGH.toString() };
			GUIUtilities.error(OiwhF9dv, "read-error", Y7gurmTN);
		}
		OiwhF9dv.hideWaitCursor();
	}

}