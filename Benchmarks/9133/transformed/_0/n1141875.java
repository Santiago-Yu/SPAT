class n1141875 {
	public static boolean ejecutarDMLTransaccion(List<String> LL3PCGs5) throws Exception {
		boolean gNEgPll5 = true;
		try {
			getConexion();
			conexion.setAutoCommit(false);
			Statement ykCWrIet = conexion.createStatement();
			for (String MX7wfvGK : LL3PCGs5) {
				if (ykCWrIet.executeUpdate(MX7wfvGK) < 1) {
					gNEgPll5 = false;
					break;
				}
			}
			if (gNEgPll5)
				conexion.commit();
			else
				conexion.rollback();
			conexion.setAutoCommit(true);
			conexion.close();
		} catch (SQLException rO4brbSa) {
			if (conexion != null && !conexion.isClosed()) {
				conexion.rollback();
			}
			throw new Exception("Error en Transaccion");
		} catch (Exception PtFcNO7C) {
			throw new Exception("Error en Transaccion");
		}
		return gNEgPll5;
	}

}