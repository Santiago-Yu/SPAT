class n1989226 {
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
			if (fechaOficio != null && !fechaOficio.equals("")) {
				if (fechaOficio.matches("\\d{8}")) {
					ms.setInt(1, Integer.parseInt(fechaOficio));
				} else {
					int fzafent = 0;
					try {
						fechaTest = dateF.parse(fechaOficio);
						Calendar cal = Calendar.getInstance();
						cal.setTime(fechaTest);
						DateFormat date1 = new SimpleDateFormat("yyyyMMdd");
						fzafent = Integer.parseInt(date1.format(fechaTest));
					} catch (Exception e) {
					}
					ms.setInt(1, fzafent);
				}
			} else {
				ms.setInt(1, 0);
			}
			ms.setString(2, descripcion);
			ms.setInt(3, Integer.parseInt(anoSalida));
			ms.setInt(4, Integer.parseInt(oficinaSalida));
			ms.setInt(5, Integer.parseInt(numeroSalida));
			ms.setString(6, nulo);
			ms.setString(7, motivosNulo);
			ms.setString(8, usuarioNulo);
			if (fechaNulo != null && !fechaNulo.equals("")) {
				int fzafent = 0;
				try {
					fechaTest = dateF.parse(fechaNulo);
					Calendar cal = Calendar.getInstance();
					cal.setTime(fechaTest);
					DateFormat date1 = new SimpleDateFormat("yyyyMMdd");
					fzafent = Integer.parseInt(date1.format(fechaTest));
				} catch (Exception e) {
				}
				ms.setInt(9, fzafent);
			} else {
				ms.setInt(9, 0);
			}
			if (fechaEntrada != null && !fechaEntrada.equals("")) {
				int fzafent = 0;
				try {
					fechaTest = dateF.parse(fechaEntrada);
					Calendar cal = Calendar.getInstance();
					cal.setTime(fechaTest);
					DateFormat date1 = new SimpleDateFormat("yyyyMMdd");
					fzafent = Integer.parseInt(date1.format(fechaTest));
				} catch (Exception e) {
				}
				ms.setInt(10, fzafent);
			} else {
				ms.setInt(10, 0);
			}
			ms.setString(11, descartadoEntrada);
			ms.setString(12, usuarioEntrada);
			ms.setString(13, motivosDescarteEntrada);
			if (anoEntrada != null)
				ms.setInt(14, Integer.parseInt(anoEntrada));
			else
				ms.setInt(14, 0);
			if (oficinaEntrada != null)
				ms.setInt(15, Integer.parseInt(oficinaEntrada));
			else
				ms.setInt(15, 0);
			if (numeroEntrada != null)
				ms.setInt(16, Integer.parseInt(numeroEntrada));
			else
				ms.setInt(16, 0);
			if (anoOficio != null)
				ms.setInt(17, Integer.parseInt(anoOficio));
			else
				ms.setInt(17, 0);
			if (oficinaOficio != null)
				ms.setInt(18, Integer.parseInt(oficinaOficio));
			else
				ms.setInt(18, 0);
			if (numeroOficio != null)
				ms.setInt(19, Integer.parseInt(numeroOficio));
			else
				ms.setInt(19, 0);
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
			throw new RemoteException("Error inesperat, no s'ha actualitzat la taula de gesti¨® dels ofici de remissi¨®.",
					ex);
		} finally {
			ToolsBD.closeConn(conn, ms, null);
		}
	}

}