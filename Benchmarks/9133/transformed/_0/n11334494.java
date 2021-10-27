class n11334494 {
	public void store(Component bcapmT0Q, String e8G0CnuJ, int C1huHAre) {
		try {
			PreparedStatement EJZbSa5Z = jdbc.prepareStatement(
					"UPDATE component_prop " + "SET size_height = ?, size_width = ?, pos_x = ?, pos_y = ? "
							+ "WHERE pilot_id = ? " + "AND component_name = ?");
			EJZbSa5Z.setInt(1, bcapmT0Q.getHeight());
			EJZbSa5Z.setInt(2, bcapmT0Q.getWidth());
			Point mssZSVTr = bcapmT0Q.getLocation();
			EJZbSa5Z.setInt(3, mssZSVTr.x);
			EJZbSa5Z.setInt(4, mssZSVTr.y);
			EJZbSa5Z.setInt(5, C1huHAre);
			EJZbSa5Z.setString(6, e8G0CnuJ);
			int xUtq01yS = EJZbSa5Z.executeUpdate();
			if (xUtq01yS == 0) {
				EJZbSa5Z = jdbc.prepareStatement("INSERT INTO component_prop "
						+ "(size_height, size_width, pos_x, pos_y, pilot_id, component_name) "
						+ "VALUES (?,?,?,?,?,?)");
				EJZbSa5Z.setInt(1, bcapmT0Q.getHeight());
				EJZbSa5Z.setInt(2, bcapmT0Q.getWidth());
				EJZbSa5Z.setInt(3, mssZSVTr.x);
				EJZbSa5Z.setInt(4, mssZSVTr.y);
				EJZbSa5Z.setInt(5, C1huHAre);
				EJZbSa5Z.setString(6, e8G0CnuJ);
				EJZbSa5Z.executeUpdate();
			}
			jdbc.commit();
		} catch (SQLException sVlS9Fh9) {
			jdbc.rollback();
			log.debug(sVlS9Fh9);
		}
	}

}