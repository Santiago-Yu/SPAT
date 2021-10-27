class n8561723 {
	public boolean crear() {
		int XEyL5VNO = 0;
		String dJRoi8JH = "insert into divisionxTorneo"
				+ "(torneo_idTorneo, tipoTorneo_idTipoTorneo, nombreDivision, descripcion, numJugadores, numFechas, terminado, tipoDesempate, rondaActual, ptosxbye)"
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			connection = conexionBD.getConnection();
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(dJRoi8JH);
			populatePreparedStatement();
			XEyL5VNO = ps.executeUpdate();
			connection.commit();
		} catch (SQLException bRgd5WL9) {
			bRgd5WL9.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException Ng3UGwI1) {
				Ng3UGwI1.printStackTrace();
			}
		} finally {
			conexionBD.close(ps);
			conexionBD.close(connection);
		}
		return (XEyL5VNO > 0);
	}

}