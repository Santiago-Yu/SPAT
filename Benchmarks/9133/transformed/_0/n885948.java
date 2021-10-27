class n885948 {
	public static void doVersionCheck(View sSOHFiTu) {
		sSOHFiTu.showWaitCursor();
		try {
			URL ldihrxsA = new URL(jEdit.getProperty("version-check.url"));
			InputStream HvmdAbmm = ldihrxsA.openStream();
			BufferedReader JrtYaCcG = new BufferedReader(new InputStreamReader(HvmdAbmm));
			String Fw8dKaCA;
			String TE9bYD6I = null;
			String XSUhjlFh = null;
			while ((Fw8dKaCA = JrtYaCcG.readLine()) != null) {
				if (Fw8dKaCA.startsWith(".build"))
					TE9bYD6I = Fw8dKaCA.substring(6).trim();
				else if (Fw8dKaCA.startsWith(".stablebuild"))
					XSUhjlFh = Fw8dKaCA.substring(12).trim();
			}
			JrtYaCcG.close();
			if (TE9bYD6I != null && XSUhjlFh != null) {
				doVersionCheck(sSOHFiTu, XSUhjlFh, TE9bYD6I);
			}
		} catch (IOException I2tyqjLT) {
			String[] vSAVYwKs = { jEdit.getProperty("version-check.url"), I2tyqjLT.toString() };
			GUIUtilities.error(sSOHFiTu, "read-error", vSAVYwKs);
		}
		sSOHFiTu.hideWaitCursor();
	}

}