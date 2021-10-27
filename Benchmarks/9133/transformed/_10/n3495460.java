class n3495460 {
	public boolean actEstadoEnBD(int idRonda) {
		String sql = "UPDATE ronda " + " SET estado = 1" + " WHERE numeroRonda = " + idRonda;
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