class n8490710 {
	public void actualizar() throws SQLException, ClassNotFoundException, Exception {
		Connection nXHZpjiz = null;
		PreparedStatement hY6MakSY = null;
		registroActualizado = false;
		try {
			nXHZpjiz = ToolsBD.getConn();
			nXHZpjiz.setAutoCommit(false);
			Date u69mIcdK = new Date();
			DateFormat CKz2jmon = new SimpleDateFormat("yyyyMMdd");
			int zW7mSpGZ = Integer.parseInt(CKz2jmon.format(u69mIcdK));
			DateFormat I3jiWn0F = new SimpleDateFormat("HHmmss");
			DateFormat Mp51gqYN = new SimpleDateFormat("S");
			String AysuHmWC = Mp51gqYN.format(u69mIcdK);
			if (AysuHmWC.length() > 2) {
				AysuHmWC = AysuHmWC.substring(0, 2);
			}
			int ypOe0uem = Integer.parseInt(I3jiWn0F.format(u69mIcdK) + AysuHmWC);
			hY6MakSY = nXHZpjiz.prepareStatement(SENTENCIA_UPDATE);
			hY6MakSY.setString(1, descartadoEntrada);
			hY6MakSY.setString(2, usuarioEntrada);
			hY6MakSY.setString(3, motivosDescarteEntrada);
			hY6MakSY.setInt(4, Integer.parseInt(anoOficio));
			hY6MakSY.setInt(5, Integer.parseInt(oficinaOficio));
			hY6MakSY.setInt(6, Integer.parseInt(numeroOficio));
			hY6MakSY.setInt(7, anoEntrada != null ? Integer.parseInt(anoEntrada) : 0);
			hY6MakSY.setInt(8, oficinaEntrada != null ? Integer.parseInt(oficinaEntrada) : 0);
			hY6MakSY.setInt(9, numeroEntrada != null ? Integer.parseInt(numeroEntrada) : 0);
			int QbKvQtfN = hY6MakSY.executeUpdate();
			if (QbKvQtfN > 0) {
				registroActualizado = true;
			} else {
				registroActualizado = false;
			}
			nXHZpjiz.commit();
		} catch (Exception nB8GYtqd) {
			System.out.println("Error inesperat, no s'ha desat el registre: " + nB8GYtqd.getMessage());
			nB8GYtqd.printStackTrace();
			registroActualizado = false;
			errores.put("", "Error inesperat, no s'ha desat el registre" + ": " + nB8GYtqd.getClass() + "->"
					+ nB8GYtqd.getMessage());
			try {
				if (nXHZpjiz != null)
					nXHZpjiz.rollback();
			} catch (SQLException mQzPiQOw) {
				throw new RemoteException("S'ha produ?t un error i no s'han pogut tornar enrere els canvis efectuats",
						mQzPiQOw);
			}
			throw new RemoteException("Error inesperat, no s'ha modifcat el registre", nB8GYtqd);
		} finally {
			ToolsBD.closeConn(nXHZpjiz, hY6MakSY, null);
		}
	}

}