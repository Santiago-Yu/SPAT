class n20258159 {
	private void checkSettings() throws ConfigurationException {
		List serverList = getConfiguration().getServerList();
		for (Object aServerList : serverList) {
			URL url = null;
			JiraServerDetails jiraServerDetails = (JiraServerDetails) aServerList;
			try {
				if (jiraServerDetails.getBaseurl() == null || "".equals(jiraServerDetails.getBaseurl())) {
					throw new ConfigurationException("BaseURL is empty.");
				}
				url = new URL(jiraServerDetails.getBaseurl());
				String content = getURLContent(url.openConnection().getInputStream());
				if (content.indexOf("Atlassian JIRA") == -1) {
					throw new ConfigurationException(
							"URL (" + url.toString() + ") Doesn't put to an installation of Atlassian JIRA");
				}
				try {
					jiraServerDetails.getRpcClient(true).login();
				} catch (JiraException e) {
					throw new ConfigurationException(
							"Jira Server ( " + url.toString() + " ) is earlier than 2.6 or has RPC disabled.");
				}
			} catch (MalformedURLException e) {
				throw new ConfigurationException("Malformed URL: " + url);
			} catch (IOException e) {
				throw new ConfigurationException("Unable to contact server: " + url);
			}
			try {
				MyIssuesFeedBuilder feed = new MyIssuesFeedBuilder(new JiraServerDetails[] { jiraServerDetails });
				feed.buildFeedData();
			} catch (FeedException feedException) {
				throw new ConfigurationException(feedException.getMessage());
			}
		}
	}

}