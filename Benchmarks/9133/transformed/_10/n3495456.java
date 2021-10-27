class n3495456 {
	public boolean crear() {
		String sql = "insert into ronda" + "(divisionxTorneo_idDivisionxTorneo, fechaRonda, nRonda, estado ) "
				+ "values (?, ?, ?, ?)";
		int result = 0;
		try {
			connection = conexionBD.getConnection();
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(sql);
			populatePreparedStatement(unaRonda);
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