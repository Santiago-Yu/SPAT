class n19147281 {
	public boolean actualizarDatosPrevia(int idJugadorDiv, int idRonda, int idPareoRival, int color, int flotante) {
		String sql = "UPDATE jugadorxdivxronda " + " SET idPareoRival = " + idPareoRival + " , color = " + color
				+ " , flotante = " + flotante + " " + " WHERE jugadorxDivision_idJugadorxDivision = " + idJugadorDiv
				+ " AND ronda_numeroRonda = " + idRonda;
		int intResult = 0;
		try {
			connection = conexionBD.getConnection();
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(sql);
			intResult = ps.executeUpdate();
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
		return (intResult > 0);
	}

}