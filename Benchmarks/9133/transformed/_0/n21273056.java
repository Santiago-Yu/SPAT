class n21273056 {
	public RobotList<Resource> sort_decr_Resource(RobotList<Resource> G4NElqB4, String WFnAIbnV) {
		int YWOiNyXh = G4NElqB4.size();
		Index_value[] wILkWmxg = new Index_value[YWOiNyXh];
		if (WFnAIbnV.equals("") || WFnAIbnV.equals("location")) {
			Location nNS0aafJ = this.getLocation();
			for (int Pb2GWIKb = 0; Pb2GWIKb < YWOiNyXh; Pb2GWIKb++) {
				wILkWmxg[Pb2GWIKb] = new Index_value(Pb2GWIKb, distance(nNS0aafJ, G4NElqB4.get(Pb2GWIKb).location));
			}
		} else if (WFnAIbnV.equals("energy")) {
			for (int TmCzRx4A = 0; TmCzRx4A < YWOiNyXh; TmCzRx4A++) {
				wILkWmxg[TmCzRx4A] = new Index_value(TmCzRx4A, G4NElqB4.get(TmCzRx4A).energy);
			}
		} else if (WFnAIbnV.equals("ammostash")) {
			for (int nBhnf5bH = 0; nBhnf5bH < YWOiNyXh; nBhnf5bH++) {
				wILkWmxg[nBhnf5bH] = new Index_value(nBhnf5bH, G4NElqB4.get(nBhnf5bH).ammostash);
			}
		} else if (WFnAIbnV.equals("speed")) {
			for (int kdr4exWA = 0; kdr4exWA < YWOiNyXh; kdr4exWA++) {
				wILkWmxg[kdr4exWA] = new Index_value(kdr4exWA, G4NElqB4.get(kdr4exWA).speed);
			}
		} else if (WFnAIbnV.equals("health")) {
			for (int hKm84O0M = 0; hKm84O0M < YWOiNyXh; hKm84O0M++) {
				wILkWmxg[hKm84O0M] = new Index_value(hKm84O0M, G4NElqB4.get(hKm84O0M).health);
			}
		} else {
			say("impossible to sort list - nothing modified");
			return G4NElqB4;
		}
		boolean Hbd3pmsD;
		do {
			Hbd3pmsD = false;
			for (int JxSbtdjx = 0; JxSbtdjx < YWOiNyXh - 1; JxSbtdjx++) {
				if (wILkWmxg[JxSbtdjx].value < wILkWmxg[JxSbtdjx + 1].value) {
					Index_value eqZFK2cg = wILkWmxg[JxSbtdjx];
					wILkWmxg[JxSbtdjx] = wILkWmxg[JxSbtdjx + 1];
					wILkWmxg[JxSbtdjx + 1] = eqZFK2cg;
					Hbd3pmsD = true;
				}
			}
		} while (Hbd3pmsD);
		RobotList<Resource> XdvC14Z2 = new RobotList<Resource>(Resource.class);
		for (int kEjuw3jE = 0; kEjuw3jE < YWOiNyXh; kEjuw3jE++) {
			XdvC14Z2.addLast(G4NElqB4.get(wILkWmxg[kEjuw3jE].index));
		}
		return XdvC14Z2;
	}

}