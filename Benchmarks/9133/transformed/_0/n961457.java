class n961457 {
	public void actualizar() throws SQLException, ClassNotFoundException, Exception {
		Connection ArjEBdoG = null;
		PreparedStatement U1xPN9mi = null;
		if (!validado) {
			validado = validar();
		}
		if (!validado) {
			throw new Exception("No s'ha realitzat la validaci¨® de les dades del registre ");
		}
		registroActualizado = false;
		try {
			int bRN5w0Rm;
			String hG4KjvvZ;
			fechaTest = dateF.parse(dataentrada);
			Calendar hroiKPR8 = Calendar.getInstance();
			hroiKPR8.setTime(fechaTest);
			DateFormat KwF20uw7 = new SimpleDateFormat("yyyyMMdd");
			bRN5w0Rm = Integer.parseInt(anoEntrada);
			int tCTrjJBj = Integer.parseInt(KwF20uw7.format(fechaTest));
			ArjEBdoG = ToolsBD.getConn();
			ArjEBdoG.setAutoCommit(false);
			int a62RyGaP = Integer.parseInt(numeroEntrada);
			int SiEWGTUT = Integer.parseInt(oficina);
			int UX13fgAE = 0;
			try {
				UX13fgAE = Integer.parseInt(oficinafisica);
			} catch (Exception sEmFRCfO) {
			}
			fechaTest = dateF.parse(data);
			hroiKPR8.setTime(fechaTest);
			int M3SQJFlG = Integer.parseInt(KwF20uw7.format(fechaTest));
			String D4AUK2UW, L1qdNAqZ;
			if (idioex.equals("1")) {
				D4AUK2UW = comentario;
				L1qdNAqZ = "";
			} else {
				D4AUK2UW = "";
				L1qdNAqZ = comentario;
			}
			String hYPDRwq2;
			int OxO02HDs, lIo3YkQL;
			if (fora.equals("")) {
				OxO02HDs = 90;
				lIo3YkQL = Integer.parseInt(balears);
				hYPDRwq2 = "";
			} else {
				hYPDRwq2 = fora;
				OxO02HDs = 0;
				lIo3YkQL = 0;
			}
			int j3jpo0xn = 0;
			int X4r4J6HT = Integer.parseInt(destinatari);
			int T4jVZz8o;
			String X3aE4nvY;
			if (altres.equals("")) {
				altres = "";
				T4jVZz8o = Integer.parseInt(entidad2);
				X3aE4nvY = entidadCastellano;
			} else {
				T4jVZz8o = 0;
				X3aE4nvY = "";
			}
			int JfQwhq80 = Integer.parseInt(idioex);
			horaTest = horaF.parse(hora);
			hroiKPR8.setTime(horaTest);
			DateFormat scqPIJsq = new SimpleDateFormat("HHmm");
			int RDpoBA9w = Integer.parseInt(scqPIJsq.format(horaTest));
			if (salida1.equals("")) {
				salida1 = "0";
			}
			if (salida2.equals("")) {
				salida2 = "0";
			}
			int aEDnfz4T = Integer.parseInt(salida1);
			int qvgORBDK = Integer.parseInt(salida2);
			if (disquet.equals("")) {
				disquet = "0";
			}
			int Et6DfvX5 = Integer.parseInt(disquet);
			if (Et6DfvX5 > 0) {
				ToolsBD.actualizaDisqueteEntrada(ArjEBdoG, Et6DfvX5, oficina, anoEntrada, errores);
			}
			Date JqpdxrWG = new Date();
			DateFormat dNZlBVQs = new SimpleDateFormat("yyyyMMdd");
			int w3s3cxyQ = Integer.parseInt(dNZlBVQs.format(JqpdxrWG));
			DateFormat BfH8fTjT = new SimpleDateFormat("HHmmss");
			DateFormat g1VZoQ2B = new SimpleDateFormat("S");
			String bzH5T4hJ = g1VZoQ2B.format(JqpdxrWG);
			if (bzH5T4hJ.length() > 2) {
				bzH5T4hJ = bzH5T4hJ.substring(0, 2);
			}
			int IWVn21Kt = Integer.parseInt(BfH8fTjT.format(JqpdxrWG) + bzH5T4hJ);
			String rJGjoVSe = "DELETE FROM BZENTOFF WHERE FOEANOEN=? AND FOENUMEN=? AND FOECAGCO=?";
			U1xPN9mi = ArjEBdoG.prepareStatement(rJGjoVSe);
			U1xPN9mi.setInt(1, bRN5w0Rm);
			U1xPN9mi.setInt(2, a62RyGaP);
			U1xPN9mi.setInt(3, SiEWGTUT);
			U1xPN9mi.execute();
			U1xPN9mi.close();
			String l1NK1j7k = "INSERT INTO BZENTOFF (FOEANOEN, FOENUMEN, FOECAGCO, OFE_CODI)" + "VALUES (?,?,?,?)";
			U1xPN9mi = ArjEBdoG.prepareStatement(l1NK1j7k);
			U1xPN9mi.setInt(1, bRN5w0Rm);
			U1xPN9mi.setInt(2, a62RyGaP);
			U1xPN9mi.setInt(3, SiEWGTUT);
			U1xPN9mi.setInt(4, UX13fgAE);
			U1xPN9mi.execute();
			U1xPN9mi.close();
			U1xPN9mi = ArjEBdoG.prepareStatement("UPDATE BZENTRA SET FZAFDOCU=?, FZAREMIT=?, FZACONEN=?, FZACTIPE=?, "
					+ "FZACEDIE=?, FZAENULA=?, FZAPROCE=?, FZAFENTR=?, FZACTAGG=?, FZACAGGE=?, FZACORGA=?, "
					+ "FZACENTI=?, FZANENTI=?, FZAHORA=?, FZACIDIO=?, FZACONE2=?, FZANLOC=?, FZAALOC=?, FZANDIS=?, "
					+ "FZACUSU=?, FZACIDI=? WHERE FZAANOEN=? AND FZANUMEN=? AND FZACAGCO=?");
			U1xPN9mi.setInt(1, M3SQJFlG);
			U1xPN9mi.setString(2, (altres.length() > 30) ? altres.substring(0, 30) : altres);
			U1xPN9mi.setString(3, (D4AUK2UW.length() > 160) ? D4AUK2UW.substring(0, 160) : D4AUK2UW);
			U1xPN9mi.setString(4, (tipo.length() > 2) ? tipo.substring(0, 1) : tipo);
			U1xPN9mi.setString(5, "N");
			U1xPN9mi.setString(6, (registroAnulado.length() > 1) ? registroAnulado.substring(0, 1) : registroAnulado);
			U1xPN9mi.setString(7, (hYPDRwq2.length() > 25) ? hYPDRwq2.substring(0, 25) : hYPDRwq2);
			U1xPN9mi.setInt(8, tCTrjJBj);
			U1xPN9mi.setInt(9, OxO02HDs);
			U1xPN9mi.setInt(10, lIo3YkQL);
			U1xPN9mi.setInt(11, X4r4J6HT);
			U1xPN9mi.setString(12, (X3aE4nvY.length() > 7) ? X3aE4nvY.substring(0, 8) : X3aE4nvY);
			U1xPN9mi.setInt(13, T4jVZz8o);
			U1xPN9mi.setInt(14, RDpoBA9w);
			U1xPN9mi.setInt(15, JfQwhq80);
			U1xPN9mi.setString(16, (L1qdNAqZ.length() > 160) ? L1qdNAqZ.substring(0, 160) : L1qdNAqZ);
			U1xPN9mi.setInt(17, aEDnfz4T);
			U1xPN9mi.setInt(18, qvgORBDK);
			U1xPN9mi.setInt(19, Et6DfvX5);
			U1xPN9mi.setString(20, (usuario.toUpperCase().length() > 10) ? usuario.toUpperCase().substring(0, 10)
					: usuario.toUpperCase());
			U1xPN9mi.setString(21, idioma);
			U1xPN9mi.setInt(22, bRN5w0Rm);
			U1xPN9mi.setInt(23, a62RyGaP);
			U1xPN9mi.setInt(24, SiEWGTUT);
			boolean t9Fxz6jM = false;
			if (!motivo.equals("")) {
				javax.naming.InitialContext qxkHXnAe = new javax.naming.InitialContext();
				Object vhWzYq7K = qxkHXnAe.lookup("es.caib.regweb.RegistroModificadoEntradaHome");
				RegistroModificadoEntradaHome lmX1HDKQ = (RegistroModificadoEntradaHome) javax.rmi.PortableRemoteObject
						.narrow(vhWzYq7K, RegistroModificadoEntradaHome.class);
				RegistroModificadoEntrada jlohzD4w = lmX1HDKQ.create();
				jlohzD4w.setAnoEntrada(bRN5w0Rm);
				jlohzD4w.setOficina(SiEWGTUT);
				if (!entidad1Nuevo.trim().equals("")) {
					if (entidad2Nuevo.equals("")) {
						entidad2Nuevo = "0";
					}
				}
				int a7aJXa8R;
				String ow5DlDUW;
				if (altresNuevo.trim().equals("")) {
					altresNuevo = "";
					a7aJXa8R = Integer.parseInt(entidad2Nuevo);
					ow5DlDUW = convierteEntidadCastellano(entidad1Nuevo, ArjEBdoG);
				} else {
					a7aJXa8R = 0;
					ow5DlDUW = "";
				}
				if (!ow5DlDUW.equals(X3aE4nvY) || a7aJXa8R != T4jVZz8o) {
					jlohzD4w.setEntidad2(a7aJXa8R);
					jlohzD4w.setEntidad1(ow5DlDUW);
				} else {
					jlohzD4w.setEntidad2(0);
					jlohzD4w.setEntidad1("");
				}
				if (!comentarioNuevo.trim().equals(comentario.trim())) {
					jlohzD4w.setExtracto(comentarioNuevo);
				} else {
					jlohzD4w.setExtracto("");
				}
				jlohzD4w.setUsuarioModificacion(usuario.toUpperCase());
				jlohzD4w.setNumeroRegistro(a62RyGaP);
				if (altresNuevo.equals(altres)) {
					jlohzD4w.setRemitente("");
				} else {
					jlohzD4w.setRemitente(altresNuevo);
				}
				jlohzD4w.setMotivo(motivo);
				t9Fxz6jM = jlohzD4w.generarModificacion(ArjEBdoG);
				jlohzD4w.remove();
			}
			if ((t9Fxz6jM && !motivo.equals("")) || motivo.equals("")) {
				int i4RK9l0c = U1xPN9mi.executeUpdate();
				if (i4RK9l0c > 0) {
					registroActualizado = true;
				} else {
					registroActualizado = false;
				}
				String ve3FOoCI = "";
				if (!altres.trim().equals("")) {
					ve3FOoCI = altres;
				} else {
					javax.naming.InitialContext xBjwtwWk = new javax.naming.InitialContext();
					Object fCxntU7w = xBjwtwWk.lookup("es.caib.regweb.ValoresHome");
					ValoresHome QmqhowyZ = (ValoresHome) javax.rmi.PortableRemoteObject.narrow(fCxntU7w,
							ValoresHome.class);
					Valores RRX1oujm = QmqhowyZ.create();
					ve3FOoCI = RRX1oujm.recuperaRemitenteCastellano(X3aE4nvY, T4jVZz8o + "");
					RRX1oujm.remove();
				}
				try {
					Class NeLJfTl7 = Class.forName("es.caib.regweb.module.PluginHook");
					Class[] nvYyyjzC = { String.class, Integer.class, Integer.class, Integer.class, Integer.class,
							String.class, String.class, String.class, Integer.class, Integer.class, String.class,
							Integer.class, String.class, String.class, Integer.class, Integer.class, Integer.class,
							String.class, String.class, String.class };
					Object[] zLMwhwhe = { "M", new Integer(bRN5w0Rm), new Integer(a62RyGaP), new Integer(SiEWGTUT),
							new Integer(M3SQJFlG), ve3FOoCI, comentario, tipo, new Integer(tCTrjJBj),
							new Integer(lIo3YkQL), hYPDRwq2, new Integer(X4r4J6HT), idioma, BOIBdata,
							new Integer(BOIBnumeroBOCAIB), new Integer(BOIBpagina), new Integer(BOIBlineas), BOIBtexto,
							BOIBobservaciones, correo };
					java.lang.reflect.Method ZaUu4CXF = NeLJfTl7.getMethod("entrada", nvYyyjzC);
					ZaUu4CXF.invoke(null, zLMwhwhe);
				} catch (IllegalAccessException vdW6YyZ6) {
				} catch (IllegalArgumentException FYwGi5mZ) {
				} catch (InvocationTargetException cghwXJMl) {
				} catch (NullPointerException hWbmsVru) {
				} catch (ExceptionInInitializerError UKOxykvQ) {
				} catch (NoSuchMethodException ZghpTCfE) {
				} catch (SecurityException Oyo15GS7) {
				} catch (LinkageError qG0R9WtG) {
				} catch (ClassNotFoundException s7IIwrfQ) {
				}
				ArjEBdoG.commit();
				String PH8ZJbVD = g1VZoQ2B.format(JqpdxrWG);
				switch (PH8ZJbVD.length()) {
				case (1):
					PH8ZJbVD = "00" + PH8ZJbVD;
					break;
				case (2):
					PH8ZJbVD = "0" + PH8ZJbVD;
					break;
				}
				int r27EUdlR = Integer.parseInt(BfH8fTjT.format(JqpdxrWG) + PH8ZJbVD);
				logLopdBZENTRA("UPDATE", (usuario.toUpperCase().length() > 10) ? usuario.toUpperCase().substring(0, 10)
						: usuario.toUpperCase(), w3s3cxyQ, r27EUdlR, a62RyGaP, bRN5w0Rm, SiEWGTUT);
			} else {
				registroActualizado = false;
				errores.put("", "Error inesperat, no s'ha modificat el registre");
				throw new RemoteException("Error inesperat, no s'ha modifcat el registre");
			}
			System.out.println("Municipi codi: " + municipi060);
			if (municipi060.equals("000"))
				eliminar060();
			else if (!municipi060.equals(""))
				actualizar060();
		} catch (Exception g4JTCW42) {
			System.out.println("Error inesperat, no s'ha desat el registre: " + g4JTCW42.getMessage());
			g4JTCW42.printStackTrace();
			registroActualizado = false;
			errores.put("", "Error inesperat, no s'ha desat el registre" + ": " + g4JTCW42.getClass() + "->"
					+ g4JTCW42.getMessage());
			try {
				if (ArjEBdoG != null)
					ArjEBdoG.rollback();
			} catch (SQLException NvewXNjD) {
				throw new RemoteException("S'ha produ?t un error i no s'han pogut tornar enrere els canvis efectuats",
						NvewXNjD);
			}
			throw new RemoteException("Error inesperat, no s'ha modifcat el registre", g4JTCW42);
		} finally {
			ToolsBD.closeConn(ArjEBdoG, U1xPN9mi, null);
		}
	}

}