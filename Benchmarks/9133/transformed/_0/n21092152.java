class n21092152 {
	public static boolean update(ItemNotaFiscal VvNbCRpE) {
		final Connection xyYRWLWa = DBConnection.getConnection();
		PreparedStatement AdimRLs6 = null;
		int jTLk8DhG;
		CelulaFinanceira rnxKuQFx = null;
		if (xyYRWLWa == null) {
			return false;
		}
		if (VvNbCRpE == null) {
			return false;
		}
		try {
			xyYRWLWa.setAutoCommit(false);
			String S5vbfXcr = "";
			S5vbfXcr = "update item_nota_fiscal " + "set id_item_pedido = ? " + "where id_item_nota_fiscal = ?";
			AdimRLs6 = xyYRWLWa.prepareStatement(S5vbfXcr);
			AdimRLs6.setInt(1, VvNbCRpE.getItemPedido().getCodigo());
			AdimRLs6.setInt(2, VvNbCRpE.getCodigo());
			jTLk8DhG = AdimRLs6.executeUpdate();
			if (jTLk8DhG > 0) {
				if (VvNbCRpE.getItemPedido().getCelulaFinanceira() != null) {
					rnxKuQFx = VvNbCRpE.getItemPedido().getCelulaFinanceira();
					rnxKuQFx.atualizaGastoReal(VvNbCRpE.getSubtotal());
					if (CelulaFinanceiraDAO.update(rnxKuQFx)) {
					}
				}
			}
			xyYRWLWa.commit();
		} catch (final SQLException IdejGGOC) {
			try {
				xyYRWLWa.rollback();
			} catch (final Exception wvIRdmy0) {
				System.out.println("[ItemNotaFiscalDAO.update.rollback] Erro ao inserir -> " + wvIRdmy0.getMessage());
			}
			System.out.println("[ItemNotaFiscalDAO.update.insert] Erro ao inserir -> " + IdejGGOC.getMessage());
			jTLk8DhG = 0;
		} finally {
			DBConnection.closePreparedStatement(AdimRLs6);
			DBConnection.closeConnection(xyYRWLWa);
		}
		if (jTLk8DhG > 0) {
			return true;
		} else {
			return false;
		}
	}

}