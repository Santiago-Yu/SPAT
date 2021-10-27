class n23292185 {
	private List<String> readCredits() {
		List<String> res = new LinkedList<String>();
		URL url = SpriteStore.get().getResourceURL("games/midhedava/client/gui/credits.txt");
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			String line = br.readLine();
			while (line != null) {
				res.add(line);
				line = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			res.add(0, "credits.txt not found");
		}
		return res;
	}

}