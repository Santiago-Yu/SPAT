class n1989227 {
	public void anular() throws SQLException, ClassNotFoundException, Exception {
		Connection conn = null;
		PreparedStatement ms = null;
		try {
			conn = ToolsBD.getConn();
			conn.setAutoCommit(false);
			String sentencia_delete = "DELETE FROM BZOFRENT " + " WHERE REN_OFANY=? AND REN_OFOFI=? AND REN_OFNUM=?";
			ms = conn.prepareStatement(sentencia_delete);
			if (anoOficio != null)
				ms.setInt(1, Integer.parseInt(anoOficio));
			else
				ms.setInt(1, 0);
			if (oficinaOficio != null)
				ms.setInt(2, Integer.parseInt(oficinaOficio));
			else
				ms.setInt(2, 0);
			if (numeroOficio != null)
				ms.setInt(3, Integer.parseInt(numeroOficio));
			else
				ms.setInt(3, 0);
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