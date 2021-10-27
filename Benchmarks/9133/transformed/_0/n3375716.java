class n3375716 {
	public void importarBancoDeDadosDARI(File teL96nZN, Andamento TMaBb9E8)
			throws IOException, SQLException, InvalidFormatException {
		final String EciR37s4 = "Valor de Mercado";
		final int C7vlsBlo = 1, gNHZOyR5 = 6, r9iYLh3u = 2, T1bneEM4 = 3, JeDqqbdn = 7, bIdSiT5I = 8;
		final BigDecimal fE6VLATc = new BigDecimal("1000000000");
		int K1hOl4IV = -1;
		Statement Vl3hl6XQ = null;
		OraclePreparedStatement YFZ9ROhb = null;
		try {
			Workbook zPWGFfNN = WorkbookFactory.create(new FileInputStream(teL96nZN));
			Sheet TqRhLvU1 = zPWGFfNN.getSheet(EciR37s4);
			int mxn1c78M = 7;
			final Calendar f1jjkBu2 = Calendar.getInstance();
			f1jjkBu2.setTime(TqRhLvU1.getRow(mxn1c78M).getCell(C7vlsBlo).getDateCellValue());
			final int EsNUtEum = f1jjkBu2.get(Calendar.YEAR);
			final int Nqc382n1 = Integer.parseInt(TqRhLvU1.getRow(mxn1c78M).getCell(gNHZOyR5).getStringCellValue());
			final int TAcdjwye = Calendar.getInstance().get(Calendar.YEAR);
			Row WkSTY38F;
			int rsWl1QD4 = (TAcdjwye - Nqc382n1 + 1), M8TADTnZ = (TqRhLvU1.getPhysicalNumberOfRows() - mxn1c78M);
			final int f7u4FH6V = rsWl1QD4 + M8TADTnZ;
			int lZrtcwKX;
			BigDecimal kTB3uej5, gJhQFZFa;
			Cell EZXvGZPJ, VnSCtU4F, pEfUUtZN;
			Vl3hl6XQ = conDestino.createStatement();
			String yzhMrcB0 = "TRUNCATE TABLE TMP_TB_VALOR_MERCADO_BOLSA";
			Vl3hl6XQ.executeUpdate(yzhMrcB0);
			yzhMrcB0 = "INSERT INTO TMP_TB_VALOR_MERCADO_BOLSA(DATA, VALOR_DE_MERCADO_REAL, VALOR_DE_MERCADO_DOLAR) VALUES(:DATA, :VALOR_DE_MERCADO_REAL, :VALOR_DE_MERCADO_DOLAR)";
			YFZ9ROhb = (OraclePreparedStatement) conDestino.prepareStatement(yzhMrcB0);
			YFZ9ROhb.setExecuteBatch(COMANDOS_POR_LOTE);
			int ptvXZRgh = 0;
			Calendar HwtE1fkr = Calendar.getInstance();
			HwtE1fkr.clear();
			HwtE1fkr.set(Calendar.MONTH, Calendar.DECEMBER);
			HwtE1fkr.set(Calendar.DAY_OF_MONTH, 31);
			for (K1hOl4IV = mxn1c78M; true; K1hOl4IV++) {
				WkSTY38F = TqRhLvU1.getRow(K1hOl4IV);
				EZXvGZPJ = WkSTY38F.getCell(gNHZOyR5);
				String aLZ6Z7UW = EZXvGZPJ.getStringCellValue();
				if (aLZ6Z7UW != null && aLZ6Z7UW.length() > 0) {
					lZrtcwKX = Integer.parseInt(aLZ6Z7UW);
					if (lZrtcwKX < EsNUtEum) {
						VnSCtU4F = WkSTY38F.getCell(JeDqqbdn);
						pEfUUtZN = WkSTY38F.getCell(bIdSiT5I);
					} else {
						break;
					}
					HwtE1fkr.set(Calendar.YEAR, lZrtcwKX);
					java.sql.Date iw9agL81 = new java.sql.Date(HwtE1fkr.getTimeInMillis());
					kTB3uej5 = new BigDecimal(VnSCtU4F.getNumericCellValue()).multiply(fE6VLATc).setScale(0,
							RoundingMode.DOWN);
					gJhQFZFa = new BigDecimal(pEfUUtZN.getNumericCellValue()).multiply(fE6VLATc).setScale(0,
							RoundingMode.DOWN);
					YFZ9ROhb.clearParameters();
					YFZ9ROhb.setDateAtName("DATA", iw9agL81);
					YFZ9ROhb.setBigDecimalAtName("VALOR_DE_MERCADO_REAL", kTB3uej5);
					YFZ9ROhb.setBigDecimalAtName("VALOR_DE_MERCADO_DOLAR", gJhQFZFa);
					int GQimZctQ = YFZ9ROhb.executeUpdate();
					ptvXZRgh++;
				} else {
					break;
				}
				double kMxRrwCT = (double) ptvXZRgh / f7u4FH6V * 100;
				TMaBb9E8.setPercentualCompleto((int) kMxRrwCT);
			}
			java.util.Date wtJxOb5C = null;
			String VB4nUlux;
			final DateFormat HMJvYAhb = new SimpleDateFormat("dd/MM/yyyy", Constantes.IDIOMA_PORTUGUES_BRASILEIRO);
			final DateFormat pTwxKPZJ = new SimpleDateFormat("dd/MMM/yyyy", Constantes.IDIOMA_PORTUGUES_BRASILEIRO);
			Cell tmOCx63L;
			for (K1hOl4IV = mxn1c78M; true; K1hOl4IV++) {
				WkSTY38F = TqRhLvU1.getRow(K1hOl4IV);
				if (WkSTY38F != null) {
					tmOCx63L = WkSTY38F.getCell(C7vlsBlo);
					java.util.Date E2IyxwMa;
					if (tmOCx63L.getCellType() == Cell.CELL_TYPE_NUMERIC) {
						E2IyxwMa = tmOCx63L.getDateCellValue();
					} else {
						VB4nUlux = tmOCx63L.getStringCellValue();
						try {
							E2IyxwMa = HMJvYAhb.parse(VB4nUlux);
						} catch (ParseException haWAp7yI) {
							E2IyxwMa = pTwxKPZJ.parse(VB4nUlux);
						}
					}
					if (wtJxOb5C == null || E2IyxwMa.after(wtJxOb5C)) {
						VnSCtU4F = WkSTY38F.getCell(r9iYLh3u);
						pEfUUtZN = WkSTY38F.getCell(T1bneEM4);
						java.sql.Date xBB1uC07 = new java.sql.Date(E2IyxwMa.getTime());
						kTB3uej5 = new BigDecimal(VnSCtU4F.getNumericCellValue()).multiply(fE6VLATc).setScale(0,
								RoundingMode.DOWN);
						gJhQFZFa = new BigDecimal(pEfUUtZN.getNumericCellValue()).multiply(fE6VLATc).setScale(0,
								RoundingMode.DOWN);
						YFZ9ROhb.clearParameters();
						YFZ9ROhb.setDateAtName("DATA", xBB1uC07);
						YFZ9ROhb.setBigDecimalAtName("VALOR_DE_MERCADO_REAL", kTB3uej5);
						YFZ9ROhb.setBigDecimalAtName("VALOR_DE_MERCADO_DOLAR", gJhQFZFa);
						int H685K2Sw = YFZ9ROhb.executeUpdate();
						ptvXZRgh++;
						double RPYfVFu7 = (double) ptvXZRgh / f7u4FH6V * 100;
						TMaBb9E8.setPercentualCompleto((int) RPYfVFu7);
					}
					wtJxOb5C = E2IyxwMa;
				} else {
					break;
				}
			}
			conDestino.commit();
		} catch (Exception BlvOITpZ) {
			conDestino.rollback();
			ProblemaNaImportacaoDeArquivo iIM598Tx = new ProblemaNaImportacaoDeArquivo();
			iIM598Tx.nomeDoArquivo = teL96nZN.getName();
			iIM598Tx.linhaProblematicaDoArquivo = K1hOl4IV;
			iIM598Tx.detalhesSobreOProblema = BlvOITpZ;
			throw iIM598Tx;
		} finally {
			TMaBb9E8.setPercentualCompleto(100);
			if (Vl3hl6XQ != null && (!Vl3hl6XQ.isClosed())) {
				Vl3hl6XQ.close();
			}
			if (YFZ9ROhb != null && (!YFZ9ROhb.isClosed())) {
				YFZ9ROhb.close();
			}
		}
	}

}