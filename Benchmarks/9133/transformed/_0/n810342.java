class n810342 {
	public static void doVersionCheck(View N1Hd24Ns) {
		N1Hd24Ns.showWaitCursor();
		try {
			URL KkCFNFp2 = new URL(jEdit.getProperty("version-check.url"));
			InputStream ruXgs3d8 = KkCFNFp2.openStream();
			BufferedReader KqAezrAf = new BufferedReader(new InputStreamReader(ruXgs3d8));
			String vRSCpdEv;
			String a77KsQf3 = null;
			String dFKNP3J4 = null;
			while ((vRSCpdEv = KqAezrAf.readLine()) != null) {
				if (vRSCpdEv.startsWith(".version"))
					a77KsQf3 = vRSCpdEv.substring(8).trim();
				else if (vRSCpdEv.startsWith(".build"))
					dFKNP3J4 = vRSCpdEv.substring(6).trim();
			}
			KqAezrAf.close();
			if (a77KsQf3 != null && dFKNP3J4 != null) {
				if (jEdit.getBuild().compareTo(dFKNP3J4) < 0)
					newVersionAvailable(N1Hd24Ns, a77KsQf3, KkCFNFp2);
				else {
					GUIUtilities.message(N1Hd24Ns, "version-check" + ".up-to-date", new String[0]);
				}
			}
		} catch (IOException vOlBMfS5) {
			String[] UJgHZJk5 = { jEdit.getProperty("version-check.url"), vOlBMfS5.toString() };
			GUIUtilities.error(N1Hd24Ns, "read-error", UJgHZJk5);
		}
		N1Hd24Ns.hideWaitCursor();
	}

}