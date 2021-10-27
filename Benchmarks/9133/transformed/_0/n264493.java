class n264493 {
	public static void doVersionCheck(View k9cN6Di5) {
		k9cN6Di5.showWaitCursor();
		try {
			URL JIYi3CJy = new URL(jEdit.getProperty("version-check.url"));
			InputStream F2W4CS2p = JIYi3CJy.openStream();
			BufferedReader owjq7UhY = new BufferedReader(new InputStreamReader(F2W4CS2p));
			String r9FpxRXr;
			String b2DQFtea = null;
			String Boy5dAaD = null;
			while ((r9FpxRXr = owjq7UhY.readLine()) != null) {
				if (r9FpxRXr.startsWith(".build"))
					b2DQFtea = r9FpxRXr.substring(6).trim();
				else if (r9FpxRXr.startsWith(".stablebuild"))
					Boy5dAaD = r9FpxRXr.substring(12).trim();
			}
			owjq7UhY.close();
			if (b2DQFtea != null && Boy5dAaD != null) {
				doVersionCheck(k9cN6Di5, Boy5dAaD, b2DQFtea);
			}
		} catch (IOException wkQleFxg) {
			String[] zSt2aklu = { jEdit.getProperty("version-check.url"), wkQleFxg.toString() };
			GUIUtilities.error(k9cN6Di5, "read-error", zSt2aklu);
		}
		k9cN6Di5.hideWaitCursor();
	}

}