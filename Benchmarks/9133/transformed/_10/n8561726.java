class n8561726 {
	public boolean actualizarDivisionActual(division div) {
		String sql = "UPDATE divisionxTorneo " + " SET tipoTorneo_idTipoTorneo = " + div.getidTipoTorneo()
				+ " , nombreDivision = '" + div.getnombreDivision() + "', " + " descripcion = '" + div.getDescripcion()
				+ "', tipoDesempate = " + div.getDesempate() + ", " + " numFechas = " + div.getnumFechas()
				+ " , ptosxbye = " + div.getPtosxBye() + " WHERE idDivisionxTorneo = " + div.getidDivision();
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