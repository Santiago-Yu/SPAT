class n8561731 {
	public boolean actualizarEstadoDivision(division div) {
		String sql = "UPDATE divisionxTorneo " + " SET terminado = '1' " + " WHERE idDivisionxTorneo = "
				+ div.getidDivision();
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