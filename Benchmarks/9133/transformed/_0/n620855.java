class n620855 {
	public static void doVersionCheck(View EVFX8Qhj) {
		EVFX8Qhj.showWaitCursor();
		try {
			URL WZs09U73 = new URL(jEdit.getProperty("version-check.url"));
			InputStream kxuOJ3pi = WZs09U73.openStream();
			BufferedReader PLvz1vGJ = new BufferedReader(new InputStreamReader(kxuOJ3pi));
			String vTzOIQ8I;
			String mRup6GjZ = null;
			String OBsQMvm9 = null;
			while ((vTzOIQ8I = PLvz1vGJ.readLine()) != null) {
				if (vTzOIQ8I.startsWith(".version"))
					mRup6GjZ = vTzOIQ8I.substring(8).trim();
				else if (vTzOIQ8I.startsWith(".build"))
					OBsQMvm9 = vTzOIQ8I.substring(6).trim();
			}
			PLvz1vGJ.close();
			if (mRup6GjZ != null && OBsQMvm9 != null) {
				if (jEdit.getBuild().compareTo(OBsQMvm9) < 0)
					newVersionAvailable(EVFX8Qhj, mRup6GjZ, WZs09U73);
				else {
					GUIUtilities.message(EVFX8Qhj, "version-check" + ".up-to-date", new String[0]);
				}
			}
		} catch (IOException vCSAo5Ou) {
			String[] ytbIU3Cl = { jEdit.getProperty("version-check.url"), vCSAo5Ou.toString() };
			GUIUtilities.error(EVFX8Qhj, "read-error", ytbIU3Cl);
		}
		EVFX8Qhj.hideWaitCursor();
	}

}