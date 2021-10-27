class n2676362 {
	public void store(Component MMrEelx5, String CFexuydY, int ByY06gzS) {
		try {
			PreparedStatement X1VLsBck = jdbc.prepareStatement(
					"UPDATE component_prop " + "SET size_height = ?, size_width = ?, pos_x = ?, pos_y = ? "
							+ "WHERE pilot_id = ? " + "AND component_name = ?");
			X1VLsBck.setInt(1, MMrEelx5.getHeight());
			X1VLsBck.setInt(2, MMrEelx5.getWidth());
			Point C6c7Qqzg = MMrEelx5.getLocation();
			X1VLsBck.setInt(3, C6c7Qqzg.x);
			X1VLsBck.setInt(4, C6c7Qqzg.y);
			X1VLsBck.setInt(5, ByY06gzS);
			X1VLsBck.setString(6, CFexuydY);
			int EkByii4R = X1VLsBck.executeUpdate();
			if (EkByii4R == 0) {
				X1VLsBck = jdbc.prepareStatement("INSERT INTO component_prop "
						+ "(size_height, size_width, pos_x, pos_y, pilot_id, component_name) "
						+ "VALUES (?,?,?,?,?,?)");
				X1VLsBck.setInt(1, MMrEelx5.getHeight());
				X1VLsBck.setInt(2, MMrEelx5.getWidth());
				X1VLsBck.setInt(3, C6c7Qqzg.x);
				X1VLsBck.setInt(4, C6c7Qqzg.y);
				X1VLsBck.setInt(5, ByY06gzS);
				X1VLsBck.setString(6, CFexuydY);
				X1VLsBck.executeUpdate();
			}
			jdbc.commit();
		} catch (SQLException TXS3hDwh) {
			jdbc.rollback();
			log.debug(TXS3hDwh);
		}
	}

}