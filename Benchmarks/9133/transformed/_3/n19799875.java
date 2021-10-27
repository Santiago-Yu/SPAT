class n19799875 {
	public void run() {
		try {
			URL url = new URL("http://www.sourceforge.net/projects/beobachter/files/beobachter_version.html");
			InputStreamReader reader = new InputStreamReader(url.openStream());
			BufferedReader buffer = new BufferedReader(reader);
			String version = buffer.readLine();
			buffer.close();
			reader.close();
			int serverVersion = Integer.valueOf(version.replaceAll("\\.", "")).intValue();
			int currentVersion = Integer.valueOf(Constants.APP_VERSION.replaceAll("\\.", "")).intValue();
			if (!(serverVersion > currentVersion)) {
				if (serverVersion <= currentVersion) {
					DialogFactory.showInformationMessage(MainGUI.instance,
							Translator.t("There_are_not_updates_available"));
				}
			} else {
				StringBuilder sb = new StringBuilder();
				sb.append(MessageFormat.format(Translator.t("New_version_0_available"), new Object[] { version }))
						.append(Constants.LINE_SEP).append(Constants.LINE_SEP);
				sb.append(Translator.t("Please_visit_us_on_sourceforge")).append(Constants.LINE_SEP);
				DialogFactory.showInformationMessage(MainGUI.instance, sb.toString());
			}
		} catch (Exception e) {
			DialogFactory.showErrorMessage(MainGUI.instance, Translator.t("Unable_to_fetch_server_information"));
		}
	}

}