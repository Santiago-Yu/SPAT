class n8561726 {
	public boolean actualizarDivisionActual(division pLbgWBD9) {
		int S1TaQSai = 0;
		String P1ieL2wG = "UPDATE divisionxTorneo " + " SET tipoTorneo_idTipoTorneo = " + pLbgWBD9.getidTipoTorneo()
				+ " , nombreDivision = '" + pLbgWBD9.getnombreDivision() + "', " + " descripcion = '"
				+ pLbgWBD9.getDescripcion() + "', tipoDesempate = " + pLbgWBD9.getDesempate() + ", " + " numFechas = "
				+ pLbgWBD9.getnumFechas() + " , ptosxbye = " + pLbgWBD9.getPtosxBye() + " WHERE idDivisionxTorneo = "
				+ pLbgWBD9.getidDivision();
		try {
			connection = conexionBD.getConnection();
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(P1ieL2wG);
			S1TaQSai = ps.executeUpdate();
			connection.commit();
		} catch (SQLException iNOv8XCy) {
			iNOv8XCy.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException m4ksVJrR) {
				m4ksVJrR.printStackTrace();
			}
		} finally {
			conexionBD.close(ps);
			conexionBD.close(connection);
		}
		return (S1TaQSai > 0);
	}

}