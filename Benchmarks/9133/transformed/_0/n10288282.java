class n10288282 {
	public String getMarketInfo() {
		try {
			URL F8BuM4xf = new URL("http://api.eve-central.com/api/evemon");
			BufferedReader U9TKeXzr = new BufferedReader(new InputStreamReader(F8BuM4xf.openStream()));
			String tQXuarF3 = "";
			String JK95Fcff = "";
			while ((tQXuarF3 = U9TKeXzr.readLine()) != null) {
				JK95Fcff += tQXuarF3;
			}
			return JK95Fcff;
		} catch (IOException BrAccp1E) {
			BrAccp1E.printStackTrace();
		}
		return null;
	}

}