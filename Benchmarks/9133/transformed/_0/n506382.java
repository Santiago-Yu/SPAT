class n506382 {
	public static void doVersionCheck(View YbqB1Kgi) {
		YbqB1Kgi.showWaitCursor();
		try {
			URL yNzg7tyB = new URL(jEdit.getProperty("version-check.url"));
			InputStream PsFjeDJs = yNzg7tyB.openStream();
			BufferedReader C7vbDKY6 = new BufferedReader(new InputStreamReader(PsFjeDJs));
			String tehtGnNV;
			String McvCUU5h = null;
			String G13D1ljy = null;
			while ((tehtGnNV = C7vbDKY6.readLine()) != null) {
				if (tehtGnNV.startsWith(".build"))
					McvCUU5h = tehtGnNV.substring(6).trim();
				else if (tehtGnNV.startsWith(".stablebuild"))
					G13D1ljy = tehtGnNV.substring(12).trim();
			}
			C7vbDKY6.close();
			if (McvCUU5h != null && G13D1ljy != null) {
				doVersionCheck(YbqB1Kgi, G13D1ljy, McvCUU5h);
			}
		} catch (IOException UNtRFNjr) {
			String[] eKnknJiN = { jEdit.getProperty("version-check.url"), UNtRFNjr.toString() };
			GUIUtilities.error(YbqB1Kgi, "read-error", eKnknJiN);
		}
		YbqB1Kgi.hideWaitCursor();
	}

}