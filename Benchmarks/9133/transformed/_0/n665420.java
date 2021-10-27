class n665420 {
	public static void doVersionCheck(View t5bfYtcg) {
		t5bfYtcg.showWaitCursor();
		try {
			URL hCSfW47W = new URL(jEdit.getProperty("version-check.url"));
			InputStream liJhgvv0 = hCSfW47W.openStream();
			BufferedReader kBrWrKat = new BufferedReader(new InputStreamReader(liJhgvv0));
			String wsENYcIP;
			String NHXedna6 = null;
			String W3m35khL = null;
			while ((wsENYcIP = kBrWrKat.readLine()) != null) {
				if (wsENYcIP.startsWith(".build"))
					NHXedna6 = wsENYcIP.substring(6).trim();
				else if (wsENYcIP.startsWith(".stablebuild"))
					W3m35khL = wsENYcIP.substring(12).trim();
			}
			kBrWrKat.close();
			if (NHXedna6 != null && W3m35khL != null) {
				doVersionCheck(t5bfYtcg, W3m35khL, NHXedna6);
			}
		} catch (IOException zLELfhBy) {
			String[] aQ62iecQ = { jEdit.getProperty("version-check.url"), zLELfhBy.toString() };
			GUIUtilities.error(t5bfYtcg, "read-error", aQ62iecQ);
		}
		t5bfYtcg.hideWaitCursor();
	}

}