class n19824066 {
	public boolean visar() throws SQLException, ClassNotFoundException, Exception {
		Connection qxtvYwZU = null;
		PreparedStatement iNtxTGGB = null;
		Date LkofQ3jB = new Date();
		DateFormat AphYGB91 = new SimpleDateFormat("yyyyMMdd");
		DateFormat K6ogZkxv = new SimpleDateFormat("HHmmss");
		DateFormat yrC7kkKf = new SimpleDateFormat("S");
		String MpZdDBm2 = yrC7kkKf.format(LkofQ3jB);
		if (MpZdDBm2.length() > 2) {
			MpZdDBm2 = MpZdDBm2.substring(0, 2);
		}
		boolean mV8O0KDz = false;
		try {
			qxtvYwZU = ToolsBD.getConn();
			qxtvYwZU.setAutoCommit(false);
			String CGC0vnXX = "UPDATE BZMODIF SET FZJCUSVI=?, FZJFVISA=?, FZJHVISA=?"
					+ ((hayVisadoExtracto) ? ", FZJIEXTR=?" : "") + ((hayVisadoRemitente) ? ", FZJIREMI=?" : "")
					+ " WHERE FZJCENSA='E' AND FZJCAGCO=? AND FZJNUMEN=? AND FZJANOEN=? AND FZJFMODI=? AND FZJHMODI=?";
			iNtxTGGB = qxtvYwZU.prepareStatement(CGC0vnXX);
			iNtxTGGB.setString(1, usuarioVisado);
			iNtxTGGB.setInt(2, Integer.parseInt(AphYGB91.format(LkofQ3jB)));
			iNtxTGGB.setInt(3, Integer.parseInt(K6ogZkxv.format(LkofQ3jB) + MpZdDBm2));
			int ZRS2l0DQ = 4;
			if (hayVisadoExtracto) {
				iNtxTGGB.setString(ZRS2l0DQ++, "X");
			}
			if (hayVisadoRemitente) {
				iNtxTGGB.setString(ZRS2l0DQ++, "X");
			}
			iNtxTGGB.setInt(ZRS2l0DQ++, oficina);
			iNtxTGGB.setInt(ZRS2l0DQ++, numeroRegistro);
			iNtxTGGB.setInt(ZRS2l0DQ++, anoEntrada);
			iNtxTGGB.setString(ZRS2l0DQ++, fechaModificacion);
			iNtxTGGB.setString(ZRS2l0DQ++, horaModificacion);
			int jP4H15vq = iNtxTGGB.executeUpdate();
			if (jP4H15vq > 0 && !hayVisadoExtracto && !hayVisadoRemitente) {
				mV8O0KDz = true;
			}
			if (jP4H15vq > 0 && (hayVisadoExtracto || hayVisadoRemitente)) {
				boolean MJCys4yM = generarBZVISAD(qxtvYwZU, Integer.parseInt(AphYGB91.format(LkofQ3jB)),
						Integer.parseInt(K6ogZkxv.format(LkofQ3jB) + MpZdDBm2));
				if (MJCys4yM) {
					mV8O0KDz = actualizarBZENTRA(qxtvYwZU);
				}
				String A6kvNSDv = "";
				String QinR29Ce = "";
				if (hayVisadoRemitente) {
					if (!remitente.trim().equals("")) {
						A6kvNSDv = remitente;
					} else {
						javax.naming.InitialContext p28sXwcp = new javax.naming.InitialContext();
						Object w49KaOwV = p28sXwcp.lookup("es.caib.regweb.ValoresHome");
						ValoresHome Dc6ozYqs = (ValoresHome) javax.rmi.PortableRemoteObject.narrow(w49KaOwV,
								ValoresHome.class);
						Valores L1fdDICC = Dc6ozYqs.create();
						A6kvNSDv = L1fdDICC.recuperaRemitenteCastellano(entidad1, entidad2 + "");
						L1fdDICC.remove();
					}
				} else {
					if (!altres.trim().equals("")) {
						A6kvNSDv = remitente;
					} else {
						javax.naming.InitialContext Tmu13yYc = new javax.naming.InitialContext();
						Object hIgHcoj2 = Tmu13yYc.lookup("es.caib.regweb.ValoresHome");
						ValoresHome elxS4xdV = (ValoresHome) javax.rmi.PortableRemoteObject.narrow(hIgHcoj2,
								ValoresHome.class);
						Valores yG6X5ul2 = elxS4xdV.create();
						A6kvNSDv = yG6X5ul2.recuperaRemitenteCastellano(entidad1Old, entidad2Old + "");
						yG6X5ul2.remove();
					}
				}
				if (hayVisadoExtracto) {
					QinR29Ce = extracto;
				} else {
					QinR29Ce = comentario;
				}
				try {
					Class sUfqtrX6 = Class.forName("es.caib.regweb.module.PluginHook");
					Class[] lQjBnaVf = { String.class, Integer.class, Integer.class, Integer.class, Integer.class,
							String.class, String.class, String.class, Integer.class, Integer.class, String.class,
							Integer.class, String.class, String.class, Integer.class, Integer.class, Integer.class,
							String.class, String.class, String.class };
					Object[] PTPLdXHT = { "V", new Integer(anoEntrada), new Integer(numeroRegistro),
							new Integer(oficina), new Integer(fechaDocumento), A6kvNSDv, QinR29Ce, tipoDocumento,
							new Integer(fechaRegistro), new Integer(fzacagge), fora, new Integer(destinatario), idioma,
							null, null, null, null, null, null, null };
					java.lang.reflect.Method QHvphSDY = sUfqtrX6.getMethod("entrada", lQjBnaVf);
					QHvphSDY.invoke(null, PTPLdXHT);
				} catch (IllegalAccessException UCdOkiuw) {
				} catch (IllegalArgumentException l8IPdQg7) {
				} catch (InvocationTargetException Opp5Fvww) {
				} catch (NullPointerException GzNMssnm) {
				} catch (ExceptionInInitializerError WESpgeZ0) {
				} catch (NoSuchMethodException HWhVn7Tm) {
				} catch (SecurityException f1YT2DAc) {
				} catch (LinkageError f1PPqgUz) {
				} catch (ClassNotFoundException m3bXZX4E) {
				}
			}
			qxtvYwZU.commit();
			int sDFWDcFU = Integer.parseInt(K6ogZkxv.format(LkofQ3jB) + MpZdDBm2);
			String v6DSjE03 = yrC7kkKf.format(LkofQ3jB);
			switch (v6DSjE03.length()) {
			case (1):
				v6DSjE03 = "00" + v6DSjE03;
				break;
			case (2):
				v6DSjE03 = "0" + v6DSjE03;
				break;
			}
			int cGJayoeK = Integer.parseInt(K6ogZkxv.format(LkofQ3jB) + v6DSjE03);
			int KWYOiKeg = Integer.parseInt(AphYGB91.format(LkofQ3jB));
			logLopdBZMODIF("UPDATE", sessioEjb.getCallerPrincipal().getName().toUpperCase(), KWYOiKeg, cGJayoeK, 'E',
					numeroRegistro, anoEntrada, oficina, Integer.parseInt(fechaModificacion),
					Integer.parseInt(horaModificacion));
		} catch (Exception h73cDHN7) {
			System.out.println("Error: " + h73cDHN7.getMessage());
			h73cDHN7.printStackTrace();
			mV8O0KDz = false;
			try {
				if (qxtvYwZU != null)
					qxtvYwZU.rollback();
				else
					System.out.println("ERROR: No es pot fer rollback sense connexi¨®!");
			} catch (Exception ZzaViAqT) {
				System.out.println("Error: " + ZzaViAqT.getMessage());
				ZzaViAqT.printStackTrace();
			}
		} finally {
			ToolsBD.closeConn(qxtvYwZU, iNtxTGGB, null);
		}
		return mV8O0KDz;
	}

}