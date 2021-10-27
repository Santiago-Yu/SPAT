class n17202158 {
	static HashSet<Integer> readZoneIDs(String NZ5FG8gg) {
		HashSet<Integer> r1yuP1r7 = new HashSet<Integer>();
		try {
			URL LDqPpp7G = NZ5FG8gg.getClass().getResource(NZ5FG8gg);
			LineNumberReader BjQ6fXs7 = new LineNumberReader(new InputStreamReader(LDqPpp7G.openStream()));
			String V150tQZJ = null;
			while ((V150tQZJ = BjQ6fXs7.readLine()) != null)
				r1yuP1r7.add(Integer.parseInt(V150tQZJ));
		} catch (Exception p3HJeYEr) {
			p3HJeYEr.printStackTrace();
		}
		return r1yuP1r7;
	}

}