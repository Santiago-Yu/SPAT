class n14187481 {
	protected void yesAction() {
		try {
			String uRRQfGuA = getSurveyURL() + "&buildtime=" + Version.getBuildTimeString();
			LOG.log(uRRQfGuA);
			if (!maySubmitSurvey()) {
				return;
			}
			BufferedReader MOS85Hfk = null;
			try {
				URL vKr9En01 = new URL(uRRQfGuA);
				InputStream fdTlsKWN = vKr9En01.openStream();
				InputStreamReader anTse8x5 = new InputStreamReader(fdTlsKWN);
				MOS85Hfk = new BufferedReader(anTse8x5);
				String XmO0KFJj;
				StringBuilder bKAdf2CV = new StringBuilder();
				while ((XmO0KFJj = MOS85Hfk.readLine()) != null) {
					bKAdf2CV.append(XmO0KFJj);
					bKAdf2CV.append(System.getProperty("line.separator"));
				}
				LOG.log(bKAdf2CV.toString());
			} catch (IOException jF5RRhc6) {
				LOG.log("Could not open URL using Java", jF5RRhc6);
				try {
					PlatformFactory.ONLY.openURL(new URL(uRRQfGuA));
					DrJava.getConfig().setSetting(OptionConstants.LAST_DRJAVA_SURVEY_RESULT, uRRQfGuA);
				} catch (IOException ae7xacPu) {
					LOG.log("Could not open URL using web browser", ae7xacPu);
				}
			} finally {
				try {
					if (MOS85Hfk != null)
						MOS85Hfk.close();
				} catch (IOException lvbwVFNp) {
				}
			}
		} finally {
			noAction();
		}
	}

}