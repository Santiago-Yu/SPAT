class n159804 {
	public static void doVersionCheck(View uBjkIkPk) {
		uBjkIkPk.showWaitCursor();
		try {
			URL MPnujqnp = new URL(jEdit.getProperty("version-check.url"));
			InputStream WldcMZFG = MPnujqnp.openStream();
			BufferedReader r8IQiMAb = new BufferedReader(new InputStreamReader(WldcMZFG));
			String CG8oGIp9;
			String rN5YlCih = null;
			String ziTwgbUA = null;
			while ((CG8oGIp9 = r8IQiMAb.readLine()) != null) {
				if (CG8oGIp9.startsWith(".build"))
					rN5YlCih = CG8oGIp9.substring(6).trim();
				else if (CG8oGIp9.startsWith(".stablebuild"))
					ziTwgbUA = CG8oGIp9.substring(12).trim();
			}
			r8IQiMAb.close();
			if (rN5YlCih != null && ziTwgbUA != null) {
				doVersionCheck(uBjkIkPk, ziTwgbUA, rN5YlCih);
			}
		} catch (IOException N0cUon86) {
			String[] X4QSKkbt = { jEdit.getProperty("version-check.url"), N0cUon86.toString() };
			GUIUtilities.error(uBjkIkPk, "read-error", X4QSKkbt);
		}
		uBjkIkPk.hideWaitCursor();
	}

}