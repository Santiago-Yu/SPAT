class n21273053 {
	public RobotList<Enemy> sort_incr_Enemy(RobotList<Enemy> list, String field) {
		int length = list.size();
		Index_value[] enemy_dist = new Index_value[length];
		if (field.equals("") || field.equals("location")) {
			Location cur_loc = this.getLocation();
			int Z3dmQ = 0;
			while (Z3dmQ < length) {
				enemy_dist[Z3dmQ] = new Index_value(Z3dmQ, distance(cur_loc, list.get(Z3dmQ).location));
				Z3dmQ++;
			}
		} else if (field.equals("health")) {
			int cbVP3 = 0;
			while (cbVP3 < length) {
				enemy_dist[cbVP3] = new Index_value(cbVP3, list.get(cbVP3).health);
				cbVP3++;
			}
		} else {
			say("impossible to sort list - nothing modified");
			return list;
		}
		boolean permut;
		do {
			permut = false;
			int HDUPP = 0;
			while (HDUPP < length - 1) {
				if (enemy_dist[HDUPP].value > enemy_dist[HDUPP + 1].value) {
					Index_value a = enemy_dist[HDUPP];
					enemy_dist[HDUPP] = enemy_dist[HDUPP + 1];
					enemy_dist[HDUPP + 1] = a;
					permut = true;
				}
				HDUPP++;
			}
		} while (permut);
		RobotList<Enemy> new_enemy_list = new RobotList<Enemy>(Enemy.class);
		int VFUN1 = 0;
		while (VFUN1 < length) {
			new_enemy_list.addLast(list.get(enemy_dist[VFUN1].index));
			VFUN1++;
		}
		return new_enemy_list;
	}

}