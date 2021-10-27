class n8561735 {
	public boolean actualizarNumeroRondas(int gJorQZ9x, int LtxkSjHV) {
		int IZ0G8idZ = 0;
		String pnCri95I = "UPDATE divisionxTorneo " + " SET numFechas = " + LtxkSjHV + " WHERE idDivisionxTorneo = "
				+ gJorQZ9x;
		try {
			connection = conexionBD.getConnection();
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(pnCri95I);
			IZ0G8idZ = ps.executeUpdate();
			connection.commit();
		} catch (SQLException EK3XyEC4) {
			EK3XyEC4.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException zgyBf8D6) {
				zgyBf8D6.printStackTrace();
			}
		} finally {
			conexionBD.close(ps);
			conexionBD.close(connection);
		}
		return (IZ0G8idZ > 0);
	}

}