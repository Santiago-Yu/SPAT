class n19147293 {
	public boolean limpiarContrincantexRonda(jugadorxDivxRonda unjxdxr) {
		String sql = "UPDATE jugadorxdivxronda " + " SET idPareoRival = 0 " + " WHERE idJugxDivxRnd = "
				+ unjxdxr.getIdJugxDivxRnd();
		int intResult = 0;
		try {
			connection = conexionBD.getConnection();
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(sql);
			intResult = ps.executeUpdate();
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
		return (intResult > 0);
	}

}