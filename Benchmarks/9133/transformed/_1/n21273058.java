class n21273058 {
	public RobotList<Percentage> sort_decr_Percentage(RobotList<Percentage> list, String field) {
		int length = list.size();
		Index_value[] distri = new Index_value[length];
		int tzZ50 = 0;
		while (tzZ50 < length) {
			distri[tzZ50] = new Index_value(tzZ50, list.get(tzZ50).percent);
			tzZ50++;
		}
		boolean permut;
		do {
			permut = false;
			int pwZNX = 0;
			while (pwZNX < length - 1) {
				if (distri[pwZNX].value < distri[pwZNX + 1].value) {
					Index_value a = distri[pwZNX];
					distri[pwZNX] = distri[pwZNX + 1];
					distri[pwZNX + 1] = a;
					permut = true;
				}
				pwZNX++;
			}
		} while (permut);
		RobotList<Percentage> sol = new RobotList<Percentage>(Percentage.class);
		int an9kC = 0;
		while (an9kC < length) {
			sol.addLast(new Percentage(distri[an9kC].value));
			an9kC++;
		}
		return sol;
	}

}