class n17773263 {
	public boolean visar() throws SQLException, ClassNotFoundException, Exception {
		Connection CSKLuzqH = null;
		PreparedStatement cfLhXhqL = null;
		Date LazpxHiE = new Date();
		DateFormat tkgkSpR7 = new SimpleDateFormat("yyyyMMdd");
		DateFormat Va7QJUf0 = new SimpleDateFormat("HHmmss");
		DateFormat ZG0QmAOg = new SimpleDateFormat("S");
		String MlMWxcmH = ZG0QmAOg.format(LazpxHiE);
		if (MlMWxcmH.length() > 2) {
			MlMWxcmH = MlMWxcmH.substring(0, 2);
		}
		boolean CY5QR5hZ = false;
		try {
			CSKLuzqH = ToolsBD.getConn();
			CSKLuzqH.setAutoCommit(false);
			String XQjjBgTh = "UPDATE BZMODIF SET FZJCUSVI=?, FZJFVISA=?, FZJHVISA=?"
					+ ((hayVisadoExtracto) ? ", FZJIEXTR=?" : "") + ((hayVisadoRemitente) ? ", FZJIREMI=?" : "")
					+ " WHERE FZJCENSA='S' AND FZJCAGCO=? AND FZJNUMEN=? AND FZJANOEN=? AND FZJFMODI=? AND FZJHMODI=?";
			cfLhXhqL = CSKLuzqH.prepareStatement(XQjjBgTh);
			cfLhXhqL.setString(1, usuarioVisado);
			cfLhXhqL.setInt(2, Integer.parseInt(tkgkSpR7.format(LazpxHiE)));
			cfLhXhqL.setInt(3, Integer.parseInt(Va7QJUf0.format(LazpxHiE) + MlMWxcmH));
			int S8hFvuBP = 4;
			if (hayVisadoExtracto) {
				cfLhXhqL.setString(S8hFvuBP++, "X");
			}
			if (hayVisadoRemitente) {
				cfLhXhqL.setString(S8hFvuBP++, "X");
			}
			cfLhXhqL.setInt(S8hFvuBP++, oficina);
			cfLhXhqL.setInt(S8hFvuBP++, numeroRegistro);
			cfLhXhqL.setInt(S8hFvuBP++, anoSalida);
			cfLhXhqL.setString(S8hFvuBP++, fechaModificacion);
			cfLhXhqL.setString(S8hFvuBP++, horaModificacion);
			int nvKTh46u = cfLhXhqL.executeUpdate();
			if (nvKTh46u > 0 && !hayVisadoExtracto && !hayVisadoRemitente) {
				CY5QR5hZ = true;
			}
			if (nvKTh46u > 0 && (hayVisadoExtracto || hayVisadoRemitente)) {
				boolean oYSAoOhv = generarBZVISAD(CSKLuzqH, Integer.parseInt(tkgkSpR7.format(LazpxHiE)),
						Integer.parseInt(Va7QJUf0.format(LazpxHiE) + MlMWxcmH));
				if (oYSAoOhv) {
					CY5QR5hZ = actualizarBZSALIDA(CSKLuzqH);
				}
				String AvNjW1gf = "";
				String MEhrTyET = "";
				if (hayVisadoRemitente) {
					if (!remitente.trim().equals("")) {
						AvNjW1gf = remitente;
					} else {
						javax.naming.InitialContext hGWdDkXi = new javax.naming.InitialContext();
						Object ye4ORcuM = hGWdDkXi.lookup("es.caib.regweb.ValoresHome");
						ValoresHome vpthZATK = (ValoresHome) javax.rmi.PortableRemoteObject.narrow(ye4ORcuM,
								ValoresHome.class);
						Valores jqlHoQJk = vpthZATK.create();
						AvNjW1gf = jqlHoQJk.recuperaRemitenteCastellano(entidad1, entidad2 + "");
						jqlHoQJk.remove();
					}
				} else {
					if (!altres.trim().equals("")) {
						AvNjW1gf = remitente;
					} else {
						javax.naming.InitialContext mTZCqM3F = new javax.naming.InitialContext();
						Object Jjkponzg = mTZCqM3F.lookup("es.caib.regweb.ValoresHome");
						ValoresHome EqCmfvrN = (ValoresHome) javax.rmi.PortableRemoteObject.narrow(Jjkponzg,
								ValoresHome.class);
						Valores lScBPQOO = EqCmfvrN.create();
						AvNjW1gf = lScBPQOO.recuperaRemitenteCastellano(entidad1Old, entidad2Old + "");
						lScBPQOO.remove();
					}
				}
				if (hayVisadoExtracto) {
					MEhrTyET = extracto;
				} else {
					MEhrTyET = comentario;
				}
				try {
					Class pBtqd375 = Class.forName("es.caib.regweb.module.PluginHook");
					Class[] k2MEItxk = { String.class, Integer.class, Integer.class, Integer.class, Integer.class,
							String.class, String.class, String.class, Integer.class, Integer.class, String.class,
							Integer.class, String.class };
					Object[] S4C3GYGe = { "V", new Integer(anoSalida), new Integer(numeroRegistro),
							new Integer(oficina), new Integer(fechaDocumento), AvNjW1gf, MEhrTyET, tipoDocumento,
							new Integer(fechaRegistro), new Integer(fzacagge), fora, new Integer(destinatario),
							idioma };
					java.lang.reflect.Method T68kYwtx = pBtqd375.getMethod("salida", k2MEItxk);
					T68kYwtx.invoke(null, S4C3GYGe);
				} catch (IllegalAccessException h1pUyBjC) {
				} catch (IllegalArgumentException HtHf4vfR) {
				} catch (InvocationTargetException w5kx2F7I) {
				} catch (NullPointerException V8SrXFvV) {
				} catch (ExceptionInInitializerError NAP9S5n3) {
				} catch (NoSuchMethodException FhxmCLE2) {
				} catch (SecurityException Gsg6onwm) {
				} catch (LinkageError SmajwbOA) {
				} catch (ClassNotFoundException E3TQWsVG) {
				}
			}
			CSKLuzqH.commit();
			int OIIsa1wW = Integer.parseInt(Va7QJUf0.format(LazpxHiE) + MlMWxcmH);
			String cwbs9t4H = ZG0QmAOg.format(LazpxHiE);
			switch (cwbs9t4H.length()) {
			case (1):
				cwbs9t4H = "00" + cwbs9t4H;
				break;
			case (2):
				cwbs9t4H = "0" + cwbs9t4H;
				break;
			}
			int KTb3Lpf2 = Integer.parseInt(Va7QJUf0.format(LazpxHiE) + cwbs9t4H);
			int lNOaxD0a = Integer.parseInt(tkgkSpR7.format(LazpxHiE));
			logLopdBZMODIF("UPDATE", sessioEjb.getCallerPrincipal().getName().toUpperCase(), lNOaxD0a, KTb3Lpf2, 'S',
					numeroRegistro, anoSalida, oficina, Integer.parseInt(fechaModificacion),
					Integer.parseInt(horaModificacion));
		} catch (Exception UjS7tmDn) {
			System.out.println("Error: " + UjS7tmDn.getMessage());
			UjS7tmDn.printStackTrace();
			CY5QR5hZ = false;
			try {
				if (CSKLuzqH != null)
					CSKLuzqH.rollback();
				else
					System.out.println("ERROR: No es pot fer rollback sense connexi¨®!");
			} catch (Exception QtABKLxo) {
				System.out.println("Error: " + UjS7tmDn.getMessage());
				QtABKLxo.printStackTrace();
			}
		} finally {
			ToolsBD.closeConn(CSKLuzqH, cfLhXhqL, null);
		}
		return CY5QR5hZ;
	}

}