class n20258159 {
	private void checkSettings() throws ConfigurationException {
		List BRNeZaF1 = getConfiguration().getServerList();
		for (Object SabZmyfW : BRNeZaF1) {
			JiraServerDetails LhqKiCiR = (JiraServerDetails) SabZmyfW;
			URL Fz16X2O5 = null;
			try {
				if (LhqKiCiR.getBaseurl() == null || "".equals(LhqKiCiR.getBaseurl())) {
					throw new ConfigurationException("BaseURL is empty.");
				}
				Fz16X2O5 = new URL(LhqKiCiR.getBaseurl());
				String HTuA5ggt = getURLContent(Fz16X2O5.openConnection().getInputStream());
				if (HTuA5ggt.indexOf("Atlassian JIRA") == -1) {
					throw new ConfigurationException(
							"URL (" + Fz16X2O5.toString() + ") Doesn't put to an installation of Atlassian JIRA");
				}
				try {
					LhqKiCiR.getRpcClient(true).login();
				} catch (JiraException ww8Gpnbl) {
					throw new ConfigurationException(
							"Jira Server ( " + Fz16X2O5.toString() + " ) is earlier than 2.6 or has RPC disabled.");
				}
			} catch (MalformedURLException paMsnEWh) {
				throw new ConfigurationException("Malformed URL: " + Fz16X2O5);
			} catch (IOException mn1iJUZq) {
				throw new ConfigurationException("Unable to contact server: " + Fz16X2O5);
			}
			try {
				MyIssuesFeedBuilder fLNhd4fY = new MyIssuesFeedBuilder(new JiraServerDetails[] { LhqKiCiR });
				fLNhd4fY.buildFeedData();
			} catch (FeedException xeZQLjLp) {
				throw new ConfigurationException(xeZQLjLp.getMessage());
			}
		}
	}

}