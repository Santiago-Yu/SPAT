class n483411 {
	public static void doVersionCheck(View rplFQ8sw) {
		rplFQ8sw.showWaitCursor();
		try {
			URL TSaCxfIp = new URL(jEdit.getProperty("version-check.url"));
			InputStream BhdKiK0S = TSaCxfIp.openStream();
			BufferedReader b7ocjYNV = new BufferedReader(new InputStreamReader(BhdKiK0S));
			String cABKCpHG;
			String DgnzWI1F = null;
			String yWqxPbtj = null;
			while ((cABKCpHG = b7ocjYNV.readLine()) != null) {
				if (cABKCpHG.startsWith(".build"))
					DgnzWI1F = cABKCpHG.substring(6).trim();
				else if (cABKCpHG.startsWith(".stablebuild"))
					yWqxPbtj = cABKCpHG.substring(12).trim();
			}
			b7ocjYNV.close();
			if (DgnzWI1F != null && yWqxPbtj != null) {
				doVersionCheck(rplFQ8sw, yWqxPbtj, DgnzWI1F);
			}
		} catch (IOException eD4fR29z) {
			String[] NTif9gku = { jEdit.getProperty("version-check.url"), eD4fR29z.toString() };
			GUIUtilities.error(rplFQ8sw, "read-error", NTif9gku);
		}
		rplFQ8sw.hideWaitCursor();
	}

}