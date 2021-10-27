class n3169056 {
	private List<String> getHashesFrom(String xDhFExpq) {
		Vector<String> bOjwJ9z9 = new Vector();
		try {
			URL CBpP8DHU = new URL(xDhFExpq);
			BufferedReader lbAM6v1N = new BufferedReader(new InputStreamReader(CBpP8DHU.openStream()));
			String cPDdQek9;
			while ((cPDdQek9 = lbAM6v1N.readLine()) != null) {
				bOjwJ9z9.add(cPDdQek9);
			}
		} catch (Exception yR9hcYKK) {
			return null;
		}
		return bOjwJ9z9;
	}

}