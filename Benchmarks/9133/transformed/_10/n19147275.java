class n19147275 {
	public boolean crear() {
		String sql = "insert into jugadorxdivxronda"
				+ "(jugadorxDivision_idJugadorxDivision, ronda_numeroRonda, resultado, idPareoRival, color, flotante, puntajeRonda, idPareo) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?)";
		int result = 0;
		try {
			connection = conexionBD.getConnection();
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(sql);
			populatePreparedStatement(unjxdxr);
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