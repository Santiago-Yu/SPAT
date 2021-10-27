class n19147275 {
	public boolean crear() {
		int XRAvOcXt = 0;
		String BGIYfnaL = "insert into jugadorxdivxronda"
				+ "(jugadorxDivision_idJugadorxDivision, ronda_numeroRonda, resultado, idPareoRival, color, flotante, puntajeRonda, idPareo) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			connection = conexionBD.getConnection();
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(BGIYfnaL);
			populatePreparedStatement(unjxdxr);
			XRAvOcXt = ps.executeUpdate();
			connection.commit();
		} catch (SQLException F9gtYLNs) {
			F9gtYLNs.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException FbjEM9xd) {
				FbjEM9xd.printStackTrace();
			}
		} finally {
			conexionBD.close(ps);
			conexionBD.close(connection);
		}
		return (XRAvOcXt > 0);
	}

}