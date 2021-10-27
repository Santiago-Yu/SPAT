class n3375724 {
	public void importarEmissoresDosTitulosFinanceiros(File pArquivoTXT, Andamento pAndamento)
			throws FileNotFoundException, SQLException {
		Scanner in = null;
		int numeroDoRegistro = -1;
		String sql = "TRUNCATE TABLE TMP_TB_EMISSOR_TITULO";
		Statement stmtLimpezaInicialDestino = conDestino.createStatement();
		stmtLimpezaInicialDestino.executeUpdate(sql);
		sql = "INSERT INTO TMP_TB_EMISSOR_TITULO(SIGLA, NOME, CNPJ, DATA_CRIACAO) VALUES(:SIGLA, :NOME, :CNPJ, :DATA_CRIACAO)";
		OraclePreparedStatement stmtDestino = (OraclePreparedStatement) conDestino.prepareStatement(sql);
		stmtDestino.setExecuteBatch(COMANDOS_POR_LOTE);
		final int TAMANHO_DO_RODAPE_DO_ARQUIVO = 0;
		final int TAMANHO_DO_CABECALHO_DO_ARQUIVO = 0;
		final int TAMANHO_MEDIO_POR_REGISTRO = 81;
		final int TAMANHO_DOS_METADADOS_DO_ARQUIVO = TAMANHO_DO_CABECALHO_DO_ARQUIVO + TAMANHO_DO_RODAPE_DO_ARQUIVO;
		long tamanhoDosArquivos = pArquivoTXT.length();
		String registro;
		int quantidadeDeRegistrosEstimada = (int) (tamanhoDosArquivos - TAMANHO_DOS_METADADOS_DO_ARQUIVO)
				/ TAMANHO_MEDIO_POR_REGISTRO;
		String[] campos;
		try {
			int quantidadeDeRegistrosImportada = 0;
			in = new Scanner(new FileInputStream(pArquivoTXT),
					Constantes.CONJUNTO_DE_CARACTERES_DOS_ARQUIVOS_TEXTO_DA_BOVESPA.name());
			String vSIGLA, vNOME;
			numeroDoRegistro = 0;
			java.sql.Date vDATA_CRIACAO;
			BigDecimal vCNPJ;
			final String SEPARADOR_DE_CAMPOS_DO_REGISTRO = ",";
			final int QTDE_CAMPOS = CampoDoArquivoDosEmissoresDeTitulosFinanceiros.values().length;
			final String DELIMITADOR_DE_CAMPOS_DO_REGISTRO = "\"";
			while (in.hasNextLine()) {
				registro = in.nextLine();
				++numeroDoRegistro;
				stmtDestino.clearParameters();
				registro = registro.substring(1, registro.length() - 1);
				if (registro.endsWith(DELIMITADOR_DE_CAMPOS_DO_REGISTRO)) {
					registro = registro + " ";
				}
				campos = registro.split(DELIMITADOR_DE_CAMPOS_DO_REGISTRO + SEPARADOR_DE_CAMPOS_DO_REGISTRO
						+ DELIMITADOR_DE_CAMPOS_DO_REGISTRO);
				int quantidadeDeCamposEncontradosIncluindoOsVazios = campos.length;
				vSIGLA = campos[CampoDoArquivoDosEmissoresDeTitulosFinanceiros.SIGLA.ordinal()];
				if (quantidadeDeCamposEncontradosIncluindoOsVazios != QTDE_CAMPOS) {
					throw new CampoMalDelimitadoEmRegistroDoArquivoImportado(registro);
				}
				vNOME = campos[CampoDoArquivoDosEmissoresDeTitulosFinanceiros.NOME.ordinal()];
				String cnpjTmp = campos[CampoDoArquivoDosEmissoresDeTitulosFinanceiros.CNPJ.ordinal()];
				String dataDaCriacaoTmp = campos[CampoDoArquivoDosEmissoresDeTitulosFinanceiros.DATA_CRIACAO.ordinal()];
				if (cnpjTmp != null && cnpjTmp.trim().length() > 0) {
					vCNPJ = new BigDecimal(cnpjTmp);
				} else {
					vCNPJ = null;
				}
				if (dataDaCriacaoTmp != null && dataDaCriacaoTmp.trim().length() > 0) {
					Calendar calendario = Calendar.getInstance();
					int dia = Integer.parseInt(dataDaCriacaoTmp.substring(6, 8)),
							mes = Integer.parseInt(dataDaCriacaoTmp.substring(4, 6)) - 1,
							ano = Integer.parseInt(dataDaCriacaoTmp.substring(0, 4));
					calendario.clear();
					calendario.set(ano, mes, dia);
					vDATA_CRIACAO = new java.sql.Date(calendario.getTimeInMillis());
				} else {
					vDATA_CRIACAO = null;
				}
				stmtDestino.setStringAtName("SIGLA", vSIGLA);
				stmtDestino.setStringAtName("NOME", vNOME);
				stmtDestino.setBigDecimalAtName("CNPJ", vCNPJ);
				stmtDestino.setDateAtName("DATA_CRIACAO", vDATA_CRIACAO);
				quantidadeDeRegistrosImportada++;
				int contagemDasInsercoes = stmtDestino.executeUpdate();
				double percentualCompleto = (double) quantidadeDeRegistrosImportada / quantidadeDeRegistrosEstimada
						* 100;
				pAndamento.setPercentualCompleto((int) percentualCompleto);
			}
			conDestino.commit();
		} catch (Exception ex) {
			conDestino.rollback();
			ProblemaNaImportacaoDeArquivo problemaDetalhado = new ProblemaNaImportacaoDeArquivo();
			problemaDetalhado.nomeDoArquivo = pArquivoTXT.getName();
			problemaDetalhado.linhaProblematicaDoArquivo = numeroDoRegistro;
			problemaDetalhado.detalhesSobreOProblema = ex;
			throw problemaDetalhado;
		} finally {
			pAndamento.setPercentualCompleto(100);
			in.close();
			if (stmtLimpezaInicialDestino != null && (!stmtLimpezaInicialDestino.isClosed())) {
				stmtLimpezaInicialDestino.close();
			}
			if (stmtDestino != null && (!stmtDestino.isClosed())) {
				stmtDestino.close();
			}
		}
	}

}