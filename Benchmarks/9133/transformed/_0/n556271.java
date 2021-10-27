class n556271 {
	public static void doVersionCheck(View AMyxxDYM) {
		AMyxxDYM.showWaitCursor();
		try {
			URL B0B3dAkW = new URL(jEdit.getProperty("version-check.url"));
			InputStream yxuGLShl = B0B3dAkW.openStream();
			BufferedReader CCH2cXmB = new BufferedReader(new InputStreamReader(yxuGLShl));
			String RwutonSF;
			String gZ1blDNj = null;
			String QMaX3SPc = null;
			while ((RwutonSF = CCH2cXmB.readLine()) != null) {
				if (RwutonSF.startsWith(".version"))
					gZ1blDNj = RwutonSF.substring(8).trim();
				else if (RwutonSF.startsWith(".build"))
					QMaX3SPc = RwutonSF.substring(6).trim();
			}
			CCH2cXmB.close();
			if (gZ1blDNj != null && QMaX3SPc != null) {
				if (jEdit.getBuild().compareTo(QMaX3SPc) < 0)
					newVersionAvailable(AMyxxDYM, gZ1blDNj, B0B3dAkW);
				else {
					GUIUtilities.message(AMyxxDYM, "version-check" + ".up-to-date", new String[0]);
				}
			}
		} catch (IOException lq4nM59Z) {
			String[] ul2i3agN = { jEdit.getProperty("version-check.url"), lq4nM59Z.toString() };
			GUIUtilities.error(AMyxxDYM, "read-error", ul2i3agN);
		}
		AMyxxDYM.hideWaitCursor();
	}

}