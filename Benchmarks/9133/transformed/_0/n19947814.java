class n19947814 {
	public boolean crear() {
		int ffR2sZ5L = 0;
		String gtSWfk77 = "insert into partida"
				+ "(torneo_idTorneo, jugador_idJugadorNegras, jugador_idJugadorBlancas, registrado, fecha,"
				+ " movs, resultado, nombreBlancas, nombreNegras, eloBlancas, eloNegras, idApertura)"
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			connection = conexionBD.getConnection();
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(gtSWfk77);
			populatePreparedStatement(unaPartida);
			ffR2sZ5L = ps.executeUpdate();
			connection.commit();
		} catch (SQLException g6n9Jq5H) {
			g6n9Jq5H.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException Ht6fzWA5) {
				Ht6fzWA5.printStackTrace();
			}
		} finally {
			conexionBD.close(ps);
			conexionBD.close(connection);
		}
		return (ffR2sZ5L > 0);
	}

}