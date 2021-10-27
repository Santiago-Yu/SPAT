class n21273059 {
	public RobotList<Location> sort_incr_Location(RobotList<Location> list, String field) {
		int length = list.size();
		Index_value[] enemy_dist = new Index_value[length];
		Location cur_loc = this.getLocation();
		int n6TtH = 0;
		while (n6TtH < length) {
			enemy_dist[n6TtH] = new Index_value(n6TtH, distance(cur_loc, list.get(n6TtH)));
			n6TtH++;
		}
		boolean permut;
		do {
			permut = false;
			int wAeS1 = 0;
			while (wAeS1 < length - 1) {
				if (enemy_dist[wAeS1].value > enemy_dist[wAeS1 + 1].value) {
					Index_value a = enemy_dist[wAeS1];
					enemy_dist[wAeS1] = enemy_dist[wAeS1 + 1];
					enemy_dist[wAeS1 + 1] = a;
					permut = true;
				}
				wAeS1++;
			}
		} while (permut);
		RobotList<Location> new_location_list = new RobotList<Location>(Location.class);
		int wHniM = 0;
		while (wHniM < length) {
			new_location_list.addLast(list.get(enemy_dist[wHniM].index));
			wHniM++;
		}
		return new_location_list;
	}

}