class n3375715 {
	public void importarHistoricoDeProventos(File ySuxpH1x, boolean CwJdc7Zc, Andamento CTDogPHW)
			throws IOException, SQLException, InvalidFormatException {
		int w5BGYSGP = -1;
		String oGsHUEob = "";
		Statement TETokDnK = null;
		OraclePreparedStatement akoKGLjX = null;
		try {
			Workbook pc6QoINB = WorkbookFactory.create(new FileInputStream(ySuxpH1x));
			Sheet qs7DJULK = pc6QoINB.getSheetAt(0);
			int a5nSJkhj = 2;
			int jOx9dw2M = qs7DJULK.getPhysicalNumberOfRows() - a5nSJkhj;
			String okMja1vX, jN8BrmDw, ad4TIhHH, vIWqcGFn, BvbwTMXQ;
			BigDecimal Ek0FIlPM, ckiaVqxh, DTW75X7b;
			int QMAtTZvo, XEqwMnGG;
			java.sql.Date VXToQVtk;
			DateFormat WlkXMZhg = new SimpleDateFormat("yyyyMMdd");
			DateFormat hUykOmvr = DateFormat.getDateInstance();
			Row cX0pB2Ht;
			Cell nDVHvgbA;
			java.util.Date Idd46s0S = qs7DJULK.getRow(0)
					.getCell(CampoDaPlanilhaDosProventosEmDinheiro.NOME_DE_PREGAO.ordinal()).getDateCellValue();
			Cell T7WWRoYm;
			java.util.Date AMDjYyJL;
			TETokDnK = conDestino.createStatement();
			String FChgOgen = "TRUNCATE TABLE TMP_TB_PROVENTO_EM_DINHEIRO";
			TETokDnK.executeUpdate(FChgOgen);
			FChgOgen = "INSERT INTO TMP_TB_PROVENTO_EM_DINHEIRO(NOME_DE_PREGAO, TIPO_DA_ACAO, DATA_DA_APROVACAO, VALOR_DO_PROVENTO, PROVENTO_POR_1_OU_1000_ACOES, TIPO_DO_PROVENTO, ULTIMO_DIA_COM, DATA_DO_ULTIMO_PRECO_COM, ULTIMO_PRECO_COM, PRECO_POR_1_OU_1000_ACOES, PERC_PROVENTO_POR_PRECO) VALUES(:NOME_DE_PREGAO, :TIPO_DA_ACAO, :DATA_DA_APROVACAO, :VALOR_DO_PROVENTO, :PROVENTO_POR_1_OU_1000_ACOES, :TIPO_DO_PROVENTO, :ULTIMO_DIA_COM, :DATA_DO_ULTIMO_PRECO_COM, :ULTIMO_PRECO_COM, :PRECO_POR_1_OU_1000_ACOES, :PERC_PROVENTO_POR_PRECO)";
			akoKGLjX = (OraclePreparedStatement) conDestino.prepareStatement(FChgOgen);
			akoKGLjX.setExecuteBatch(COMANDOS_POR_LOTE);
			int okdu2yPq = 0;
			final int kW0lcwzl = 1;
			for (w5BGYSGP = kW0lcwzl; true; w5BGYSGP++) {
				cX0pB2Ht = qs7DJULK.getRow(w5BGYSGP);
				if (cX0pB2Ht != null) {
					oGsHUEob = CampoDaPlanilhaDosProventosEmDinheiro.ULTIMO_DIA_COM.toString();
					T7WWRoYm = cX0pB2Ht.getCell(CampoDaPlanilhaDosProventosEmDinheiro.ULTIMO_DIA_COM.ordinal());
					if (T7WWRoYm != null) {
						if (T7WWRoYm.getCellType() == Cell.CELL_TYPE_NUMERIC) {
							AMDjYyJL = T7WWRoYm.getDateCellValue();
							if (AMDjYyJL.compareTo(Idd46s0S) <= 0 || !CwJdc7Zc) {
								VXToQVtk = new java.sql.Date(T7WWRoYm.getDateCellValue().getTime());
								oGsHUEob = CampoDaPlanilhaDosProventosEmDinheiro.NOME_DE_PREGAO.toString();
								okMja1vX = cX0pB2Ht
										.getCell(CampoDaPlanilhaDosProventosEmDinheiro.NOME_DE_PREGAO.ordinal())
										.getStringCellValue().trim();
								oGsHUEob = CampoDaPlanilhaDosProventosEmDinheiro.TIPO_DA_ACAO.toString();
								jN8BrmDw = cX0pB2Ht
										.getCell(CampoDaPlanilhaDosProventosEmDinheiro.TIPO_DA_ACAO.ordinal())
										.getStringCellValue().trim();
								oGsHUEob = CampoDaPlanilhaDosProventosEmDinheiro.DATA_DA_APROVACAO.toString();
								nDVHvgbA = cX0pB2Ht
										.getCell(CampoDaPlanilhaDosProventosEmDinheiro.DATA_DA_APROVACAO.ordinal());
								try {
									java.util.Date ZfVpGkg8;
									if (nDVHvgbA.getCellType() == Cell.CELL_TYPE_NUMERIC) {
										ZfVpGkg8 = nDVHvgbA.getDateCellValue();
									} else {
										ZfVpGkg8 = hUykOmvr.parse(nDVHvgbA.getStringCellValue());
									}
									ad4TIhHH = WlkXMZhg.format(ZfVpGkg8);
								} catch (ParseException LnzD1P30) {
									ad4TIhHH = nDVHvgbA.getStringCellValue();
								}
								oGsHUEob = CampoDaPlanilhaDosProventosEmDinheiro.VALOR_DO_PROVENTO.toString();
								Ek0FIlPM = new BigDecimal(String.valueOf(cX0pB2Ht
										.getCell(CampoDaPlanilhaDosProventosEmDinheiro.VALOR_DO_PROVENTO.ordinal())
										.getNumericCellValue()));
								oGsHUEob = CampoDaPlanilhaDosProventosEmDinheiro.PROVENTO_POR_1_OU_1000_ACOES
										.toString();
								QMAtTZvo = (int) cX0pB2Ht.getCell(
										CampoDaPlanilhaDosProventosEmDinheiro.PROVENTO_POR_1_OU_1000_ACOES.ordinal())
										.getNumericCellValue();
								oGsHUEob = CampoDaPlanilhaDosProventosEmDinheiro.TIPO_DO_PROVENTO.toString();
								vIWqcGFn = cX0pB2Ht
										.getCell(CampoDaPlanilhaDosProventosEmDinheiro.TIPO_DO_PROVENTO.ordinal())
										.getStringCellValue().trim();
								oGsHUEob = CampoDaPlanilhaDosProventosEmDinheiro.DATA_DO_ULTIMO_PRECO_COM.toString();
								nDVHvgbA = cX0pB2Ht.getCell(
										CampoDaPlanilhaDosProventosEmDinheiro.DATA_DO_ULTIMO_PRECO_COM.ordinal());
								if (nDVHvgbA != null) {
									try {
										java.util.Date bo8MLlRU;
										if (nDVHvgbA.getCellType() == Cell.CELL_TYPE_NUMERIC) {
											bo8MLlRU = nDVHvgbA.getDateCellValue();
										} else {
											bo8MLlRU = hUykOmvr.parse(nDVHvgbA.getStringCellValue());
										}
										BvbwTMXQ = WlkXMZhg.format(bo8MLlRU);
									} catch (ParseException ZboRAyfx) {
										BvbwTMXQ = nDVHvgbA.getStringCellValue().trim();
									}
								} else {
									BvbwTMXQ = "";
								}
								oGsHUEob = CampoDaPlanilhaDosProventosEmDinheiro.ULTIMO_PRECO_COM.toString();
								ckiaVqxh = new BigDecimal(String.valueOf(cX0pB2Ht
										.getCell(CampoDaPlanilhaDosProventosEmDinheiro.ULTIMO_PRECO_COM.ordinal())
										.getNumericCellValue()));
								oGsHUEob = CampoDaPlanilhaDosProventosEmDinheiro.PRECO_POR_1_OU_1000_ACOES.toString();
								XEqwMnGG = (int) cX0pB2Ht.getCell(
										CampoDaPlanilhaDosProventosEmDinheiro.PRECO_POR_1_OU_1000_ACOES.ordinal())
										.getNumericCellValue();
								oGsHUEob = CampoDaPlanilhaDosProventosEmDinheiro.PROVENTO_POR_PRECO.toString();
								nDVHvgbA = cX0pB2Ht
										.getCell(CampoDaPlanilhaDosProventosEmDinheiro.PROVENTO_POR_PRECO.ordinal());
								if (nDVHvgbA != null && nDVHvgbA.getCellType() == Cell.CELL_TYPE_NUMERIC) {
									DTW75X7b = new BigDecimal(String.valueOf(nDVHvgbA.getNumericCellValue()));
								} else {
									DTW75X7b = null;
								}
								akoKGLjX.clearParameters();
								akoKGLjX.setStringAtName("NOME_DE_PREGAO", okMja1vX);
								akoKGLjX.setStringAtName("TIPO_DA_ACAO", jN8BrmDw);
								akoKGLjX.setStringAtName("DATA_DA_APROVACAO", ad4TIhHH);
								akoKGLjX.setBigDecimalAtName("VALOR_DO_PROVENTO", Ek0FIlPM);
								akoKGLjX.setIntAtName("PROVENTO_POR_1_OU_1000_ACOES", QMAtTZvo);
								akoKGLjX.setStringAtName("TIPO_DO_PROVENTO", vIWqcGFn);
								akoKGLjX.setDateAtName("ULTIMO_DIA_COM", VXToQVtk);
								akoKGLjX.setStringAtName("DATA_DO_ULTIMO_PRECO_COM", BvbwTMXQ);
								akoKGLjX.setBigDecimalAtName("ULTIMO_PRECO_COM", ckiaVqxh);
								akoKGLjX.setIntAtName("PRECO_POR_1_OU_1000_ACOES", XEqwMnGG);
								akoKGLjX.setBigDecimalAtName("PERC_PROVENTO_POR_PRECO", DTW75X7b);
								int ebvlF0Cs = akoKGLjX.executeUpdate();
								okdu2yPq++;
							}
						}
					} else {
						break;
					}
					double A4lcfigN = (double) okdu2yPq / jOx9dw2M * 100;
					CTDogPHW.setPercentualCompleto((int) A4lcfigN);
				} else {
					break;
				}
			}
			conDestino.commit();
		} catch (Exception fRBuXC9J) {
			conDestino.rollback();
			ProblemaNaImportacaoDeArquivo Izjcwdeh = new ProblemaNaImportacaoDeArquivo();
			Izjcwdeh.nomeDoArquivo = ySuxpH1x.getName();
			Izjcwdeh.linhaProblematicaDoArquivo = w5BGYSGP + 1;
			Izjcwdeh.colunaProblematicaDoArquivo = oGsHUEob;
			Izjcwdeh.detalhesSobreOProblema = fRBuXC9J;
			throw Izjcwdeh;
		} finally {
			CTDogPHW.setPercentualCompleto(100);
			if (TETokDnK != null && (!TETokDnK.isClosed())) {
				TETokDnK.close();
			}
			if (akoKGLjX != null && (!akoKGLjX.isClosed())) {
				akoKGLjX.close();
			}
		}
	}

}