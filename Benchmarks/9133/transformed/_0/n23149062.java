class n23149062 {
	public static boolean insert(final CelulaFinanceira vWJI28Zs) {
		int QsMSGr9a = 0;
		final Connection o4CODRVf = DBConnection.getConnection();
		PreparedStatement MEZx1i6C = null;
		if (o4CODRVf == null) {
			return false;
		}
		try {
			o4CODRVf.setAutoCommit(false);
			final String vKkvHcSq = "insert into celula_financeira " + "(descricao, id_orgao, id_gestao, "
					+ "id_natureza_despesa, id_programa_trabalho, " + "id_unidade_orcamentaria, id_fonte_recursos, "
					+ "valor_provisionado, gasto_previsto, gasto_real, " + "saldo_previsto, saldo_real)"
					+ " values (?, ?, ?, ?, ?, ?, ?, TRUNCATE(?,2), TRUNCATE(?,2), TRUNCATE(?,2), TRUNCATE(?,2), TRUNCATE(?,2))";
			MEZx1i6C = o4CODRVf.prepareStatement(vKkvHcSq);
			MEZx1i6C.setString(1, vWJI28Zs.getDescricao());
			MEZx1i6C.setLong(2, (vWJI28Zs.getOrgao()).getCodigo());
			MEZx1i6C.setString(3, (vWJI28Zs.getGestao()).getCodigo());
			MEZx1i6C.setString(4, (vWJI28Zs.getNaturezaDespesa()).getCodigo());
			MEZx1i6C.setString(5, (vWJI28Zs.getProgramaTrabalho()).getCodigo());
			MEZx1i6C.setString(6, (vWJI28Zs.getUnidadeOrcamentaria()).getCodigo());
			MEZx1i6C.setString(7, (vWJI28Zs.getFonteRecursos()).getCodigo());
			MEZx1i6C.setDouble(8, vWJI28Zs.getValorProvisionado());
			MEZx1i6C.setDouble(9, vWJI28Zs.getGastoPrevisto());
			MEZx1i6C.setDouble(10, vWJI28Zs.getGastoReal());
			MEZx1i6C.setDouble(11, vWJI28Zs.getSaldoPrevisto());
			MEZx1i6C.setDouble(12, vWJI28Zs.getSaldoReal());
			QsMSGr9a = MEZx1i6C.executeUpdate();
			o4CODRVf.commit();
		} catch (final SQLException I3jvgh0S) {
			try {
				o4CODRVf.rollback();
			} catch (final SQLException AhjAaSYe) {
				System.out.println("[CelulaFinanceiraDAO.insert] Erro ao inserir -> " + AhjAaSYe.getMessage());
			}
			System.out.println("[CelulaFinanceiraDAO.insert] Erro ao inserir -> " + I3jvgh0S.getMessage());
		} finally {
			DBConnection.closePreparedStatement(MEZx1i6C);
			DBConnection.closeConnection(o4CODRVf);
		}
		if (QsMSGr9a > 0) {
			return true;
		} else {
			return false;
		}
	}

}