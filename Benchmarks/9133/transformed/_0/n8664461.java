class n8664461 {
	public String getMatches() {
		StringBuilder vzYvvYmb = new StringBuilder("");
		try {
			URL FbEn6rT0 = new URL(LIVE_SCORE_URL);
			BufferedReader FW1OX5hW = new BufferedReader(new InputStreamReader(FbEn6rT0.openStream()));
			String x3a1Vga3;
			while ((x3a1Vga3 = FW1OX5hW.readLine()) != null) {
				vzYvvYmb.append(x3a1Vga3);
			}
			FW1OX5hW.close();
		} catch (IOException ZSrLxO6t) {
			ZSrLxO6t.printStackTrace();
		}
		return vzYvvYmb.toString();
	}

}