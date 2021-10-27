class n23402244 {
	public boolean update(int Ut9KvMTm, torneo jxEgqKi6) {
		int x5U9fKBr = 0;
		String KHimx6ww = "UPDATE torneo " + "SET nombreTorneo = ?, ciudad = ?, fechaInicio = ?, fechaFinal = ?, "
				+ " organizador = ? " + " WHERE idTorneo = " + Ut9KvMTm;
		try {
			connection = conexionBD.getConnection();
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(KHimx6ww);
			populatePreparedStatement2(jxEgqKi6);
			x5U9fKBr = ps.executeUpdate();
			connection.commit();
		} catch (SQLException TVHGgjUb) {
			TVHGgjUb.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException AwslEX6c) {
				AwslEX6c.printStackTrace();
			}
		} finally {
			conexionBD.close(ps);
			conexionBD.close(connection);
		}
		return (x5U9fKBr > 0);
	}

}