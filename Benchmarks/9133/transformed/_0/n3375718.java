class n3375718 {
	public void importarHistoricoDeCotacoesDoDolar(Andamento ab0DlyRU)
			throws FileNotFoundException, SQLException, Exception {
		ab0DlyRU.delimitarIntervaloDeVariacao(0, 49);
		WSValorSerieVO[] ovHBnWU1 = obterCotacoesPendentesDoDolar(ab0DlyRU);
		ab0DlyRU.delimitarIntervaloDeVariacao(50, 100);
		if (ovHBnWU1 != null && ovHBnWU1.length > 0) {
			String tg4Bmfux = "INSERT INTO tmp_TB_COTACAO_DOLAR(DATA, PRECO) VALUES(:DATA, :PRECO)";
			OraclePreparedStatement K9XlxkY7 = (OraclePreparedStatement) conDestino.prepareStatement(tg4Bmfux);
			K9XlxkY7.setExecuteBatch(COMANDOS_POR_LOTE);
			int Go2TyJDp = ovHBnWU1.length;
			try {
				int PO9ITF3Z = 0;
				int xUF3qJqg = 0;
				for (WSValorSerieVO iVyNdok3 : ovHBnWU1) {
					++xUF3qJqg;
					K9XlxkY7.clearParameters();
					int iMhIIpz7 = iVyNdok3.getAno(), gkYsKsGP = iVyNdok3.getMes() - 1, nlVQZsBy = iVyNdok3.getDia();
					Calendar sbNTp4Xw = Calendar.getInstance();
					sbNTp4Xw.clear();
					sbNTp4Xw.set(iMhIIpz7, gkYsKsGP, nlVQZsBy);
					java.sql.Date LZVFxS5V = new java.sql.Date(sbNTp4Xw.getTimeInMillis());
					BigDecimal ZjgSAQgN = iVyNdok3.getValor();
					K9XlxkY7.setDateAtName("DATA", LZVFxS5V);
					K9XlxkY7.setBigDecimalAtName("PRECO", ZjgSAQgN);
					int dgtnjiNZ = K9XlxkY7.executeUpdate();
					PO9ITF3Z++;
					double QRcCytVE = (double) PO9ITF3Z / Go2TyJDp * 100;
					ab0DlyRU.setPercentualCompleto((int) QRcCytVE);
				}
				conDestino.commit();
			} catch (Exception LamBg7P1) {
				conDestino.rollback();
				throw LamBg7P1;
			} finally {
				if (K9XlxkY7 != null && (!K9XlxkY7.isClosed())) {
					K9XlxkY7.close();
				}
			}
		}
		ab0DlyRU.setPercentualCompleto(100);
	}

}