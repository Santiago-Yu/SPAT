class n3375716 {
	public void importarBancoDeDadosDARI(File pArquivoXLS, Andamento pAndamento)
			throws IOException, SQLException, InvalidFormatException {
		final int COLUNA_DATA = 1, COLUNA_ANO = 6, COLUNA_VALOR_DE_MERCADO_DIARIO_EM_BILHOES_DE_REAIS = 2,
				COLUNA_VALOR_DE_MERCADO_DIARIO_EM_BILHOES_DE_DOLARES = 3,
				COLUNA_VALOR_DE_MERCADO_ANUAL_EM_BILHOES_DE_REAIS = 7,
				COLUNA_VALOR_DE_MERCADO_ANUAL_EM_BILHOES_DE_DOLARES = 8;
		final String ABA_VALOR_DE_MERCADO = "Valor de Mercado";
		int iLinha = -1;
		final BigDecimal BILHAO = new BigDecimal("1000000000");
		OraclePreparedStatement stmtDestino = null;
		Statement stmtLimpezaInicialDestino = null;
		try {
			Workbook arquivo = WorkbookFactory.create(new FileInputStream(pArquivoXLS));
			int QUANTIDADE_DE_REGISTROS_DE_METADADOS = 7;
			Sheet planilhaValorDeMercado = arquivo.getSheet(ABA_VALOR_DE_MERCADO);
			final Calendar DATA_INICIAL = Calendar.getInstance();
			DATA_INICIAL.setTime(planilhaValorDeMercado.getRow(QUANTIDADE_DE_REGISTROS_DE_METADADOS)
					.getCell(COLUNA_DATA).getDateCellValue());
			final int ANO_DA_DATA_INICIAL = DATA_INICIAL.get(Calendar.YEAR);
			final int ANO_INICIAL = Integer.parseInt(planilhaValorDeMercado.getRow(QUANTIDADE_DE_REGISTROS_DE_METADADOS)
					.getCell(COLUNA_ANO).getStringCellValue());
			Row registro;
			final int ANO_FINAL = Calendar.getInstance().get(Calendar.YEAR);
			int quantidadeDeRegistrosAnuaisEstimada = (ANO_FINAL - ANO_INICIAL + 1),
					quantidadeDeRegistrosDiariosEstimada = (planilhaValorDeMercado.getPhysicalNumberOfRows()
							- QUANTIDADE_DE_REGISTROS_DE_METADADOS);
			int vAno;
			final int quantidadeDeRegistrosEstimada = quantidadeDeRegistrosAnuaisEstimada
					+ quantidadeDeRegistrosDiariosEstimada;
			Cell celulaDoAno, celulaDoValorDeMercadoEmReais, celulaDoValorDeMercadoEmDolares;
			BigDecimal vValorDeMercadoEmReais, vValorDeMercadoEmDolares;
			String sql = "TRUNCATE TABLE TMP_TB_VALOR_MERCADO_BOLSA";
			stmtLimpezaInicialDestino = conDestino.createStatement();
			stmtLimpezaInicialDestino.executeUpdate(sql);
			sql = "INSERT INTO TMP_TB_VALOR_MERCADO_BOLSA(DATA, VALOR_DE_MERCADO_REAL, VALOR_DE_MERCADO_DOLAR) VALUES(:DATA, :VALOR_DE_MERCADO_REAL, :VALOR_DE_MERCADO_DOLAR)";
			stmtDestino = (OraclePreparedStatement) conDestino.prepareStatement(sql);
			stmtDestino.setExecuteBatch(COMANDOS_POR_LOTE);
			Calendar calendario = Calendar.getInstance();
			int quantidadeDeRegistrosImportados = 0;
			calendario.clear();
			calendario.set(Calendar.MONTH, Calendar.DECEMBER);
			calendario.set(Calendar.DAY_OF_MONTH, 31);
			for (iLinha = QUANTIDADE_DE_REGISTROS_DE_METADADOS; true; iLinha++) {
				registro = planilhaValorDeMercado.getRow(iLinha);
				celulaDoAno = registro.getCell(COLUNA_ANO);
				String anoTmp = celulaDoAno.getStringCellValue();
				if (anoTmp != null && anoTmp.length() > 0) {
					vAno = Integer.parseInt(anoTmp);
					if (vAno < ANO_DA_DATA_INICIAL) {
						celulaDoValorDeMercadoEmReais = registro
								.getCell(COLUNA_VALOR_DE_MERCADO_ANUAL_EM_BILHOES_DE_REAIS);
						celulaDoValorDeMercadoEmDolares = registro
								.getCell(COLUNA_VALOR_DE_MERCADO_ANUAL_EM_BILHOES_DE_DOLARES);
					} else {
						break;
					}
					calendario.set(Calendar.YEAR, vAno);
					java.sql.Date vUltimoDiaDoAno = new java.sql.Date(calendario.getTimeInMillis());
					vValorDeMercadoEmReais = new BigDecimal(celulaDoValorDeMercadoEmReais.getNumericCellValue())
							.multiply(BILHAO).setScale(0, RoundingMode.DOWN);
					vValorDeMercadoEmDolares = new BigDecimal(celulaDoValorDeMercadoEmDolares.getNumericCellValue())
							.multiply(BILHAO).setScale(0, RoundingMode.DOWN);
					stmtDestino.clearParameters();
					stmtDestino.setDateAtName("DATA", vUltimoDiaDoAno);
					stmtDestino.setBigDecimalAtName("VALOR_DE_MERCADO_REAL", vValorDeMercadoEmReais);
					stmtDestino.setBigDecimalAtName("VALOR_DE_MERCADO_DOLAR", vValorDeMercadoEmDolares);
					quantidadeDeRegistrosImportados++;
					int contagemDasInsercoes = stmtDestino.executeUpdate();
				} else {
					break;
				}
				double percentualCompleto = (double) quantidadeDeRegistrosImportados / quantidadeDeRegistrosEstimada
						* 100;
				pAndamento.setPercentualCompleto((int) percentualCompleto);
			}
			String dataTmp;
			java.util.Date dataAnterior = null;
			final DateFormat formatadorDeData_ddMMyyyy = new SimpleDateFormat("dd/MM/yyyy",
					Constantes.IDIOMA_PORTUGUES_BRASILEIRO);
			Cell celulaDaData;
			final DateFormat formatadorDeData_ddMMMyyyy = new SimpleDateFormat("dd/MMM/yyyy",
					Constantes.IDIOMA_PORTUGUES_BRASILEIRO);
			for (iLinha = QUANTIDADE_DE_REGISTROS_DE_METADADOS; true; iLinha++) {
				registro = planilhaValorDeMercado.getRow(iLinha);
				if (registro != null) {
					java.util.Date data;
					celulaDaData = registro.getCell(COLUNA_DATA);
					if (celulaDaData.getCellType() == Cell.CELL_TYPE_NUMERIC) {
						data = celulaDaData.getDateCellValue();
					} else {
						dataTmp = celulaDaData.getStringCellValue();
						try {
							data = formatadorDeData_ddMMyyyy.parse(dataTmp);
						} catch (ParseException ex) {
							data = formatadorDeData_ddMMMyyyy.parse(dataTmp);
						}
					}
					if (dataAnterior == null || data.after(dataAnterior)) {
						celulaDoValorDeMercadoEmReais = registro
								.getCell(COLUNA_VALOR_DE_MERCADO_DIARIO_EM_BILHOES_DE_REAIS);
						java.sql.Date vData = new java.sql.Date(data.getTime());
						celulaDoValorDeMercadoEmDolares = registro
								.getCell(COLUNA_VALOR_DE_MERCADO_DIARIO_EM_BILHOES_DE_DOLARES);
						vValorDeMercadoEmReais = new BigDecimal(celulaDoValorDeMercadoEmReais.getNumericCellValue())
								.multiply(BILHAO).setScale(0, RoundingMode.DOWN);
						vValorDeMercadoEmDolares = new BigDecimal(celulaDoValorDeMercadoEmDolares.getNumericCellValue())
								.multiply(BILHAO).setScale(0, RoundingMode.DOWN);
						stmtDestino.clearParameters();
						stmtDestino.setDateAtName("DATA", vData);
						stmtDestino.setBigDecimalAtName("VALOR_DE_MERCADO_REAL", vValorDeMercadoEmReais);
						stmtDestino.setBigDecimalAtName("VALOR_DE_MERCADO_DOLAR", vValorDeMercadoEmDolares);
						quantidadeDeRegistrosImportados++;
						int contagemDasInsercoes = stmtDestino.executeUpdate();
						double percentualCompleto = (double) quantidadeDeRegistrosImportados
								/ quantidadeDeRegistrosEstimada * 100;
						pAndamento.setPercentualCompleto((int) percentualCompleto);
					}
					dataAnterior = data;
				} else {
					break;
				}
			}
			conDestino.commit();
		} catch (Exception ex) {
			conDestino.rollback();
			ProblemaNaImportacaoDeArquivo problemaDetalhado = new ProblemaNaImportacaoDeArquivo();
			problemaDetalhado.nomeDoArquivo = pArquivoXLS.getName();
			problemaDetalhado.linhaProblematicaDoArquivo = iLinha;
			problemaDetalhado.detalhesSobreOProblema = ex;
			throw problemaDetalhado;
		} finally {
			pAndamento.setPercentualCompleto(100);
			if (stmtLimpezaInicialDestino != null && (!stmtLimpezaInicialDestino.isClosed())) {
				stmtLimpezaInicialDestino.close();
			}
			if (stmtDestino != null && (!stmtDestino.isClosed())) {
				stmtDestino.close();
			}
		}
	}

}