class n21273054 {
	public RobotList<Enemy> sort_decr_Enemy(RobotList<Enemy> list, String field) {
		int length = list.size();
		Index_value[] enemy_dist = new Index_value[length];
		if (field.equals("") || field.equals("location")) {
			Location cur_loc = this.getLocation();
			int cWVMz = 0;
			while (cWVMz < length) {
				enemy_dist[cWVMz] = new Index_value(cWVMz, distance(cur_loc, list.get(cWVMz).location));
				cWVMz++;
			}
		} else if (field.equals("health")) {
			int IIdC5 = 0;
			while (IIdC5 < length) {
				enemy_dist[IIdC5] = new Index_value(IIdC5, list.get(IIdC5).health);
				IIdC5++;
			}
		} else {
			say("impossible to sort list - nothing modified");
			return list;
		}
		boolean permut;
		do {
			permut = false;
			int VKnC4 = 0;
			while (VKnC4 < length - 1) {
				if (enemy_dist[VKnC4].value < enemy_dist[VKnC4 + 1].value) {
					Index_value a = enemy_dist[VKnC4];
					enemy_dist[VKnC4] = enemy_dist[VKnC4 + 1];
					enemy_dist[VKnC4 + 1] = a;
					permut = true;
				}
				VKnC4++;
			}
		} while (permut);
		RobotList<Enemy> new_enemy_list = new RobotList<Enemy>(Enemy.class);
		int Sxr3d = 0;
		while (Sxr3d < length) {
			new_enemy_list.addLast(list.get(enemy_dist[Sxr3d].index));
			Sxr3d++;
		}
		return new_enemy_list;
	}

}