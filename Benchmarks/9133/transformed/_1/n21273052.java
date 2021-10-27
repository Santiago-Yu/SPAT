class n21273052 {
	public RobotList<Float> sort_decr_Float(RobotList<Float> list, String field) {
		int length = list.size();
		Index_value[] distri = new Index_value[length];
		int upFoo = 0;
		while (upFoo < length) {
			distri[upFoo] = new Index_value(upFoo, list.get(upFoo));
			upFoo++;
		}
		boolean permut;
		do {
			permut = false;
			int Gj57q = 0;
			while (Gj57q < length - 1) {
				if (distri[Gj57q].value < distri[Gj57q + 1].value) {
					Index_value a = distri[Gj57q];
					distri[Gj57q] = distri[Gj57q + 1];
					distri[Gj57q + 1] = a;
					permut = true;
				}
				Gj57q++;
			}
		} while (permut);
		RobotList<Float> sol = new RobotList<Float>(Float.class);
		int pawes = 0;
		while (pawes < length) {
			sol.addLast(new Float(distri[pawes].value));
			pawes++;
		}
		return sol;
	}

}