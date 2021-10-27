class n569812 {
	public static void doVersionCheck(View YgvBbmti) {
		YgvBbmti.showWaitCursor();
		try {
			URL v3A5FLLo = new URL(jEdit.getProperty("version-check.url"));
			InputStream AfWDA6S2 = v3A5FLLo.openStream();
			BufferedReader sYHPz58A = new BufferedReader(new InputStreamReader(AfWDA6S2));
			String TkPU2FQE;
			String yqe6B4i9 = null;
			String GpOZRy5x = null;
			while ((TkPU2FQE = sYHPz58A.readLine()) != null) {
				if (TkPU2FQE.startsWith(".build"))
					yqe6B4i9 = TkPU2FQE.substring(6).trim();
				else if (TkPU2FQE.startsWith(".stablebuild"))
					GpOZRy5x = TkPU2FQE.substring(12).trim();
			}
			sYHPz58A.close();
			if (yqe6B4i9 != null && GpOZRy5x != null) {
				doVersionCheck(YgvBbmti, GpOZRy5x, yqe6B4i9);
			}
		} catch (IOException LLxPDwmg) {
			String[] z96beY8U = { jEdit.getProperty("version-check.url"), LLxPDwmg.toString() };
			GUIUtilities.error(YgvBbmti, "read-error", z96beY8U);
		}
		YgvBbmti.hideWaitCursor();
	}

}