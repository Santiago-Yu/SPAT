class n21273057 {
	public RobotList<Percentage> sort_incr_Percentage(RobotList<Percentage> list, String field) {
		int length = list.size();
		Index_value[] distri = new Index_value[length];
		int oC4PK = 0;
		while (oC4PK < length) {
			distri[oC4PK] = new Index_value(oC4PK, list.get(oC4PK).percent);
			oC4PK++;
		}
		boolean permut;
		do {
			permut = false;
			int TdYux = 0;
			while (TdYux < length - 1) {
				if (distri[TdYux].value > distri[TdYux + 1].value) {
					Index_value a = distri[TdYux];
					distri[TdYux] = distri[TdYux + 1];
					distri[TdYux + 1] = a;
					permut = true;
				}
				TdYux++;
			}
		} while (permut);
		RobotList<Percentage> sol = new RobotList<Percentage>(Percentage.class);
		int W4lwI = 0;
		while (W4lwI < length) {
			sol.addLast(new Percentage(distri[W4lwI].value));
			W4lwI++;
		}
		return sol;
	}

}