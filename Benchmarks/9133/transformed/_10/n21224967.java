class n21224967 {
	public boolean crear() {
		String sql = "insert into jugador"
				+ "(apellidoPaterno, apellidoMaterno, nombres, fechaNacimiento, pais, rating, sexo)"
				+ "values (?, ?, ?, ?, ?, ?, ?)";
		int result = 0;
		try {
			connection = conexionBD.getConnection();
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(sql);
			populatePreparedStatement(elJugador);
			result = ps.executeUpdate();
			connection.commit();
		} catch (SQLException ex) {
			ex.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException exe) {
				exe.printStackTrace();
			}
		} finally {
			conexionBD.close(ps);
			conexionBD.close(connection);
		}
		return (result > 0);
	}

}