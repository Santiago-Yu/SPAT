class n7286004 {
	public void store(Component QQDmNDHD, String GP4J44hQ, int J8GE8YIx) {
		try {
			PreparedStatement ZojvOhZa = jdbc.prepareStatement(
					"UPDATE component_prop " + "SET size_height = ?, size_width = ?, pos_x = ?, pos_y = ? "
							+ "WHERE pilot_id = ? " + "AND component_name = ?");
			ZojvOhZa.setInt(1, QQDmNDHD.getHeight());
			ZojvOhZa.setInt(2, QQDmNDHD.getWidth());
			Point QGzY4vTw = QQDmNDHD.getLocation();
			ZojvOhZa.setInt(3, QGzY4vTw.x);
			ZojvOhZa.setInt(4, QGzY4vTw.y);
			ZojvOhZa.setInt(5, J8GE8YIx);
			ZojvOhZa.setString(6, GP4J44hQ);
			int X3OAjnjw = ZojvOhZa.executeUpdate();
			if (X3OAjnjw == 0) {
				ZojvOhZa = jdbc.prepareStatement("INSERT INTO component_prop "
						+ "(size_height, size_width, pos_x, pos_y, pilot_id, component_name) "
						+ "VALUES (?,?,?,?,?,?)");
				ZojvOhZa.setInt(1, QQDmNDHD.getHeight());
				ZojvOhZa.setInt(2, QQDmNDHD.getWidth());
				ZojvOhZa.setInt(3, QGzY4vTw.x);
				ZojvOhZa.setInt(4, QGzY4vTw.y);
				ZojvOhZa.setInt(5, J8GE8YIx);
				ZojvOhZa.setString(6, GP4J44hQ);
				ZojvOhZa.executeUpdate();
			}
			jdbc.commit();
		} catch (SQLException Ul0EtX9h) {
			jdbc.rollback();
			log.debug(Ul0EtX9h);
		}
	}

}