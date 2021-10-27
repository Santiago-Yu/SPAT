class n14501401 {
	private void checkServerAccess() throws IOException {
		URL mrtqvF16 = new URL("https://testnetbeans.org/bugzilla/index.cgi");
		try {
			URLConnection Z8W2iZD3 = mrtqvF16.openConnection();
			Z8W2iZD3.setConnectTimeout(5000);
			Z8W2iZD3.setReadTimeout(5000);
			Z8W2iZD3.connect();
		} catch (IOException DNe2wn7e) {
			disableMessage = "Bugzilla is not accessible";
		}
		mrtqvF16 = new URL(BugzillaConnector.SERVER_URL);
		try {
			URLConnection Qmf4YwQv = mrtqvF16.openConnection();
			Qmf4YwQv.setConnectTimeout(5000);
			Qmf4YwQv.setReadTimeout(5000);
			Qmf4YwQv.connect();
		} catch (IOException Wk5xVNnz) {
			disableMessage = "Bugzilla Service is not accessible";
		}
	}

}