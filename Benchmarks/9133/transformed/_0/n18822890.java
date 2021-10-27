class n18822890 {
	public void actualizar() throws SQLException, ClassNotFoundException, Exception {
		Connection RRyafO22 = null;
		PreparedStatement fBxmvLSc = null;
		if (!validado) {
			validado = validar();
		}
		if (!validado) {
			throw new Exception("No s'ha realitzat la validaci¨® de les dades del registre ");
		}
		registroActualizado = false;
		try {
			int Yod0DoM7;
			String Evo5mM2Z;
			fechaTest = dateF.parse(datasalida);
			Calendar psQj0a6a = Calendar.getInstance();
			psQj0a6a.setTime(fechaTest);
			DateFormat SUfu4CHc = new SimpleDateFormat("yyyyMMdd");
			Yod0DoM7 = Integer.parseInt(anoSalida);
			int asgIxQO4 = Integer.parseInt(SUfu4CHc.format(fechaTest));
			RRyafO22 = ToolsBD.getConn();
			RRyafO22.setAutoCommit(false);
			int jWdnp2fm = Integer.parseInt(numeroSalida);
			int S2nEQuKq = Integer.parseInt(oficina);
			int vsKzKT3t = 0;
			try {
				vsKzKT3t = Integer.parseInt(oficinafisica);
			} catch (Exception WqOX0eVe) {
			}
			fechaTest = dateF.parse(data);
			psQj0a6a.setTime(fechaTest);
			int jvthICIB = Integer.parseInt(SUfu4CHc.format(fechaTest));
			String RyjwNWQs, TVb5fM0a;
			if (idioex.equals("1")) {
				RyjwNWQs = comentario;
				TVb5fM0a = "";
			} else {
				RyjwNWQs = "";
				TVb5fM0a = comentario;
			}
			String VB5ap2y8;
			int B2YxMbeD, cIZ6MIOq;
			if (fora.equals("")) {
				B2YxMbeD = 90;
				cIZ6MIOq = Integer.parseInt(balears);
				VB5ap2y8 = "";
			} else {
				VB5ap2y8 = fora;
				B2YxMbeD = 0;
				cIZ6MIOq = 0;
			}
			int VTDItOlN = 0;
			int y3Bz55cP = Integer.parseInt(remitent);
			int YOtm7Po9;
			String uShhEHck;
			if (altres.equals("")) {
				altres = "";
				YOtm7Po9 = Integer.parseInt(entidad2);
				uShhEHck = entidadCastellano;
			} else {
				YOtm7Po9 = 0;
				uShhEHck = "";
			}
			int rfrXjHEj = Integer.parseInt(idioex);
			horaTest = horaF.parse(hora);
			psQj0a6a.setTime(horaTest);
			DateFormat js58Z47p = new SimpleDateFormat("HHmm");
			int djv9nZSY = Integer.parseInt(js58Z47p.format(horaTest));
			if (entrada1.equals("")) {
				entrada1 = "0";
			}
			if (entrada2.equals("")) {
				entrada2 = "0";
			}
			int tCklpU2T = Integer.parseInt(entrada1);
			int nkeMLhYo = Integer.parseInt(entrada2);
			if (disquet.equals("")) {
				disquet = "0";
			}
			int GDppzWil = Integer.parseInt(disquet);
			if (GDppzWil > 0) {
				ToolsBD.actualizaDisqueteEntrada(RRyafO22, GDppzWil, oficina, anoSalida, errores);
			}
			Date AP3OKaOW = new Date();
			DateFormat WjHIFpJq = new SimpleDateFormat("yyyyMMdd");
			int py6BjxJc = Integer.parseInt(WjHIFpJq.format(AP3OKaOW));
			DateFormat kUHz95ry = new SimpleDateFormat("HHmmss");
			DateFormat Arnnf88k = new SimpleDateFormat("S");
			String Os1GO8Cz = Arnnf88k.format(AP3OKaOW);
			if (Os1GO8Cz.length() > 2) {
				Os1GO8Cz = Os1GO8Cz.substring(0, 2);
			}
			int VFfFAWx6 = Integer.parseInt(kUHz95ry.format(AP3OKaOW) + Os1GO8Cz);
			if (correo != null) {
				String wfpyk3to = "INSERT INTO BZNCORR (FZPCENSA, FZPCAGCO, FZPANOEN, FZPNUMEN, FZPNCORR)"
						+ "VALUES (?,?,?,?,?)";
				String DZ05Kxk1 = "UPDATE BZNCORR SET FZPNCORR=? WHERE FZPCENSA=? AND FZPCAGCO=? AND FZPANOEN=? AND FZPNUMEN=?";
				String CS994Q2y = "DELETE FROM BZNCORR WHERE FZPCENSA=? AND FZPCAGCO=? AND FZPANOEN=? AND FZPNUMEN=?";
				int TDsb5Xxe = 0;
				if (!correo.trim().equals("")) {
					fBxmvLSc = RRyafO22.prepareStatement(DZ05Kxk1);
					fBxmvLSc.setString(1, correo);
					fBxmvLSc.setString(2, "S");
					fBxmvLSc.setInt(3, S2nEQuKq);
					fBxmvLSc.setInt(4, Yod0DoM7);
					fBxmvLSc.setInt(5, jWdnp2fm);
					TDsb5Xxe = fBxmvLSc.executeUpdate();
					fBxmvLSc.close();
					if (TDsb5Xxe == 0) {
						fBxmvLSc = RRyafO22.prepareStatement(wfpyk3to);
						fBxmvLSc.setString(1, "S");
						fBxmvLSc.setInt(2, S2nEQuKq);
						fBxmvLSc.setInt(3, Yod0DoM7);
						fBxmvLSc.setInt(4, jWdnp2fm);
						fBxmvLSc.setString(5, correo);
						fBxmvLSc.execute();
						fBxmvLSc.close();
					}
				} else {
					fBxmvLSc = RRyafO22.prepareStatement(CS994Q2y);
					fBxmvLSc.setString(1, "S");
					fBxmvLSc.setInt(2, S2nEQuKq);
					fBxmvLSc.setInt(3, Yod0DoM7);
					fBxmvLSc.setInt(4, jWdnp2fm);
					fBxmvLSc.execute();
				}
			}
			String oaxt0lje = "DELETE FROM BZSALOFF WHERE FOSANOEN=? AND FOSNUMEN=? AND FOSCAGCO=?";
			fBxmvLSc = RRyafO22.prepareStatement(oaxt0lje);
			fBxmvLSc.setInt(1, Yod0DoM7);
			fBxmvLSc.setInt(2, jWdnp2fm);
			fBxmvLSc.setInt(3, S2nEQuKq);
			fBxmvLSc.execute();
			fBxmvLSc.close();
			String uSd1uJN9 = "INSERT INTO BZSALOFF (FOSANOEN, FOSNUMEN, FOSCAGCO, OFS_CODI)" + "VALUES (?,?,?,?)";
			fBxmvLSc = RRyafO22.prepareStatement(uSd1uJN9);
			fBxmvLSc.setInt(1, Yod0DoM7);
			fBxmvLSc.setInt(2, jWdnp2fm);
			fBxmvLSc.setInt(3, S2nEQuKq);
			fBxmvLSc.setInt(4, vsKzKT3t);
			fBxmvLSc.execute();
			fBxmvLSc.close();
			fBxmvLSc = RRyafO22.prepareStatement("UPDATE BZSALIDA SET FZSFDOCU=?, FZSREMIT=?, FZSCONEN=?, FZSCTIPE=?, "
					+ "FZSCEDIE=?, FZSENULA=?, FZSPROCE=?, FZSFENTR=?, FZSCTAGG=?, FZSCAGGE=?, FZSCORGA=?, "
					+ "FZSCENTI=?, FZSNENTI=?, FZSHORA=?, FZSCIDIO=?, FZSCONE2=?, FZSNLOC=?, FZSALOC=?, FZSNDIS=?, "
					+ "FZSCUSU=?, FZSCIDI=? WHERE FZSANOEN=? AND FZSNUMEN=? AND FZSCAGCO=? ");
			fBxmvLSc.setInt(1, jvthICIB);
			fBxmvLSc.setString(2, (altres.length() > 30) ? altres.substring(0, 30) : altres);
			fBxmvLSc.setString(3, (RyjwNWQs.length() > 160) ? RyjwNWQs.substring(0, 160) : RyjwNWQs);
			fBxmvLSc.setString(4, (tipo.length() > 2) ? tipo.substring(0, 1) : tipo);
			fBxmvLSc.setString(5, "N");
			fBxmvLSc.setString(6, (registroAnulado.length() > 1) ? registroAnulado.substring(0, 1) : registroAnulado);
			fBxmvLSc.setString(7, (VB5ap2y8.length() > 25) ? VB5ap2y8.substring(0, 25) : VB5ap2y8);
			fBxmvLSc.setInt(8, asgIxQO4);
			fBxmvLSc.setInt(9, B2YxMbeD);
			fBxmvLSc.setInt(10, cIZ6MIOq);
			fBxmvLSc.setInt(11, y3Bz55cP);
			fBxmvLSc.setString(12, (uShhEHck.length() > 7) ? uShhEHck.substring(0, 8) : uShhEHck);
			fBxmvLSc.setInt(13, YOtm7Po9);
			fBxmvLSc.setInt(14, djv9nZSY);
			fBxmvLSc.setInt(15, rfrXjHEj);
			fBxmvLSc.setString(16, (TVb5fM0a.length() > 160) ? TVb5fM0a.substring(0, 160) : TVb5fM0a);
			fBxmvLSc.setInt(17, tCklpU2T);
			fBxmvLSc.setInt(18, nkeMLhYo);
			fBxmvLSc.setInt(19, GDppzWil);
			fBxmvLSc.setString(20, (usuario.toUpperCase().length() > 10) ? usuario.toUpperCase().substring(0, 10)
					: usuario.toUpperCase());
			fBxmvLSc.setString(21, idioma);
			fBxmvLSc.setInt(22, Yod0DoM7);
			fBxmvLSc.setInt(23, jWdnp2fm);
			fBxmvLSc.setInt(24, S2nEQuKq);
			boolean L6buDHxy = false;
			if (!motivo.equals("")) {
				javax.naming.InitialContext ZzESjHZP = new javax.naming.InitialContext();
				Object GLtyKc56 = ZzESjHZP.lookup("es.caib.regweb.RegistroModificadoSalidaHome");
				RegistroModificadoSalidaHome d5M0IS0N = (RegistroModificadoSalidaHome) javax.rmi.PortableRemoteObject
						.narrow(GLtyKc56, RegistroModificadoSalidaHome.class);
				RegistroModificadoSalida bWpKBDTK = d5M0IS0N.create();
				bWpKBDTK.setAnoSalida(Yod0DoM7);
				bWpKBDTK.setOficina(S2nEQuKq);
				if (!entidad1Nuevo.trim().equals("")) {
					if (entidad2Nuevo.equals("")) {
						entidad2Nuevo = "0";
					}
				}
				int pI1TXY2W;
				String ZS32zuTV;
				if (altresNuevo.trim().equals("")) {
					altresNuevo = "";
					pI1TXY2W = Integer.parseInt(entidad2Nuevo);
					ZS32zuTV = convierteEntidadCastellano(entidad1Nuevo, RRyafO22);
				} else {
					pI1TXY2W = 0;
					ZS32zuTV = "";
				}
				if (!ZS32zuTV.equals(uShhEHck) || pI1TXY2W != YOtm7Po9) {
					bWpKBDTK.setEntidad2(pI1TXY2W);
					bWpKBDTK.setEntidad1(ZS32zuTV);
				} else {
					bWpKBDTK.setEntidad2(0);
					bWpKBDTK.setEntidad1("");
				}
				if (!comentarioNuevo.trim().equals(comentario.trim())) {
					bWpKBDTK.setExtracto(comentarioNuevo);
				} else {
					bWpKBDTK.setExtracto("");
				}
				bWpKBDTK.setUsuarioModificacion(usuario.toUpperCase());
				bWpKBDTK.setNumeroRegistro(jWdnp2fm);
				if (altresNuevo.equals(altres)) {
					bWpKBDTK.setRemitente("");
				} else {
					bWpKBDTK.setRemitente(altresNuevo);
				}
				bWpKBDTK.setMotivo(motivo);
				L6buDHxy = bWpKBDTK.generarModificacion(RRyafO22);
				bWpKBDTK.remove();
			}
			if ((L6buDHxy && !motivo.equals("")) || motivo.equals("")) {
				int PnMnseuv = fBxmvLSc.executeUpdate();
				if (PnMnseuv > 0) {
					registroActualizado = true;
				} else {
					registroActualizado = false;
				}
				String diuQ7mNC = "";
				if (!altres.trim().equals("")) {
					diuQ7mNC = altres;
				} else {
					javax.naming.InitialContext txcCkvWs = new javax.naming.InitialContext();
					Object Db71gX9T = txcCkvWs.lookup("es.caib.regweb.ValoresHome");
					ValoresHome jWzJaAJ6 = (ValoresHome) javax.rmi.PortableRemoteObject.narrow(Db71gX9T,
							ValoresHome.class);
					Valores Ik3daXEj = jWzJaAJ6.create();
					diuQ7mNC = Ik3daXEj.recuperaRemitenteCastellano(uShhEHck, YOtm7Po9 + "");
					Ik3daXEj.remove();
				}
				try {
					Class ccCHnF8M = Class.forName("es.caib.regweb.module.PluginHook");
					Class[] lK2Zmv1b = { String.class, Integer.class, Integer.class, Integer.class, Integer.class,
							String.class, String.class, String.class, Integer.class, Integer.class, String.class,
							Integer.class, String.class };
					Object[] kysHxwjC = { "M", new Integer(Yod0DoM7), new Integer(jWdnp2fm), new Integer(S2nEQuKq),
							new Integer(jvthICIB), diuQ7mNC, comentario, tipo, new Integer(asgIxQO4),
							new Integer(cIZ6MIOq), VB5ap2y8, new Integer(y3Bz55cP), idioma };
					java.lang.reflect.Method lzAsIvx9 = ccCHnF8M.getMethod("salida", lK2Zmv1b);
					lzAsIvx9.invoke(null, kysHxwjC);
				} catch (IllegalAccessException lCPGgUi3) {
				} catch (IllegalArgumentException UhvhZucG) {
				} catch (InvocationTargetException SaoxH7rV) {
				} catch (NullPointerException Y20bwwZG) {
				} catch (ExceptionInInitializerError OCjKBnqG) {
				} catch (NoSuchMethodException y1wdwipF) {
				} catch (SecurityException oHKdqPIK) {
				} catch (LinkageError mTAZJ6sS) {
				} catch (ClassNotFoundException vYIK4c21) {
				}
				String FpmDvgNe = Arnnf88k.format(AP3OKaOW);
				switch (FpmDvgNe.length()) {
				case (1):
					FpmDvgNe = "00" + FpmDvgNe;
					break;
				case (2):
					FpmDvgNe = "0" + FpmDvgNe;
					break;
				}
				int TunWkznj = Integer.parseInt(kUHz95ry.format(AP3OKaOW) + FpmDvgNe);
				logLopdBZSALIDA("UPDATE", (usuario.toUpperCase().length() > 10) ? usuario.toUpperCase().substring(0, 10)
						: usuario.toUpperCase(), VFfFAWx6, TunWkznj, jWdnp2fm, Yod0DoM7, S2nEQuKq);
				RRyafO22.commit();
			} else {
				registroActualizado = false;
				errores.put("", "Error inesperat, no s'ha modificat el registre");
				throw new RemoteException("Error inesperat, no s'ha modifcat el registre");
			}
		} catch (Exception csVfuObt) {
			System.out.println("Error inesperat " + csVfuObt.getMessage());
			csVfuObt.printStackTrace();
			registroActualizado = false;
			errores.put("", "Error inesperat, no s'ha modificat el registre" + ": " + csVfuObt.getClass() + "->"
					+ csVfuObt.getMessage());
			try {
				if (RRyafO22 != null)
					RRyafO22.rollback();
			} catch (SQLException wsGxNjYz) {
				throw new RemoteException(
						"S'ha produ\357t un error i no s'han pogut tornar enrere els canvis efectuats", wsGxNjYz);
			}
			throw new RemoteException("Error inesperat, no s'ha modifcat el registre", csVfuObt);
		} finally {
			ToolsBD.closeConn(RRyafO22, fBxmvLSc, null);
		}
	}

}