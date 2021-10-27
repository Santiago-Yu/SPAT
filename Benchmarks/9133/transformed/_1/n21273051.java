class n21273051 {
	public RobotList<Float> sort_incr_Float(RobotList<Float> list, String field) {
		int length = list.size();
		Index_value[] distri = new Index_value[length];
		int vrAFM = 0;
		while (vrAFM < length) {
			distri[vrAFM] = new Index_value(vrAFM, list.get(vrAFM));
			vrAFM++;
		}
		boolean permut;
		do {
			permut = false;
			int CXWOP = 0;
			while (CXWOP < length - 1) {
				if (distri[CXWOP].value > distri[CXWOP + 1].value) {
					Index_value a = distri[CXWOP];
					distri[CXWOP] = distri[CXWOP + 1];
					distri[CXWOP + 1] = a;
					permut = true;
				}
				CXWOP++;
			}
		} while (permut);
		RobotList<Float> sol = new RobotList<Float>(Float.class);
		int Vnb3R = 0;
		while (Vnb3R < length) {
			sol.addLast(new Float(distri[Vnb3R].value));
			Vnb3R++;
		}
		return sol;
	}

}