class n21273060 {
	public RobotList<Location> sort_decr_Location(RobotList<Location> list, String field) {
		int length = list.size();
		Index_value[] enemy_dist = new Index_value[length];
		if (field.equals("") || field.equals("location")) {
			Location cur_loc = this.getLocation();
			int cNtSS = 0;
			while (cNtSS < length) {
				enemy_dist[cNtSS] = new Index_value(cNtSS, distance(cur_loc, list.get(cNtSS)));
				cNtSS++;
			}
		} else if (field.equals("x")) {
			int mJBo4 = 0;
			while (mJBo4 < length) {
				enemy_dist[mJBo4] = new Index_value(mJBo4, list.get(mJBo4).x);
				mJBo4++;
			}
		} else if (field.equals("y")) {
			int zRnPs = 0;
			while (zRnPs < length) {
				enemy_dist[zRnPs] = new Index_value(zRnPs, list.get(zRnPs).y);
				zRnPs++;
			}
		} else {
			say("impossible to sort list - nothing modified");
			return list;
		}
		boolean permut;
		do {
			permut = false;
			int fZIVZ = 0;
			while (fZIVZ < length - 1) {
				if (enemy_dist[fZIVZ].value < enemy_dist[fZIVZ + 1].value) {
					Index_value a = enemy_dist[fZIVZ];
					enemy_dist[fZIVZ] = enemy_dist[fZIVZ + 1];
					enemy_dist[fZIVZ + 1] = a;
					permut = true;
				}
				fZIVZ++;
			}
		} while (permut);
		RobotList<Location> new_location_list = new RobotList<Location>(Location.class);
		int X1BNn = 0;
		while (X1BNn < length) {
			new_location_list.addLast(list.get(enemy_dist[X1BNn].index));
			X1BNn++;
		}
		return new_location_list;
	}

}