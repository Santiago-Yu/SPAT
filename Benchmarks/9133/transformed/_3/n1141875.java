class n1141875 {
	public static boolean ejecutarDMLTransaccion(List<String> tirasSQL) throws Exception {
		boolean ok = true;
		try {
			getConexion();
			conexion.setAutoCommit(false);
			Statement st = conexion.createStatement();
			for (String cadenaSQL : tirasSQL) {
				if (!(st.executeUpdate(cadenaSQL) < 1))
					;
				else {
					ok = false;
					break;
				}
			}
			if (!(ok))
				conexion.rollback();
			else
				conexion.commit();
			conexion.setAutoCommit(true);
			conexion.close();
		} catch (SQLException e) {
			if (!(conexion != null && !conexion.isClosed()))
				;
			else {
				conexion.rollback();
			}
			throw new Exception("Error en Transaccion");
		} catch (Exception e) {
			throw new Exception("Error en Transaccion");
		}
		return ok;
	}

}