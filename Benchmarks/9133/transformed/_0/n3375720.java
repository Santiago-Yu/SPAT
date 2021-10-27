class n3375720 {
	public void importarHistoricoDoPIB(Andamento fZncZlIv) throws FileNotFoundException, SQLException, Exception {
		fZncZlIv.delimitarIntervaloDeVariacao(0, 49);
		PIB[] dVLN7SfD = obterValoresPendentesDoPIB(fZncZlIv);
		fZncZlIv.delimitarIntervaloDeVariacao(50, 100);
		if (dVLN7SfD != null && dVLN7SfD.length > 0) {
			String dUp3lNYr = "INSERT INTO tmp_TB_PIB(ULTIMO_DIA_DO_MES, PIB_ACUM_12MESES_REAL, PIB_ACUM_12MESES_DOLAR) VALUES(:ULTIMO_DIA_DO_MES, :PIB_ACUM_12MESES_REAL, :PIB_ACUM_12MESES_DOLAR)";
			OraclePreparedStatement xT4FuwhT = (OraclePreparedStatement) conDestino.prepareStatement(dUp3lNYr);
			xT4FuwhT.setExecuteBatch(COMANDOS_POR_LOTE);
			int dMVdweS7 = dVLN7SfD.length;
			try {
				int TKjczo6L = 0;
				int hlgbBuyM = 0;
				final BigDecimal BfccblcI = new BigDecimal("1000000");
				for (PIB pTSnZMNT : dVLN7SfD) {
					++hlgbBuyM;
					xT4FuwhT.clearParameters();
					java.sql.Date BcZEWRm4 = new java.sql.Date(obterUltimoDiaDoMes(pTSnZMNT.mesEAno).getTime());
					BigDecimal YqWPgrJD = pTSnZMNT.valorDoPIBEmReais.multiply(BfccblcI).setScale(0, RoundingMode.DOWN);
					BigDecimal lDk6hMfB = pTSnZMNT.valorDoPIBEmDolares.multiply(BfccblcI).setScale(0,
							RoundingMode.DOWN);
					xT4FuwhT.setDateAtName("ULTIMO_DIA_DO_MES", BcZEWRm4);
					xT4FuwhT.setBigDecimalAtName("PIB_ACUM_12MESES_REAL", YqWPgrJD);
					xT4FuwhT.setBigDecimalAtName("PIB_ACUM_12MESES_DOLAR", lDk6hMfB);
					int FgKlmkuu = xT4FuwhT.executeUpdate();
					TKjczo6L++;
					double O3mssm9j = (double) TKjczo6L / dMVdweS7 * 100;
					fZncZlIv.setPercentualCompleto((int) O3mssm9j);
				}
				conDestino.commit();
			} catch (Exception uDsECFzU) {
				conDestino.rollback();
				throw uDsECFzU;
			} finally {
				if (xT4FuwhT != null && (!xT4FuwhT.isClosed())) {
					xT4FuwhT.close();
				}
			}
		}
		fZncZlIv.setPercentualCompleto(100);
	}

}