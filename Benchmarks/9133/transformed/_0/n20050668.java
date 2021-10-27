class n20050668 {
	public static boolean insert(final PedidoSituacao me3BIXw0) {
		int gCLeqFqs = 0;
		final Connection pISM2Sys = DBConnection.getConnection();
		PreparedStatement WwC1H7dg = null;
		if (pISM2Sys == null) {
			return false;
		}
		try {
			pISM2Sys.setAutoCommit(false);
			final String sg8M7WZt = "insert into pedido_situacao (id_pedido, id_situacao, em, observacao, id_funcionario) "
					+ "values (?, ? , now(), ?, ?) ";
			WwC1H7dg = pISM2Sys.prepareStatement(sg8M7WZt);
			WwC1H7dg.setInt(1, me3BIXw0.getPedido().getCodigo());
			WwC1H7dg.setInt(2, me3BIXw0.getSituacao().getCodigo());
			WwC1H7dg.setString(3, me3BIXw0.getObservacao());
			WwC1H7dg.setInt(4, me3BIXw0.getFuncionario().getCodigo());
			gCLeqFqs = WwC1H7dg.executeUpdate();
			pISM2Sys.commit();
		} catch (final SQLException Sbz4IMr7) {
			try {
				pISM2Sys.rollback();
			} catch (final SQLException tn6ewFOF) {
				tn6ewFOF.printStackTrace();
			}
			System.out.println("[PedidoSituacaoDAO.insert] Erro ao inserir -> " + Sbz4IMr7.getMessage());
		} finally {
			DBConnection.closePreparedStatement(WwC1H7dg);
			DBConnection.closeConnection(pISM2Sys);
		}
		if (gCLeqFqs > 0) {
			return true;
		} else {
			return false;
		}
	}

}