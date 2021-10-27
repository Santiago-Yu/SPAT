class n19147301 {
	public boolean actualizarIdPartida(int iW3MdW5B, int IqlOCLyD, int OIOu7dEd) {
		int hDBGKfKL = 0;
		String SyparCQt = "UPDATE jugadorxdivxronda " + " SET idPartida = " + OIOu7dEd
				+ " WHERE jugadorxDivision_idJugadorxDivision = " + iW3MdW5B + " AND ronda_numeroRonda = " + IqlOCLyD;
		try {
			connection = conexionBD.getConnection();
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(SyparCQt);
			hDBGKfKL = ps.executeUpdate();
			connection.commit();
		} catch (SQLException EONbgvG5) {
			EONbgvG5.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException R1KdUxwb) {
				R1KdUxwb.printStackTrace();
			}
		} finally {
			conexionBD.close(ps);
			conexionBD.close(connection);
		}
		return (hDBGKfKL > 0);
	}

}