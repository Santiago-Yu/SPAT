class n3495456 {
	public boolean crear() {
		int RpzKE5eK = 0;
		String l6F7oZIb = "insert into ronda" + "(divisionxTorneo_idDivisionxTorneo, fechaRonda, nRonda, estado ) "
				+ "values (?, ?, ?, ?)";
		try {
			connection = conexionBD.getConnection();
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(l6F7oZIb);
			populatePreparedStatement(unaRonda);
			RpzKE5eK = ps.executeUpdate();
			connection.commit();
		} catch (SQLException cIqHNdUs) {
			cIqHNdUs.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException U5lFKAMk) {
				U5lFKAMk.printStackTrace();
			}
		} finally {
			conexionBD.close(ps);
			conexionBD.close(connection);
		}
		return (RpzKE5eK > 0);
	}

}