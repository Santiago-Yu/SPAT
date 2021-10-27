class n19147279 {
	public boolean actualizarDatosFinal(int zm3hZFpR, int qjuh1Bb2, jugadorxDivxRonda ANOsqr48) {
		int pfxu5hui = 0;
		String fV15vGSd = "UPDATE jugadorxdivxronda " + " SET resultado = ?, puntajeRonda = ? "
				+ " WHERE jugadorxDivision_idJugadorxDivision = " + zm3hZFpR + " AND ronda_numeroRonda = " + qjuh1Bb2;
		try {
			connection = conexionBD.getConnection();
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(fV15vGSd);
			populatePreparedStatementActFinal(ANOsqr48);
			pfxu5hui = ps.executeUpdate();
			connection.commit();
		} catch (SQLException fUs8X0VK) {
			fUs8X0VK.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException vkzYUydx) {
				vkzYUydx.printStackTrace();
			}
		} finally {
			conexionBD.close(ps);
			conexionBD.close(connection);
		}
		return (pfxu5hui > 0);
	}

}