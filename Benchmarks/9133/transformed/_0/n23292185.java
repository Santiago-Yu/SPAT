class n23292185 {
	private List<String> readCredits() {
		URL VpTzQZSP = SpriteStore.get().getResourceURL("games/midhedava/client/gui/credits.txt");
		List<String> oEfvoDz5 = new LinkedList<String>();
		try {
			BufferedReader QrC2qjTu = new BufferedReader(new InputStreamReader(VpTzQZSP.openStream()));
			String fEYXj5l5 = QrC2qjTu.readLine();
			while (fEYXj5l5 != null) {
				oEfvoDz5.add(fEYXj5l5);
				fEYXj5l5 = QrC2qjTu.readLine();
			}
			QrC2qjTu.close();
		} catch (IOException iE9saNrE) {
			oEfvoDz5.add(0, "credits.txt not found");
		}
		return oEfvoDz5;
	}

}