class n1989226 {
	public void actualizar() throws SQLException, ClassNotFoundException, Exception {
		Connection tyTvtdS6 = null;
		PreparedStatement hd80BNwe = null;
		registroActualizado = false;
		try {
			tyTvtdS6 = ToolsBD.getConn();
			tyTvtdS6.setAutoCommit(false);
			Date GuxoatMU = new Date();
			DateFormat I6R3RN3c = new SimpleDateFormat("yyyyMMdd");
			int fmMnnEvV = Integer.parseInt(I6R3RN3c.format(GuxoatMU));
			DateFormat yVOkOsBX = new SimpleDateFormat("HHmmss");
			DateFormat LtWlLTSe = new SimpleDateFormat("S");
			String b2tqKC9C = LtWlLTSe.format(GuxoatMU);
			if (b2tqKC9C.length() > 2) {
				b2tqKC9C = b2tqKC9C.substring(0, 2);
			}
			int ZpZe1vRM = Integer.parseInt(yVOkOsBX.format(GuxoatMU) + b2tqKC9C);
			hd80BNwe = tyTvtdS6.prepareStatement(SENTENCIA_UPDATE);
			if (fechaOficio != null && !fechaOficio.equals("")) {
				if (fechaOficio.matches("\\d{8}")) {
					hd80BNwe.setInt(1, Integer.parseInt(fechaOficio));
				} else {
					int ODDx7cnE = 0;
					try {
						fechaTest = dateF.parse(fechaOficio);
						Calendar ryPVjYPR = Calendar.getInstance();
						ryPVjYPR.setTime(fechaTest);
						DateFormat Q39o4YZX = new SimpleDateFormat("yyyyMMdd");
						ODDx7cnE = Integer.parseInt(Q39o4YZX.format(fechaTest));
					} catch (Exception rJCuNyvM) {
					}
					hd80BNwe.setInt(1, ODDx7cnE);
				}
			} else {
				hd80BNwe.setInt(1, 0);
			}
			hd80BNwe.setString(2, descripcion);
			hd80BNwe.setInt(3, Integer.parseInt(anoSalida));
			hd80BNwe.setInt(4, Integer.parseInt(oficinaSalida));
			hd80BNwe.setInt(5, Integer.parseInt(numeroSalida));
			hd80BNwe.setString(6, nulo);
			hd80BNwe.setString(7, motivosNulo);
			hd80BNwe.setString(8, usuarioNulo);
			if (fechaNulo != null && !fechaNulo.equals("")) {
				int mSUHN2l2 = 0;
				try {
					fechaTest = dateF.parse(fechaNulo);
					Calendar U674iJ9z = Calendar.getInstance();
					U674iJ9z.setTime(fechaTest);
					DateFormat mVpmjinq = new SimpleDateFormat("yyyyMMdd");
					mSUHN2l2 = Integer.parseInt(mVpmjinq.format(fechaTest));
				} catch (Exception QEDJrDti) {
				}
				hd80BNwe.setInt(9, mSUHN2l2);
			} else {
				hd80BNwe.setInt(9, 0);
			}
			if (fechaEntrada != null && !fechaEntrada.equals("")) {
				int IRb10r9K = 0;
				try {
					fechaTest = dateF.parse(fechaEntrada);
					Calendar Hwu1mC9X = Calendar.getInstance();
					Hwu1mC9X.setTime(fechaTest);
					DateFormat jzs1ZGya = new SimpleDateFormat("yyyyMMdd");
					IRb10r9K = Integer.parseInt(jzs1ZGya.format(fechaTest));
				} catch (Exception mTtZFlzD) {
				}
				hd80BNwe.setInt(10, IRb10r9K);
			} else {
				hd80BNwe.setInt(10, 0);
			}
			hd80BNwe.setString(11, descartadoEntrada);
			hd80BNwe.setString(12, usuarioEntrada);
			hd80BNwe.setString(13, motivosDescarteEntrada);
			hd80BNwe.setInt(14, anoEntrada != null ? Integer.parseInt(anoEntrada) : 0);
			hd80BNwe.setInt(15, oficinaEntrada != null ? Integer.parseInt(oficinaEntrada) : 0);
			hd80BNwe.setInt(16, numeroEntrada != null ? Integer.parseInt(numeroEntrada) : 0);
			hd80BNwe.setInt(17, anoOficio != null ? Integer.parseInt(anoOficio) : 0);
			hd80BNwe.setInt(18, oficinaOficio != null ? Integer.parseInt(oficinaOficio) : 0);
			hd80BNwe.setInt(19, numeroOficio != null ? Integer.parseInt(numeroOficio) : 0);
			int lPuMM99q = hd80BNwe.executeUpdate();
			if (lPuMM99q > 0) {
				registroActualizado = true;
			} else {
				registroActualizado = false;
			}
			tyTvtdS6.commit();
		} catch (Exception NrCpNa97) {
			System.out.println("Error inesperat, no s'ha desat el registre: " + NrCpNa97.getMessage());
			NrCpNa97.printStackTrace();
			registroActualizado = false;
			errores.put("", "Error inesperat, no s'ha desat el registre" + ": " + NrCpNa97.getClass() + "->"
					+ NrCpNa97.getMessage());
			try {
				if (tyTvtdS6 != null)
					tyTvtdS6.rollback();
			} catch (SQLException EiirHUhj) {
				throw new RemoteException("S'ha produ?t un error i no s'han pogut tornar enrere els canvis efectuats",
						EiirHUhj);
			}
			throw new RemoteException("Error inesperat, no s'ha actualitzat la taula de gesti¨® dels ofici de remissi¨®.",
					NrCpNa97);
		} finally {
			ToolsBD.closeConn(tyTvtdS6, hd80BNwe, null);
		}
	}

}