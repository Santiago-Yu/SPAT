class n3495460 {
	public boolean actEstadoEnBD(int fhLT86KQ) {
		int VO2YXjf7 = 0;
		String zwlfZ90U = "UPDATE ronda " + " SET estado = 1" + " WHERE numeroRonda = " + fhLT86KQ;
		try {
			connection = conexionBD.getConnection();
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(zwlfZ90U);
			VO2YXjf7 = ps.executeUpdate();
			connection.commit();
		} catch (SQLException UyO3hWHI) {
			UyO3hWHI.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException TLLs9JBJ) {
				TLLs9JBJ.printStackTrace();
			}
		} finally {
			conexionBD.close(ps);
			conexionBD.close(connection);
		}
		return (VO2YXjf7 > 0);
	}

}