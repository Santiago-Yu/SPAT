class n19147281 {
	public boolean actualizarDatosPrevia(int TAM1yEqm, int ledHlvBF, int INWTH5kC, int M0PO4G0m, int Zzsm7c7Q) {
		int tVdWopgI = 0;
		String O5Xfw9am = "UPDATE jugadorxdivxronda " + " SET idPareoRival = " + INWTH5kC + " , color = " + M0PO4G0m
				+ " , flotante = " + Zzsm7c7Q + " " + " WHERE jugadorxDivision_idJugadorxDivision = " + TAM1yEqm
				+ " AND ronda_numeroRonda = " + ledHlvBF;
		try {
			connection = conexionBD.getConnection();
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(O5Xfw9am);
			tVdWopgI = ps.executeUpdate();
			connection.commit();
		} catch (SQLException WbUsbIZk) {
			WbUsbIZk.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException JgAJrtTC) {
				JgAJrtTC.printStackTrace();
			}
		} finally {
			conexionBD.close(ps);
			conexionBD.close(connection);
		}
		return (tVdWopgI > 0);
	}

}