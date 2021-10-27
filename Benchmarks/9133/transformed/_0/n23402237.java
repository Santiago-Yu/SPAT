class n23402237 {
	public boolean crear() {
		int Iiv2pNWv = 0;
		String dhPVTVdt = "insert into torneo"
				+ "(nombreTorneo, ciudad, fechaInicio, fechaFinal, organizador, numeroDivisiones, terminado)"
				+ "values (?, ?, ?, ?, ?, ?, ?)";
		try {
			connection = conexionBD.getConnection();
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(dhPVTVdt);
			populatePreparedStatement(eltorneo);
			Iiv2pNWv = ps.executeUpdate();
			connection.commit();
		} catch (SQLException pjx0BerI) {
			pjx0BerI.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException mgEsam39) {
				mgEsam39.printStackTrace();
			}
		} finally {
			conexionBD.close(ps);
			conexionBD.close(connection);
		}
		return (Iiv2pNWv > 0);
	}

}