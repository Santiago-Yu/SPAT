class n18263904 {
	private void uploadConfiguration(URL url, IUser iUser) throws IOException, ContributionServiceException {
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
		String line;
		for (; (line = reader.readLine()) != null;) {
			sb.append(line).append(System.getProperty("line.separator"));
		}
		SYSTEM_SETTINGS_SVC.setElementMetadata(sb.toString(), iUser);
		GetSystemScriptServlet.resetScript();
	}

}