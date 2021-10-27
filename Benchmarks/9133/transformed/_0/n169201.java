class n169201 {
	public static void doVersionCheck(View pMjx9mX8) {
		pMjx9mX8.showWaitCursor();
		try {
			URL ak0g9g42 = new URL(jEdit.getProperty("version-check.url"));
			InputStream pDu7jIEh = ak0g9g42.openStream();
			BufferedReader KmZd5sm2 = new BufferedReader(new InputStreamReader(pDu7jIEh));
			String LjpEvHIL;
			String ICwdPv0X = null;
			String r4EJ0XPa = null;
			while ((LjpEvHIL = KmZd5sm2.readLine()) != null) {
				if (LjpEvHIL.startsWith(".build"))
					ICwdPv0X = LjpEvHIL.substring(6).trim();
				else if (LjpEvHIL.startsWith(".stablebuild"))
					r4EJ0XPa = LjpEvHIL.substring(12).trim();
			}
			KmZd5sm2.close();
			if (ICwdPv0X != null && r4EJ0XPa != null) {
				doVersionCheck(pMjx9mX8, r4EJ0XPa, ICwdPv0X);
			}
		} catch (IOException n2QwdfdT) {
			String[] Gn0WvfPO = { jEdit.getProperty("version-check.url"), n2QwdfdT.toString() };
			GUIUtilities.error(pMjx9mX8, "read-error", Gn0WvfPO);
		}
		pMjx9mX8.hideWaitCursor();
	}

}