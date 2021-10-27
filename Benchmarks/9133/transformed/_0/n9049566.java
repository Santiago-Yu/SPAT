class n9049566 {
	public void store(Component T90oy07s, String Lcr1aPve, int JpV7B7Oa) {
		try {
			PreparedStatement PrbunzQc = jdbc.prepareStatement(
					"UPDATE component_prop " + "SET size_height = ?, size_width = ?, pos_x = ?, pos_y = ? "
							+ "WHERE pilot_id = ? " + "AND component_name = ?");
			PrbunzQc.setInt(1, T90oy07s.getHeight());
			PrbunzQc.setInt(2, T90oy07s.getWidth());
			Point p0lBcXEg = T90oy07s.getLocation();
			PrbunzQc.setInt(3, p0lBcXEg.x);
			PrbunzQc.setInt(4, p0lBcXEg.y);
			PrbunzQc.setInt(5, JpV7B7Oa);
			PrbunzQc.setString(6, Lcr1aPve);
			int SYwEeMBR = PrbunzQc.executeUpdate();
			if (SYwEeMBR == 0) {
				PrbunzQc = jdbc.prepareStatement("INSERT INTO component_prop "
						+ "(size_height, size_width, pos_x, pos_y, pilot_id, component_name) "
						+ "VALUES (?,?,?,?,?,?)");
				PrbunzQc.setInt(1, T90oy07s.getHeight());
				PrbunzQc.setInt(2, T90oy07s.getWidth());
				PrbunzQc.setInt(3, p0lBcXEg.x);
				PrbunzQc.setInt(4, p0lBcXEg.y);
				PrbunzQc.setInt(5, JpV7B7Oa);
				PrbunzQc.setString(6, Lcr1aPve);
				PrbunzQc.executeUpdate();
			}
			jdbc.commit();
		} catch (SQLException SdpjY3Pj) {
			jdbc.rollback();
			log.debug(SdpjY3Pj);
		}
	}

}