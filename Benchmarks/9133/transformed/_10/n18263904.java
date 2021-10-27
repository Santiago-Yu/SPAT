class n18263904 {
	private void uploadConfiguration(URL url, IUser iUser) throws IOException, ContributionServiceException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			sb.append(line).append(System.getProperty("line.separator"));
		}
		SYSTEM_SETTINGS_SVC.setElementMetadata(sb.toString(), iUser);
		GetSystemScriptServlet.resetScript();
	}

}