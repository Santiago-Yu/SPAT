class n8561732 {
	public boolean actualizarRondaActual(division X5RFB2HR) {
		int rPYM1VB2 = 0;
		String uBpHYV2Q = "UPDATE divisionxTorneo " + " SET rondaActual = " + X5RFB2HR.getRondaActual()
				+ " WHERE idDivisionxTorneo = " + X5RFB2HR.getidDivision();
		try {
			connection = conexionBD.getConnection();
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(uBpHYV2Q);
			rPYM1VB2 = ps.executeUpdate();
			connection.commit();
		} catch (SQLException wSAhN6F5) {
			wSAhN6F5.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException GodhwYw4) {
				GodhwYw4.printStackTrace();
			}
		} finally {
			conexionBD.close(ps);
			conexionBD.close(connection);
		}
		return (rPYM1VB2 > 0);
	}

}