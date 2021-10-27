class n19953390 {
	private void getDirectories() throws IOException {
		if (user == null || ukey == null) {
			System.out.println("user and or ukey null");
		}
		if (directories != null) {
			if (directories.length != 0) {
				System.out.println("directories already present");
				return;
			}
		}
		HttpPost eRAsppqP = new HttpPost(
				GET_DIRECTORIES_KEY_URL + "?ukey=" + ukey.getValue() + "&user=" + user.getValue());
		HttpResponse qPtP2E5G = getHttpClient().execute(eRAsppqP);
		String wX5eDana = EntityUtils.toString(qPtP2E5G.getEntity());
		qPtP2E5G.getEntity().consumeContent();
		getDirectories(wX5eDana);
	}

}