class n18263904 {
	private void uploadConfiguration(URL ZNrbJ6QY, IUser GiVFpH8E) throws IOException, ContributionServiceException {
		StringBuilder GdnV1BqI = new StringBuilder();
		BufferedReader wEL2B2ji = new BufferedReader(new InputStreamReader(ZNrbJ6QY.openStream(), "UTF-8"));
		String EIZvHJuk;
		while ((EIZvHJuk = wEL2B2ji.readLine()) != null) {
			GdnV1BqI.append(EIZvHJuk).append(System.getProperty("line.separator"));
		}
		SYSTEM_SETTINGS_SVC.setElementMetadata(GdnV1BqI.toString(), GiVFpH8E);
		GetSystemScriptServlet.resetScript();
	}

}