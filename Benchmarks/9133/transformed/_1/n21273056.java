class n21273056 {
	public RobotList<Resource> sort_decr_Resource(RobotList<Resource> list, String field) {
		int length = list.size();
		Index_value[] resource_dist = new Index_value[length];
		if (field.equals("") || field.equals("location")) {
			Location cur_loc = this.getLocation();
			int jTV3J = 0;
			while (jTV3J < length) {
				resource_dist[jTV3J] = new Index_value(jTV3J, distance(cur_loc, list.get(jTV3J).location));
				jTV3J++;
			}
		} else if (field.equals("energy")) {
			int PfgRS = 0;
			while (PfgRS < length) {
				resource_dist[PfgRS] = new Index_value(PfgRS, list.get(PfgRS).energy);
				PfgRS++;
			}
		} else if (field.equals("ammostash")) {
			int yyeqT = 0;
			while (yyeqT < length) {
				resource_dist[yyeqT] = new Index_value(yyeqT, list.get(yyeqT).ammostash);
				yyeqT++;
			}
		} else if (field.equals("speed")) {
			int Md8Mv = 0;
			while (Md8Mv < length) {
				resource_dist[Md8Mv] = new Index_value(Md8Mv, list.get(Md8Mv).speed);
				Md8Mv++;
			}
		} else if (field.equals("health")) {
			int RB130 = 0;
			while (RB130 < length) {
				resource_dist[RB130] = new Index_value(RB130, list.get(RB130).health);
				RB130++;
			}
		} else {
			say("impossible to sort list - nothing modified");
			return list;
		}
		boolean permut;
		do {
			permut = false;
			int LIL2C = 0;
			while (LIL2C < length - 1) {
				if (resource_dist[LIL2C].value < resource_dist[LIL2C + 1].value) {
					Index_value a = resource_dist[LIL2C];
					resource_dist[LIL2C] = resource_dist[LIL2C + 1];
					resource_dist[LIL2C + 1] = a;
					permut = true;
				}
				LIL2C++;
			}
		} while (permut);
		RobotList<Resource> new_resource_list = new RobotList<Resource>(Resource.class);
		int udvj0 = 0;
		while (udvj0 < length) {
			new_resource_list.addLast(list.get(resource_dist[udvj0].index));
			udvj0++;
		}
		return new_resource_list;
	}

}