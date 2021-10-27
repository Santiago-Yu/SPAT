class n19947818 {
	public boolean update(int ZOLSb3uD, partida SlprtKNN) {
		int ZMY890Ah = 0;
		String jl0wTfIh = "UPDATE partida " + "SET torneo_idTorneo = ?, "
				+ " jugador_idJugadorNegras = ?, jugador_idJugadorBlancas = ?, " + " fecha = ?, " + " resultado = ?, "
				+ " nombreBlancas = ?, nombreNegras = ?, eloBlancas = ?, eloNegras = ?, idApertura = ? "
				+ " WHERE idPartida = " + ZOLSb3uD;
		try {
			connection = conexionBD.getConnection();
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(jl0wTfIh);
			populatePreparedStatement2(SlprtKNN);
			ZMY890Ah = ps.executeUpdate();
			connection.commit();
		} catch (SQLException n6u7phVF) {
			n6u7phVF.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException o8gOpx48) {
				o8gOpx48.printStackTrace();
			}
		} finally {
			conexionBD.close(ps);
			conexionBD.close(connection);
		}
		return (ZMY890Ah > 0);
	}

}