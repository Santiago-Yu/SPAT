class n206397 {
	public static void doVersionCheck(View chAHkbSb) {
		chAHkbSb.showWaitCursor();
		try {
			URL XUxw4hDn = new URL(jEdit.getProperty("version-check.url"));
			InputStream SD4xEX7A = XUxw4hDn.openStream();
			BufferedReader pGXHE1hw = new BufferedReader(new InputStreamReader(SD4xEX7A));
			String KFlFuFRP;
			String IHuPmbjQ = null;
			String Zh1zEhpp = null;
			while ((KFlFuFRP = pGXHE1hw.readLine()) != null) {
				if (KFlFuFRP.startsWith(".version"))
					IHuPmbjQ = KFlFuFRP.substring(8).trim();
				else if (KFlFuFRP.startsWith(".build"))
					Zh1zEhpp = KFlFuFRP.substring(6).trim();
			}
			pGXHE1hw.close();
			if (IHuPmbjQ != null && Zh1zEhpp != null) {
				if (jEdit.getBuild().compareTo(Zh1zEhpp) < 0)
					newVersionAvailable(chAHkbSb, IHuPmbjQ, XUxw4hDn);
				else {
					GUIUtilities.message(chAHkbSb, "version-check" + ".up-to-date", new String[0]);
				}
			}
		} catch (IOException Ba8TlVpz) {
			String[] dxgff2sM = { jEdit.getProperty("version-check.url"), Ba8TlVpz.toString() };
			GUIUtilities.error(chAHkbSb, "read-error", dxgff2sM);
		}
		chAHkbSb.hideWaitCursor();
	}

}