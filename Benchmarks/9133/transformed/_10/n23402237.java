class n23402237 {
	public boolean crear() {
		String sql = "insert into torneo"
				+ "(nombreTorneo, ciudad, fechaInicio, fechaFinal, organizador, numeroDivisiones, terminado)"
				+ "values (?, ?, ?, ?, ?, ?, ?)";
		int result = 0;
		try {
			connection = conexionBD.getConnection();
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(sql);
			populatePreparedStatement(eltorneo);
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