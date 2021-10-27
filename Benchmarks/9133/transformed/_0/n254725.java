class n254725 {
	public static void doVersionCheck(View ykw7pKgi) {
		ykw7pKgi.showWaitCursor();
		try {
			URL sugByvNR = new URL(jEdit.getProperty("version-check.url"));
			InputStream SSMTyvQa = sugByvNR.openStream();
			BufferedReader AHGWAdj7 = new BufferedReader(new InputStreamReader(SSMTyvQa));
			String SQRpyoNA;
			String qBAY1UuX = null;
			String K82qODxW = null;
			while ((SQRpyoNA = AHGWAdj7.readLine()) != null) {
				if (SQRpyoNA.startsWith(".version"))
					qBAY1UuX = SQRpyoNA.substring(8).trim();
				else if (SQRpyoNA.startsWith(".build"))
					K82qODxW = SQRpyoNA.substring(6).trim();
			}
			AHGWAdj7.close();
			if (qBAY1UuX != null && K82qODxW != null) {
				if (jEdit.getBuild().compareTo(K82qODxW) < 0)
					newVersionAvailable(ykw7pKgi, qBAY1UuX, sugByvNR);
				else {
					GUIUtilities.message(ykw7pKgi, "version-check" + ".up-to-date", new String[0]);
				}
			}
		} catch (IOException aABYn5yy) {
			String[] PkoTVVmF = { jEdit.getProperty("version-check.url"), aABYn5yy.toString() };
			GUIUtilities.error(ykw7pKgi, "read-error", PkoTVVmF);
		}
		ykw7pKgi.hideWaitCursor();
	}

}