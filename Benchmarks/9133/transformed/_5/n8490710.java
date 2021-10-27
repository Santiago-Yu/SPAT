class n8490710 {
	public void actualizar() throws SQLException, ClassNotFoundException, Exception {
		Connection conn = null;
		PreparedStatement ms = null;
		registroActualizado = false;
		try {
			conn = ToolsBD.getConn();
			conn.setAutoCommit(false);
			Date fechaSystem = new Date();
			DateFormat aaaammdd = new SimpleDateFormat("yyyyMMdd");
			int fzafsis = Integer.parseInt(aaaammdd.format(fechaSystem));
			DateFormat hhmmss = new SimpleDateFormat("HHmmss");
			DateFormat sss = new SimpleDateFormat("S");
			String ss = sss.format(fechaSystem);
			if (ss.length() > 2) {
				ss = ss.substring(0, 2);
			}
			int fzahsis = Integer.parseInt(hhmmss.format(fechaSystem) + ss);
			ms = conn.prepareStatement(SENTENCIA_UPDATE);
			ms.setString(1, descartadoEntrada);
			ms.setString(2, usuarioEntrada);
			ms.setString(3, motivosDescarteEntrada);
			ms.setInt(4, Integer.parseInt(anoOficio));
			ms.setInt(5, Integer.parseInt(oficinaOficio));
			ms.setInt(6, Integer.parseInt(numeroOficio));
			if (anoEntrada != null)
				ms.setInt(7, Integer.parseInt(anoEntrada));
			else
				ms.setInt(7, 0);
			if (oficinaEntrada != null)
				ms.setInt(8, Integer.parseInt(oficinaEntrada));
			else
				ms.setInt(8, 0);
			if (numeroEntrada != null)
				ms.setInt(9, Integer.parseInt(numeroEntrada));
			else
				ms.setInt(9, 0);
			int afectados = ms.executeUpdate();
			if (afectados > 0) {
				registroActualizado = true;
			} else {
				registroActualizado = false;
			}
			conn.commit();
		} catch (Exception ex) {
			System.out.println("Error inesperat, no s'ha desat el registre: " + ex.getMessage());
			ex.printStackTrace();
			registroActualizado = false;
			errores.put("",
					"Error inesperat, no s'ha desat el registre" + ": " + ex.getClass() + "->" + ex.getMessage());
			try {
				if (conn != null)
					conn.rollback();
			} catch (SQLException sqle) {
				throw new RemoteException("S'ha produ?t un error i no s'han pogut tornar enrere els canvis efectuats",
						sqle);
			}
			throw new RemoteException("Error inesperat, no s'ha modifcat el registre", ex);
		} finally {
			ToolsBD.closeConn(conn, ms, null);
		}
	}

}