class n8561731 {
	public boolean actualizarEstadoDivision(division c7qBni9S) {
		int NpH0cJaP = 0;
		String Rnkjo0ZI = "UPDATE divisionxTorneo " + " SET terminado = '1' " + " WHERE idDivisionxTorneo = "
				+ c7qBni9S.getidDivision();
		try {
			connection = conexionBD.getConnection();
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(Rnkjo0ZI);
			NpH0cJaP = ps.executeUpdate();
			connection.commit();
		} catch (SQLException spK3KZfE) {
			spK3KZfE.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException faymmXGP) {
				faymmXGP.printStackTrace();
			}
		} finally {
			conexionBD.close(ps);
			conexionBD.close(connection);
		}
		return (NpH0cJaP > 0);
	}

}