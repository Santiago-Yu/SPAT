class n3375718 {
	public void importarHistoricoDeCotacoesDoDolar(Andamento pAndamento)
			throws FileNotFoundException, SQLException, Exception {
		pAndamento.delimitarIntervaloDeVariacao(0, 49);
		WSValorSerieVO[] cotacoesPendentesDoDolar = obterCotacoesPendentesDoDolar(pAndamento);
		pAndamento.delimitarIntervaloDeVariacao(50, 100);
		if (cotacoesPendentesDoDolar != null && cotacoesPendentesDoDolar.length > 0) {
			String sql = "INSERT INTO tmp_TB_COTACAO_DOLAR(DATA, PRECO) VALUES(:DATA, :PRECO)";
			OraclePreparedStatement stmtDestino = (OraclePreparedStatement) conDestino.prepareStatement(sql);
			stmtDestino.setExecuteBatch(COMANDOS_POR_LOTE);
			int quantidadeDeRegistrosASeremImportados = cotacoesPendentesDoDolar.length;
			try {
				int numeroDoRegistro = 0;
				int quantidadeDeRegistrosImportados = 0;
				for (WSValorSerieVO cotacaoPendenteDoDolar : cotacoesPendentesDoDolar) {
					++numeroDoRegistro;
					stmtDestino.clearParameters();
					int ano = cotacaoPendenteDoDolar.getAno(), mes = cotacaoPendenteDoDolar.getMes() - 1,
							dia = cotacaoPendenteDoDolar.getDia();
					Calendar calendario = Calendar.getInstance();
					calendario.clear();
					calendario.set(ano, mes, dia);
					java.sql.Date vDATA = new java.sql.Date(calendario.getTimeInMillis());
					BigDecimal vPRECO = cotacaoPendenteDoDolar.getValor();
					stmtDestino.setDateAtName("DATA", vDATA);
					stmtDestino.setBigDecimalAtName("PRECO", vPRECO);
					quantidadeDeRegistrosImportados++;
					int contagemDasInsercoes = stmtDestino.executeUpdate();
					double percentualCompleto = (double) quantidadeDeRegistrosImportados
							/ quantidadeDeRegistrosASeremImportados * 100;
					pAndamento.setPercentualCompleto((int) percentualCompleto);
				}
				conDestino.commit();
			} catch (Exception ex) {
				conDestino.rollback();
				throw ex;
			} finally {
				if (stmtDestino != null && (!stmtDestino.isClosed())) {
					stmtDestino.close();
				}
			}
		}
		pAndamento.setPercentualCompleto(100);
	}

}