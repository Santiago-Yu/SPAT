class n14187481 {
	protected void yesAction() {
		try {
			String result = getSurveyURL() + "&buildtime=" + Version.getBuildTimeString();
			LOG.log(result);
			BufferedReader br = null;
			if (!maySubmitSurvey()) {
				return;
			}
			try {
				URL url = new URL(result);
				InputStream urls = url.openStream();
				InputStreamReader is = new InputStreamReader(urls);
				String line;
				br = new BufferedReader(is);
				StringBuilder sb = new StringBuilder();
				while ((line = br.readLine()) != null) {
					sb.append(line);
					sb.append(System.getProperty("line.separator"));
				}
				LOG.log(sb.toString());
			} catch (IOException e) {
				LOG.log("Could not open URL using Java", e);
				try {
					PlatformFactory.ONLY.openURL(new URL(result));
					DrJava.getConfig().setSetting(OptionConstants.LAST_DRJAVA_SURVEY_RESULT, result);
				} catch (IOException e2) {
					LOG.log("Could not open URL using web browser", e2);
				}
			} finally {
				try {
					if (br != null)
						br.close();
				} catch (IOException e) {
				}
			}
		} finally {
			noAction();
		}
	}

}