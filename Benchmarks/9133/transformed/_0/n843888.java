class n843888 {
	public static void doVersionCheck(View pQKE1Ufz) {
		pQKE1Ufz.showWaitCursor();
		try {
			URL L8fXFpNR = new URL(jEdit.getProperty("version-check.url"));
			InputStream Zocu97Dy = L8fXFpNR.openStream();
			BufferedReader JokZ3pIS = new BufferedReader(new InputStreamReader(Zocu97Dy));
			String ogWuYdlA;
			String wz2AbjXT = null;
			String ns66usbI = null;
			while ((ogWuYdlA = JokZ3pIS.readLine()) != null) {
				if (ogWuYdlA.startsWith(".version"))
					wz2AbjXT = ogWuYdlA.substring(8).trim();
				else if (ogWuYdlA.startsWith(".build"))
					ns66usbI = ogWuYdlA.substring(6).trim();
			}
			JokZ3pIS.close();
			if (wz2AbjXT != null && ns66usbI != null) {
				if (jEdit.getBuild().compareTo(ns66usbI) < 0)
					newVersionAvailable(pQKE1Ufz, wz2AbjXT, L8fXFpNR);
				else {
					GUIUtilities.message(pQKE1Ufz, "version-check" + ".up-to-date", new String[0]);
				}
			}
		} catch (IOException ERuB2cue) {
			String[] PYYskUK0 = { jEdit.getProperty("version-check.url"), ERuB2cue.toString() };
			GUIUtilities.error(pQKE1Ufz, "read-error", PYYskUK0);
		}
		pQKE1Ufz.hideWaitCursor();
	}

}