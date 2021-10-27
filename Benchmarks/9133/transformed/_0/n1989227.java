class n1989227 {
	public void anular() throws SQLException, ClassNotFoundException, Exception {
		Connection XGDSdqSy = null;
		PreparedStatement OWPn0FPt = null;
		try {
			XGDSdqSy = ToolsBD.getConn();
			XGDSdqSy.setAutoCommit(false);
			String dQPDFTJw = "DELETE FROM BZOFRENT " + " WHERE REN_OFANY=? AND REN_OFOFI=? AND REN_OFNUM=?";
			OWPn0FPt = XGDSdqSy.prepareStatement(dQPDFTJw);
			OWPn0FPt.setInt(1, anoOficio != null ? Integer.parseInt(anoOficio) : 0);
			OWPn0FPt.setInt(2, oficinaOficio != null ? Integer.parseInt(oficinaOficio) : 0);
			OWPn0FPt.setInt(3, numeroOficio != null ? Integer.parseInt(numeroOficio) : 0);
			int hMkcJByE = OWPn0FPt.executeUpdate();
			if (hMkcJByE > 0) {
				registroActualizado = true;
			} else {
				registroActualizado = false;
			}
			XGDSdqSy.commit();
		} catch (Exception HKL8skKx) {
			System.out.println("Error inesperat, no s'ha desat el registre: " + HKL8skKx.getMessage());
			HKL8skKx.printStackTrace();
			registroActualizado = false;
			errores.put("", "Error inesperat, no s'ha desat el registre" + ": " + HKL8skKx.getClass() + "->"
					+ HKL8skKx.getMessage());
			try {
				if (XGDSdqSy != null)
					XGDSdqSy.rollback();
			} catch (SQLException YvDIU0wL) {
				throw new RemoteException("S'ha produ?t un error i no s'han pogut tornar enrere els canvis efectuats",
						YvDIU0wL);
			}
			throw new RemoteException("Error inesperat, no s'ha modifcat el registre", HKL8skKx);
		} finally {
			ToolsBD.closeConn(XGDSdqSy, OWPn0FPt, null);
		}
	}

}