class n19147296 {
	public boolean ponerFlotantexRonda(int qVEpjg87, int OlMuxGlf, int uPMYKHtl) {
		int jQpf4hAH = 0;
		String QDhLrbTL = "UPDATE jugadorxdivxronda " + " SET flotante = " + uPMYKHtl
				+ " WHERE jugadorxDivision_idJugadorxDivision = " + qVEpjg87 + " AND ronda_numeroRonda = " + OlMuxGlf;
		try {
			connection = conexionBD.getConnection();
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(QDhLrbTL);
			jQpf4hAH = ps.executeUpdate();
			connection.commit();
		} catch (SQLException NIxX9SPH) {
			NIxX9SPH.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException EQesrfCN) {
				EQesrfCN.printStackTrace();
			}
		} finally {
			conexionBD.close(ps);
			conexionBD.close(connection);
		}
		return (jQpf4hAH > 0);
	}

}