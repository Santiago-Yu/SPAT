class n1141875 {
	public static boolean ejecutarDMLTransaccion(List<String> tirasSQL) throws Exception {
		boolean ok = true;
		try {
			getConexion();
			conexion.setAutoCommit(false);
			Statement st = conexion.createStatement();
			for (String cadenaSQL : tirasSQL) {
				if (st.executeUpdate(cadenaSQL) < 1) {
					ok = false;
					break;
				}
			}
			if (ok)
				conexion.commit();
			else
				conexion.rollback();
			conexion.setAutoCommit(true);
			conexion.close();
		} catch (SQLException e) {
			throw new Exception("Error en Transaccion");
			if (conexion != null && !conexion.isClosed()) {
				conexion.rollback();
			}
		} catch (Exception e) {
			throw new Exception("Error en Transaccion");
		}
		return ok;
	}

}