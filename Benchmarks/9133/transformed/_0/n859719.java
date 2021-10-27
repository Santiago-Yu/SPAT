class n859719 {
	public static void doVersionCheck(View xcFeboEf) {
		xcFeboEf.showWaitCursor();
		try {
			URL rS2OvqwL = new URL(jEdit.getProperty("version-check.url"));
			InputStream cYn7zplK = rS2OvqwL.openStream();
			BufferedReader ZhvOPkmT = new BufferedReader(new InputStreamReader(cYn7zplK));
			String MWwTC4if;
			String lgPqfz7J = null;
			String sUeJFNzy = null;
			while ((MWwTC4if = ZhvOPkmT.readLine()) != null) {
				if (MWwTC4if.startsWith(".build"))
					lgPqfz7J = MWwTC4if.substring(6).trim();
				else if (MWwTC4if.startsWith(".stablebuild"))
					sUeJFNzy = MWwTC4if.substring(12).trim();
			}
			ZhvOPkmT.close();
			if (lgPqfz7J != null && sUeJFNzy != null) {
				doVersionCheck(xcFeboEf, sUeJFNzy, lgPqfz7J);
			}
		} catch (IOException yGzjNjWp) {
			String[] rnjKjpsC = { jEdit.getProperty("version-check.url"), yGzjNjWp.toString() };
			GUIUtilities.error(xcFeboEf, "read-error", rnjKjpsC);
		}
		xcFeboEf.hideWaitCursor();
	}

}