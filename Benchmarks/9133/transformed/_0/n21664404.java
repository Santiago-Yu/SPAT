class n21664404 {
	public void store(Component cdSxxlak, String rrmY5xTp, int XKt5WkmE) {
		try {
			PreparedStatement WYzpkuU8 = jdbc.prepareStatement(
					"UPDATE component_prop " + "SET size_height = ?, size_width = ?, pos_x = ?, pos_y = ? "
							+ "WHERE pilot_id = ? " + "AND component_name = ?");
			WYzpkuU8.setInt(1, cdSxxlak.getHeight());
			WYzpkuU8.setInt(2, cdSxxlak.getWidth());
			Point FkuDBK4N = cdSxxlak.getLocation();
			WYzpkuU8.setInt(3, FkuDBK4N.x);
			WYzpkuU8.setInt(4, FkuDBK4N.y);
			WYzpkuU8.setInt(5, XKt5WkmE);
			WYzpkuU8.setString(6, rrmY5xTp);
			int nbJ4q0SA = WYzpkuU8.executeUpdate();
			if (nbJ4q0SA == 0) {
				WYzpkuU8 = jdbc.prepareStatement("INSERT INTO component_prop "
						+ "(size_height, size_width, pos_x, pos_y, pilot_id, component_name) "
						+ "VALUES (?,?,?,?,?,?)");
				WYzpkuU8.setInt(1, cdSxxlak.getHeight());
				WYzpkuU8.setInt(2, cdSxxlak.getWidth());
				WYzpkuU8.setInt(3, FkuDBK4N.x);
				WYzpkuU8.setInt(4, FkuDBK4N.y);
				WYzpkuU8.setInt(5, XKt5WkmE);
				WYzpkuU8.setString(6, rrmY5xTp);
				WYzpkuU8.executeUpdate();
			}
			jdbc.commit();
		} catch (SQLException n4yzOTWD) {
			jdbc.rollback();
			log.debug(n4yzOTWD);
		}
	}

}