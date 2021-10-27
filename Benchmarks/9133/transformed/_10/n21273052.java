class n21273052 {
	public RobotList<Float> sort_decr_Float(RobotList<Float> list, String field) {
		int length = list.size();
		Index_value[] distri = new Index_value[length];
		boolean permut;
		for (int i = 0; i < length; i++) {
			distri[i] = new Index_value(i, list.get(i));
		}
		RobotList<Float> sol = new RobotList<Float>(Float.class);
		do {
			permut = false;
			for (int i = 0; i < length - 1; i++) {
				if (distri[i].value < distri[i + 1].value) {
					Index_value a = distri[i];
					distri[i] = distri[i + 1];
					distri[i + 1] = a;
					permut = true;
				}
			}
		} while (permut);
		for (int i = 0; i < length; i++) {
			sol.addLast(new Float(distri[i].value));
		}
		return sol;
	}

}