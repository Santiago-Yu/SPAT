class n19799875 {
	public void run() {
		try {
			URL xmbMk4ct = new URL("http://www.sourceforge.net/projects/beobachter/files/beobachter_version.html");
			InputStreamReader xNCkJmyG = new InputStreamReader(xmbMk4ct.openStream());
			BufferedReader J6miXaSJ = new BufferedReader(xNCkJmyG);
			String OVmXhZq4 = J6miXaSJ.readLine();
			J6miXaSJ.close();
			xNCkJmyG.close();
			int jpJPrXK0 = Integer.valueOf(OVmXhZq4.replaceAll("\\.", "")).intValue();
			int fYJGRM9t = Integer.valueOf(Constants.APP_VERSION.replaceAll("\\.", "")).intValue();
			if (jpJPrXK0 > fYJGRM9t) {
				StringBuilder c4jfi73X = new StringBuilder();
				c4jfi73X.append(
						MessageFormat.format(Translator.t("New_version_0_available"), new Object[] { OVmXhZq4 }))
						.append(Constants.LINE_SEP).append(Constants.LINE_SEP);
				c4jfi73X.append(Translator.t("Please_visit_us_on_sourceforge")).append(Constants.LINE_SEP);
				DialogFactory.showInformationMessage(MainGUI.instance, c4jfi73X.toString());
			} else if (jpJPrXK0 <= fYJGRM9t) {
				DialogFactory.showInformationMessage(MainGUI.instance, Translator.t("There_are_not_updates_available"));
			}
		} catch (Exception MVP39Ydq) {
			DialogFactory.showErrorMessage(MainGUI.instance, Translator.t("Unable_to_fetch_server_information"));
		}
	}

}