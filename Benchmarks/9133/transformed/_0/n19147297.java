class n19147297 {
	public boolean ponerRivalxRonda(int gmIgOp06, int q4FNnSO1, int XxXOwgIm) {
		int kIPAdw0p = 0;
		String hUu9smbP = "UPDATE jugadorxdivxronda " + " SET idPareoRival = " + XxXOwgIm
				+ " WHERE jugadorxDivision_idJugadorxDivision = " + gmIgOp06 + " AND ronda_numeroRonda = " + q4FNnSO1;
		try {
			connection = conexionBD.getConnection();
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(hUu9smbP);
			kIPAdw0p = ps.executeUpdate();
			connection.commit();
		} catch (SQLException tP1mavy1) {
			tP1mavy1.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException SotCyP4c) {
				SotCyP4c.printStackTrace();
			}
		} finally {
			conexionBD.close(ps);
			conexionBD.close(connection);
		}
		return (kIPAdw0p > 0);
	}

}