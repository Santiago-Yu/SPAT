class n19147293 {
	public boolean limpiarContrincantexRonda(jugadorxDivxRonda sFGbQAV1) {
		int sweCRfTV = 0;
		String ChjOv586 = "UPDATE jugadorxdivxronda " + " SET idPareoRival = 0 " + " WHERE idJugxDivxRnd = "
				+ sFGbQAV1.getIdJugxDivxRnd();
		try {
			connection = conexionBD.getConnection();
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(ChjOv586);
			sweCRfTV = ps.executeUpdate();
			connection.commit();
		} catch (SQLException yizorIVr) {
			yizorIVr.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException u3N26LWg) {
				u3N26LWg.printStackTrace();
			}
		} finally {
			conexionBD.close(ps);
			conexionBD.close(connection);
		}
		return (sweCRfTV > 0);
	}

}