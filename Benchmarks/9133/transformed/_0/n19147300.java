class n19147300 {
	public boolean ponerColorxRonda(int N2Zc6jff, int ZZVpJfGj, int nvvKSerx) {
		int qmYZszbE = 0;
		String ThzOSUZt = "UPDATE jugadorxdivxronda " + " SET color = " + nvvKSerx
				+ " WHERE jugadorxDivision_idJugadorxDivision = " + N2Zc6jff + " AND ronda_numeroRonda = " + ZZVpJfGj;
		try {
			connection = conexionBD.getConnection();
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(ThzOSUZt);
			qmYZszbE = ps.executeUpdate();
			connection.commit();
		} catch (SQLException NU0emRw0) {
			NU0emRw0.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException z4zPK3VY) {
				z4zPK3VY.printStackTrace();
			}
		} finally {
			conexionBD.close(ps);
			conexionBD.close(connection);
		}
		return (qmYZszbE > 0);
	}

}