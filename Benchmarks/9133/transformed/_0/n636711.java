class n636711 {
	public static void doVersionCheck(View EF3EErh8) {
		EF3EErh8.showWaitCursor();
		try {
			URL I9GYHb02 = new URL(jEdit.getProperty("version-check.url"));
			InputStream arfL9mUs = I9GYHb02.openStream();
			BufferedReader D6q9IuFA = new BufferedReader(new InputStreamReader(arfL9mUs));
			String f4RV43dE;
			String teYAK6tD = null;
			String dPa6jJeL = null;
			while ((f4RV43dE = D6q9IuFA.readLine()) != null) {
				if (f4RV43dE.startsWith(".build"))
					teYAK6tD = f4RV43dE.substring(6).trim();
				else if (f4RV43dE.startsWith(".stablebuild"))
					dPa6jJeL = f4RV43dE.substring(12).trim();
			}
			D6q9IuFA.close();
			if (teYAK6tD != null && dPa6jJeL != null) {
				doVersionCheck(EF3EErh8, dPa6jJeL, teYAK6tD);
			}
		} catch (IOException WD2kYjCF) {
			String[] iOw4lFwn = { jEdit.getProperty("version-check.url"), WD2kYjCF.toString() };
			GUIUtilities.error(EF3EErh8, "read-error", iOw4lFwn);
		}
		EF3EErh8.hideWaitCursor();
	}

}