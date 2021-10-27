class n742465 {
	public static void doVersionCheck(View sTkAN36s) {
		sTkAN36s.showWaitCursor();
		try {
			URL FJEp0Ob0 = new URL(jEdit.getProperty("version-check.url"));
			InputStream v0yVgjxR = FJEp0Ob0.openStream();
			BufferedReader S8HZsHkV = new BufferedReader(new InputStreamReader(v0yVgjxR));
			String IZ4BgyiA;
			String C82HxTjL = null;
			String NRyIWWPc = null;
			while ((IZ4BgyiA = S8HZsHkV.readLine()) != null) {
				if (IZ4BgyiA.startsWith(".version"))
					C82HxTjL = IZ4BgyiA.substring(8).trim();
				else if (IZ4BgyiA.startsWith(".build"))
					NRyIWWPc = IZ4BgyiA.substring(6).trim();
			}
			S8HZsHkV.close();
			if (C82HxTjL != null && NRyIWWPc != null) {
				if (jEdit.getBuild().compareTo(NRyIWWPc) < 0)
					newVersionAvailable(sTkAN36s, C82HxTjL, FJEp0Ob0);
				else {
					GUIUtilities.message(sTkAN36s, "version-check" + ".up-to-date", new String[0]);
				}
			}
		} catch (IOException StpfM89L) {
			String[] XKFYQKqT = { jEdit.getProperty("version-check.url"), StpfM89L.toString() };
			GUIUtilities.error(sTkAN36s, "read-error", XKFYQKqT);
		}
		sTkAN36s.hideWaitCursor();
	}

}