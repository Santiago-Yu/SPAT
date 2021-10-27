class n3375723 {
	public void importarEmpresasAbertas(File oyYFofjx, Andamento PEKaVYBs) throws FileNotFoundException, SQLException {
		int fLdMtGqH = -1;
		Scanner SHIxKj68 = null;
		Statement XQoyK3C3 = conDestino.createStatement();
		String jmV4vWR5 = "TRUNCATE TABLE TMP_TB_CIA_ABERTA";
		XQoyK3C3.executeUpdate(jmV4vWR5);
		jmV4vWR5 = "INSERT INTO TMP_TB_CIA_ABERTA(CODIGO_CVM, DENOMINACAO_SOCIAL, DENOMINACAO_COMERCIAL, LOGRADOURO, COMPLEMENTO, BAIRRO, CEP, MUNICIPIO, UF, DDD, TELEFONE, FAX, DENOMINACAO_ANTERIOR, SETOR_ATIVIDADE, CNPJ, DRI, AUDITOR, QUANT_DE_ACOES_ORDINARIAS, QUANT_DE_ACOES_PREF, SITUACAO, DATA_DA_SITUACAO, TIPO_PAPEL1, TIPO_PAPEL2, TIPO_PAPEL3, TIPO_PAPEL4, TIPO_PAPEL5, TIPO_PAPEL6, CONTROLE_ACIONARIO, DATA_DE_REGISTRO, DATA_DO_CANCELAMENTO, MERCADO, BOLSA1, BOLSA2, BOLSA3, BOLSA4, BOLSA5, BOLSA6, BOLSA7, BOLSA8, BOLSA9, MOTIVO_DO_CANCELAMENTO, PATRIMONIO_LIQUIDO, DATA_DO_PATRIMONIO, E_MAIL, NOME_SETOR_ATIVIDADE, DATA_DA_ACAO, TIPO_NEGOCIO1, TIPO_NEGOCIO2, TIPO_NEGOCIO3, TIPO_NEGOCIO4, TIPO_NEGOCIO5, TIPO_NEGOCIO6, TIPO_MERCADO1, TIPO_MERCADO2, TIPO_MERCADO3, TIPO_MERCADO4, TIPO_MERCADO5, TIPO_MERCADO6) VALUES(:CODIGO_CVM, :DENOMINACAO_SOCIAL, :DENOMINACAO_COMERCIAL, :LOGRADOURO, :COMPLEMENTO, :BAIRRO, :CEP, :MUNICIPIO, :UF, :DDD, :TELEFONE, :FAX, :DENOMINACAO_ANTERIOR, :SETOR_ATIVIDADE, :CNPJ, :DRI, :AUDITOR, :QUANT_DE_ACOES_ORDINARIAS, :QUANT_DE_ACOES_PREF, :SITUACAO, :DATA_DA_SITUACAO, :TIPO_PAPEL1, :TIPO_PAPEL2, :TIPO_PAPEL3, :TIPO_PAPEL4, :TIPO_PAPEL5, :TIPO_PAPEL6, :CONTROLE_ACIONARIO, :DATA_DE_REGISTRO, :DATA_DO_CANCELAMENTO, :MERCADO, :BOLSA1, :BOLSA2, :BOLSA3, :BOLSA4, :BOLSA5, :BOLSA6, :BOLSA7, :BOLSA8, :BOLSA9, :MOTIVO_DO_CANCELAMENTO, :PATRIMONIO_LIQUIDO, :DATA_DO_PATRIMONIO, :E_MAIL, :NOME_SETOR_ATIVIDADE, :DATA_DA_ACAO, :TIPO_NEGOCIO1, :TIPO_NEGOCIO2, :TIPO_NEGOCIO3, :TIPO_NEGOCIO4, :TIPO_NEGOCIO5, :TIPO_NEGOCIO6, :TIPO_MERCADO1, :TIPO_MERCADO2, :TIPO_MERCADO3, :TIPO_MERCADO4, :TIPO_MERCADO5, :TIPO_MERCADO6)";
		OraclePreparedStatement Ksij1thv = (OraclePreparedStatement) conDestino.prepareStatement(jmV4vWR5);
		Ksij1thv.setExecuteBatch(COMANDOS_POR_LOTE);
		final int cRQZlWg7 = 707;
		final int eNLguYHM = 0;
		final int pfQNHB2f = cRQZlWg7 + eNLguYHM;
		final int oGtWjtye = 659;
		long h3u9Ayt5 = oyYFofjx.length();
		int WbaG7WtW = (int) (h3u9Ayt5 - pfQNHB2f) / oGtWjtye;
		try {
			SHIxKj68 = new Scanner(new FileInputStream(oyYFofjx),
					Constantes.CONJUNTO_DE_CARACTERES_DO_ARQUIVO_TEXTO_DA_CVM.name());
			int t5C6ly0h = 0;
			String tzWdxPsj;
			String[] BqO4U8kb;
			SHIxKj68.nextLine();
			fLdMtGqH = 0;
			int lxZeb6ra;
			String AH7BlPss, QfxPpoW7, mqCq9xkn, SS3fTOIL, u3kmEhFC;
			BigDecimal MgEOXSko;
			String TcAjuQAS, uu4Nz6b7;
			BigDecimal DCs4lH29, J25nBMuU, y0iOICKM;
			String RlOYV2Ib, xvCaN2Mh;
			BigDecimal uACAblr0;
			String W7L6A24I, PQSaUwyy;
			BigDecimal K9vPWP7K, YjDLNGGS;
			String LwcvgUOc;
			java.sql.Date YeCQuhxQ;
			String FJhgbMt2, h9hk0w6M, fQw8CN0j, SZ4fvM9z, BAQcWvoF, uJRlBUKx, EngIUKwN;
			java.sql.Date gmpCklTf, FpRN7LkY;
			String qb6NDS4o, dgruqTGO, djQm0dy5, AQs5R6YT, qmc8N5XS, SbtkOR97, He6dJ76y, jYAbrQQW, RgXnZRnb, NlxO5F9u,
					NL8Ecnpd;
			BigDecimal sCr8zo2g;
			java.sql.Date vLMVmyeO;
			String GOXFsP5j, b9a0n0iH;
			java.sql.Date q8vMP6ng;
			String hQsdx9qW, Ge5eDI9S, vUYFhpO5, ZklRxz7C, z3GhwAYq, RjTg02bu, aXRdJR6E, YXT5vC85, mXtWFrX7, qolEVPjc,
					AnPxu1of, WckicOHx;
			final int TWsP7fnJ = CampoDoArquivoDasEmpresasAbertas.values().length;
			final String hb1RzElL = ";";
			while (SHIxKj68.hasNextLine()) {
				++fLdMtGqH;
				tzWdxPsj = SHIxKj68.nextLine();
				Ksij1thv.clearParameters();
				ArrayList<String> WSy0HgPh = new ArrayList<String>(TWsP7fnJ);
				StringBuilder M6rxkVnc = new StringBuilder();
				char[] zatecfIS = tzWdxPsj.toCharArray();
				char ObvV88BR;
				boolean Qsw8rsHJ = false;
				boolean T9z2CG9v, tUXTOsXX, oWLNlWsk;
				int kmroaSIL = (tzWdxPsj.length() - tzWdxPsj.replace(hb1RzElL, "").length());
				oWLNlWsk = (kmroaSIL > (TWsP7fnJ - 1));
				for (int rqum0ncu = 0; rqum0ncu < zatecfIS.length; rqum0ncu++) {
					ObvV88BR = zatecfIS[rqum0ncu];
					if (ObvV88BR == hb1RzElL.charAt(0)) {
						tUXTOsXX = (M6rxkVnc.length() > 0 && M6rxkVnc.toString().trim().length() > 0);
						if (tUXTOsXX) {
							String dASGo4mJ = null;
							if (WSy0HgPh.size() > 0) {
								dASGo4mJ = WSy0HgPh.get(WSy0HgPh.size() - 1);
							}
							T9z2CG9v = M6rxkVnc.toString().startsWith(" ");
							if (dASGo4mJ != null && T9z2CG9v && oWLNlWsk) {
								WSy0HgPh.set(WSy0HgPh.size() - 1, (dASGo4mJ + M6rxkVnc.toString()).trim());
								Qsw8rsHJ = true;
							} else {
								WSy0HgPh.add(M6rxkVnc.toString().trim());
							}
						} else {
							WSy0HgPh.add(null);
						}
						M6rxkVnc.setLength(0);
					} else {
						M6rxkVnc.append(ObvV88BR);
					}
				}
				if (tzWdxPsj.endsWith(hb1RzElL)) {
					WSy0HgPh.add(null);
				}
				if (Qsw8rsHJ && WSy0HgPh.size() < TWsP7fnJ) {
					WSy0HgPh.add(CampoDoArquivoDasEmpresasAbertas.COMPLEMENTO.ordinal(), null);
				}
				BqO4U8kb = WSy0HgPh.toArray(new String[WSy0HgPh.size()]);
				int CnTQSKbU = BqO4U8kb.length;
				if (CnTQSKbU != TWsP7fnJ) {
					throw new CampoMalDelimitadoEmRegistroDoArquivoImportado(tzWdxPsj);
				}
				lxZeb6ra = Integer.parseInt(BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.CODIGO_CVM.ordinal()]);
				AH7BlPss = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.DENOMINACAO_SOCIAL.ordinal()];
				QfxPpoW7 = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.DENOMINACAO_COMERCIAL.ordinal()];
				mqCq9xkn = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.LOGRADOURO.ordinal()];
				SS3fTOIL = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.COMPLEMENTO.ordinal()];
				u3kmEhFC = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.BAIRRO.ordinal()];
				String nZVLyVi5 = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.CEP.ordinal()];
				if (nZVLyVi5 != null && nZVLyVi5.trim().length() > 0) {
					MgEOXSko = new BigDecimal(nZVLyVi5);
				} else {
					MgEOXSko = null;
				}
				TcAjuQAS = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.MUNICIPIO.ordinal()];
				uu4Nz6b7 = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.UF.ordinal()];
				String RtJAExip = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.DDD.ordinal()],
						iF6GmYrh = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.TELEFONE.ordinal()], gGKYZ9S3 = "";
				if (RtJAExip != null && RtJAExip.trim().length() > 0) {
					gGKYZ9S3 = gGKYZ9S3 + RtJAExip;
				}
				if (iF6GmYrh != null && iF6GmYrh.trim().length() > 0) {
					gGKYZ9S3 = gGKYZ9S3 + iF6GmYrh;
				}
				if (gGKYZ9S3 != null && gGKYZ9S3.trim().length() > 0) {
					gGKYZ9S3 = new BigDecimal(gGKYZ9S3).toString();
					if (gGKYZ9S3.length() > 10 && gGKYZ9S3.endsWith("0")) {
						gGKYZ9S3 = gGKYZ9S3.substring(0, 10);
					}
					DCs4lH29 = new BigDecimal(gGKYZ9S3.substring(0, 2));
					J25nBMuU = new BigDecimal(gGKYZ9S3.substring(2));
				} else {
					DCs4lH29 = null;
					J25nBMuU = null;
				}
				String QjMorjsV = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.FAX.ordinal()];
				if (QjMorjsV != null && QjMorjsV.trim().length() > 0) {
					y0iOICKM = new BigDecimal(QjMorjsV);
				} else {
					y0iOICKM = null;
				}
				RlOYV2Ib = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.DENOMINACAO_ANTERIOR.ordinal()];
				xvCaN2Mh = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.SETOR_ATIVIDADE.ordinal()];
				String GfEEOqBG = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.CNPJ.ordinal()];
				if (GfEEOqBG != null && GfEEOqBG.trim().length() > 0) {
					uACAblr0 = new BigDecimal(GfEEOqBG);
				} else {
					uACAblr0 = null;
				}
				W7L6A24I = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.DRI.ordinal()];
				PQSaUwyy = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.AUDITOR.ordinal()];
				String n75Z0zcN = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.QUANT_DE_ACOES_ORDINARIAS.ordinal()];
				if (n75Z0zcN != null && n75Z0zcN.trim().length() > 0) {
					K9vPWP7K = new BigDecimal(n75Z0zcN);
				} else {
					K9vPWP7K = null;
				}
				String SNNIOzdF = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.QUANT_DE_ACOES_PREF.ordinal()];
				if (SNNIOzdF != null && SNNIOzdF.trim().length() > 0) {
					YjDLNGGS = new BigDecimal(SNNIOzdF);
				} else {
					YjDLNGGS = null;
				}
				LwcvgUOc = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.SITUACAO.ordinal()];
				String X1BJ0SCi = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.DATA_DA_SITUACAO.ordinal()];
				String[] kgMTesJi = X1BJ0SCi.trim().split("/");
				int rjjQTnbB = Integer.parseInt(kgMTesJi[0]), qbvhkuQa = Integer.parseInt(kgMTesJi[1]) - 1,
						ZSILgtd5 = Integer.parseInt(kgMTesJi[2]);
				Calendar bqkMVXFV = Calendar.getInstance();
				bqkMVXFV.clear();
				bqkMVXFV.set(ZSILgtd5, qbvhkuQa, rjjQTnbB);
				YeCQuhxQ = new java.sql.Date(bqkMVXFV.getTimeInMillis());
				FJhgbMt2 = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.TIPO_PAPEL1.ordinal()];
				h9hk0w6M = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.TIPO_PAPEL2.ordinal()];
				fQw8CN0j = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.TIPO_PAPEL3.ordinal()];
				SZ4fvM9z = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.TIPO_PAPEL4.ordinal()];
				BAQcWvoF = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.TIPO_PAPEL5.ordinal()];
				uJRlBUKx = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.TIPO_PAPEL6.ordinal()];
				EngIUKwN = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.CONTROLE_ACIONARIO.ordinal()];
				String iWxMOAvl = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.DATA_DE_REGISTRO.ordinal()];
				kgMTesJi = iWxMOAvl.trim().split("/");
				rjjQTnbB = Integer.parseInt(kgMTesJi[0]);
				qbvhkuQa = Integer.parseInt(kgMTesJi[1]) - 1;
				ZSILgtd5 = Integer.parseInt(kgMTesJi[2]);
				bqkMVXFV = Calendar.getInstance();
				bqkMVXFV.clear();
				bqkMVXFV.set(ZSILgtd5, qbvhkuQa, rjjQTnbB);
				gmpCklTf = new java.sql.Date(bqkMVXFV.getTimeInMillis());
				String D9uztXam = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.DATA_DO_CANCELAMENTO.ordinal()];
				if (D9uztXam != null && D9uztXam.trim().length() > 0) {
					kgMTesJi = D9uztXam.trim().split("/");
					rjjQTnbB = Integer.parseInt(kgMTesJi[0]);
					qbvhkuQa = Integer.parseInt(kgMTesJi[1]) - 1;
					ZSILgtd5 = Integer.parseInt(kgMTesJi[2]);
					bqkMVXFV = Calendar.getInstance();
					bqkMVXFV.clear();
					bqkMVXFV.set(ZSILgtd5, qbvhkuQa, rjjQTnbB);
					FpRN7LkY = new java.sql.Date(bqkMVXFV.getTimeInMillis());
				} else {
					FpRN7LkY = null;
				}
				qb6NDS4o = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.MERCADO.ordinal()];
				dgruqTGO = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.BOLSA1.ordinal()];
				djQm0dy5 = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.BOLSA2.ordinal()];
				AQs5R6YT = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.BOLSA3.ordinal()];
				qmc8N5XS = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.BOLSA4.ordinal()];
				SbtkOR97 = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.BOLSA5.ordinal()];
				He6dJ76y = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.BOLSA6.ordinal()];
				jYAbrQQW = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.BOLSA7.ordinal()];
				RgXnZRnb = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.BOLSA8.ordinal()];
				NlxO5F9u = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.BOLSA9.ordinal()];
				NL8Ecnpd = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.MOTIVO_DO_CANCELAMENTO.ordinal()];
				String QwrldaMq = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.PATRIMONIO_LIQUIDO.ordinal()];
				if (QwrldaMq != null && QwrldaMq.trim().length() > 0) {
					sCr8zo2g = new BigDecimal(QwrldaMq);
				} else {
					sCr8zo2g = null;
				}
				String l8JYsxUE = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.DATA_DO_PATRIMONIO.ordinal()];
				if (l8JYsxUE != null && l8JYsxUE.trim().length() > 0) {
					kgMTesJi = l8JYsxUE.trim().split("/");
					rjjQTnbB = Integer.parseInt(kgMTesJi[0]);
					qbvhkuQa = Integer.parseInt(kgMTesJi[1]) - 1;
					ZSILgtd5 = Integer.parseInt(kgMTesJi[2]);
					bqkMVXFV = Calendar.getInstance();
					bqkMVXFV.clear();
					bqkMVXFV.set(ZSILgtd5, qbvhkuQa, rjjQTnbB);
					vLMVmyeO = new java.sql.Date(bqkMVXFV.getTimeInMillis());
				} else {
					vLMVmyeO = null;
				}
				GOXFsP5j = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.E_MAIL.ordinal()];
				b9a0n0iH = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.NOME_SETOR_ATIVIDADE.ordinal()];
				String NwjyGmV9 = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.DATA_DA_ACAO.ordinal()];
				if (NwjyGmV9 != null && NwjyGmV9.trim().length() > 0) {
					kgMTesJi = NwjyGmV9.trim().split("/");
					rjjQTnbB = Integer.parseInt(kgMTesJi[0]);
					qbvhkuQa = Integer.parseInt(kgMTesJi[1]) - 1;
					ZSILgtd5 = Integer.parseInt(kgMTesJi[2]);
					bqkMVXFV = Calendar.getInstance();
					bqkMVXFV.clear();
					bqkMVXFV.set(ZSILgtd5, qbvhkuQa, rjjQTnbB);
					q8vMP6ng = new java.sql.Date(bqkMVXFV.getTimeInMillis());
				} else {
					q8vMP6ng = null;
				}
				hQsdx9qW = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.TIPO_NEGOCIO1.ordinal()];
				Ge5eDI9S = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.TIPO_NEGOCIO2.ordinal()];
				vUYFhpO5 = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.TIPO_NEGOCIO3.ordinal()];
				ZklRxz7C = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.TIPO_NEGOCIO4.ordinal()];
				z3GhwAYq = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.TIPO_NEGOCIO5.ordinal()];
				RjTg02bu = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.TIPO_NEGOCIO6.ordinal()];
				aXRdJR6E = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.TIPO_MERCADO1.ordinal()];
				YXT5vC85 = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.TIPO_MERCADO2.ordinal()];
				mXtWFrX7 = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.TIPO_MERCADO3.ordinal()];
				qolEVPjc = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.TIPO_MERCADO4.ordinal()];
				AnPxu1of = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.TIPO_MERCADO5.ordinal()];
				WckicOHx = BqO4U8kb[CampoDoArquivoDasEmpresasAbertas.TIPO_MERCADO6.ordinal()];
				Ksij1thv.setIntAtName("CODIGO_CVM", lxZeb6ra);
				Ksij1thv.setStringAtName("DENOMINACAO_SOCIAL", AH7BlPss);
				Ksij1thv.setStringAtName("DENOMINACAO_COMERCIAL", QfxPpoW7);
				Ksij1thv.setStringAtName("LOGRADOURO", mqCq9xkn);
				Ksij1thv.setStringAtName("COMPLEMENTO", SS3fTOIL);
				Ksij1thv.setStringAtName("BAIRRO", u3kmEhFC);
				Ksij1thv.setBigDecimalAtName("CEP", MgEOXSko);
				Ksij1thv.setStringAtName("MUNICIPIO", TcAjuQAS);
				Ksij1thv.setStringAtName("UF", uu4Nz6b7);
				Ksij1thv.setBigDecimalAtName("DDD", DCs4lH29);
				Ksij1thv.setBigDecimalAtName("TELEFONE", J25nBMuU);
				Ksij1thv.setBigDecimalAtName("FAX", y0iOICKM);
				Ksij1thv.setStringAtName("DENOMINACAO_ANTERIOR", RlOYV2Ib);
				Ksij1thv.setStringAtName("SETOR_ATIVIDADE", xvCaN2Mh);
				Ksij1thv.setBigDecimalAtName("CNPJ", uACAblr0);
				Ksij1thv.setStringAtName("DRI", W7L6A24I);
				Ksij1thv.setStringAtName("AUDITOR", PQSaUwyy);
				Ksij1thv.setBigDecimalAtName("QUANT_DE_ACOES_ORDINARIAS", K9vPWP7K);
				Ksij1thv.setBigDecimalAtName("QUANT_DE_ACOES_PREF", YjDLNGGS);
				Ksij1thv.setStringAtName("SITUACAO", LwcvgUOc);
				Ksij1thv.setDateAtName("DATA_DA_SITUACAO", YeCQuhxQ);
				Ksij1thv.setStringAtName("TIPO_PAPEL1", FJhgbMt2);
				Ksij1thv.setStringAtName("TIPO_PAPEL2", h9hk0w6M);
				Ksij1thv.setStringAtName("TIPO_PAPEL3", fQw8CN0j);
				Ksij1thv.setStringAtName("TIPO_PAPEL4", SZ4fvM9z);
				Ksij1thv.setStringAtName("TIPO_PAPEL5", BAQcWvoF);
				Ksij1thv.setStringAtName("TIPO_PAPEL6", uJRlBUKx);
				Ksij1thv.setStringAtName("CONTROLE_ACIONARIO", EngIUKwN);
				Ksij1thv.setDateAtName("DATA_DE_REGISTRO", gmpCklTf);
				Ksij1thv.setDateAtName("DATA_DO_CANCELAMENTO", FpRN7LkY);
				Ksij1thv.setStringAtName("MERCADO", qb6NDS4o);
				Ksij1thv.setStringAtName("BOLSA1", dgruqTGO);
				Ksij1thv.setStringAtName("BOLSA2", djQm0dy5);
				Ksij1thv.setStringAtName("BOLSA3", AQs5R6YT);
				Ksij1thv.setStringAtName("BOLSA4", qmc8N5XS);
				Ksij1thv.setStringAtName("BOLSA5", SbtkOR97);
				Ksij1thv.setStringAtName("BOLSA6", He6dJ76y);
				Ksij1thv.setStringAtName("BOLSA7", jYAbrQQW);
				Ksij1thv.setStringAtName("BOLSA8", RgXnZRnb);
				Ksij1thv.setStringAtName("BOLSA9", NlxO5F9u);
				Ksij1thv.setStringAtName("MOTIVO_DO_CANCELAMENTO", NL8Ecnpd);
				Ksij1thv.setBigDecimalAtName("PATRIMONIO_LIQUIDO", sCr8zo2g);
				Ksij1thv.setDateAtName("DATA_DO_PATRIMONIO", vLMVmyeO);
				Ksij1thv.setStringAtName("E_MAIL", GOXFsP5j);
				Ksij1thv.setStringAtName("NOME_SETOR_ATIVIDADE", b9a0n0iH);
				Ksij1thv.setDateAtName("DATA_DA_ACAO", q8vMP6ng);
				Ksij1thv.setStringAtName("TIPO_NEGOCIO1", hQsdx9qW);
				Ksij1thv.setStringAtName("TIPO_NEGOCIO2", Ge5eDI9S);
				Ksij1thv.setStringAtName("TIPO_NEGOCIO3", vUYFhpO5);
				Ksij1thv.setStringAtName("TIPO_NEGOCIO4", ZklRxz7C);
				Ksij1thv.setStringAtName("TIPO_NEGOCIO5", z3GhwAYq);
				Ksij1thv.setStringAtName("TIPO_NEGOCIO6", RjTg02bu);
				Ksij1thv.setStringAtName("TIPO_MERCADO1", aXRdJR6E);
				Ksij1thv.setStringAtName("TIPO_MERCADO2", YXT5vC85);
				Ksij1thv.setStringAtName("TIPO_MERCADO3", mXtWFrX7);
				Ksij1thv.setStringAtName("TIPO_MERCADO4", qolEVPjc);
				Ksij1thv.setStringAtName("TIPO_MERCADO5", AnPxu1of);
				Ksij1thv.setStringAtName("TIPO_MERCADO6", WckicOHx);
				int qlCanwd5 = Ksij1thv.executeUpdate();
				t5C6ly0h++;
				double p77PeZe9 = (double) t5C6ly0h / WbaG7WtW * 100;
				PEKaVYBs.setPercentualCompleto((int) p77PeZe9);
			}
			conDestino.commit();
		} catch (Exception qzXiQZLM) {
			conDestino.rollback();
			ProblemaNaImportacaoDeArquivo MbIbKOdH = new ProblemaNaImportacaoDeArquivo();
			MbIbKOdH.nomeDoArquivo = oyYFofjx.getName();
			MbIbKOdH.linhaProblematicaDoArquivo = fLdMtGqH;
			MbIbKOdH.detalhesSobreOProblema = qzXiQZLM;
			throw MbIbKOdH;
		} finally {
			PEKaVYBs.setPercentualCompleto(100);
			SHIxKj68.close();
			if (XQoyK3C3 != null && (!XQoyK3C3.isClosed())) {
				XQoyK3C3.close();
			}
			if (Ksij1thv != null && (!Ksij1thv.isClosed())) {
				Ksij1thv.close();
			}
		}
	}

}