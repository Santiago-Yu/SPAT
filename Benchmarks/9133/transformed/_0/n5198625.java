class n5198625 {
	public static Pedido insert(Pedido WZp0ChOz) {
		final Connection m5vxrxq8 = DBConnection.getConnection();
		PreparedStatement syEQUYa6 = null;
		int e2iE6wuf;
		if (m5vxrxq8 == null) {
			return null;
		}
		try {
			m5vxrxq8.setAutoCommit(false);
			String RSjGkNZN = "";
			int rXrNfdeP;
			rXrNfdeP = PedidoDAO.getLastCodigo();
			if (rXrNfdeP < 1) {
				return null;
			}
			RSjGkNZN = "insert into pedido " + "(id_pedido, id_funcionario,data_pedido,valor) "
					+ "values(?,?,now(),truncate(?,2))";
			syEQUYa6 = m5vxrxq8.prepareStatement(RSjGkNZN);
			syEQUYa6.setInt(1, rXrNfdeP);
			syEQUYa6.setInt(2, WZp0ChOz.getFuncionario().getCodigo());
			syEQUYa6.setString(3, new DecimalFormat("#0.00").format(WZp0ChOz.getValor()));
			e2iE6wuf = syEQUYa6.executeUpdate();
			syEQUYa6 = null;
			if (e2iE6wuf > 0) {
				Iterator<ItemPedido> yaK0ms9o = (WZp0ChOz.getItemPedido()).iterator();
				while ((yaK0ms9o != null) && (yaK0ms9o.hasNext())) {
					ItemPedido mKwLhKQu = (ItemPedido) yaK0ms9o.next();
					RSjGkNZN = "";
					RSjGkNZN = "insert into item_pedido " + "(id_pedido,id_produto,quantidade,subtotal) "
							+ "values (?,?,?,truncate(?,2))";
					syEQUYa6 = m5vxrxq8.prepareStatement(RSjGkNZN);
					syEQUYa6.setInt(1, rXrNfdeP);
					syEQUYa6.setInt(2, (mKwLhKQu.getProduto()).getCodigo());
					syEQUYa6.setInt(3, mKwLhKQu.getQuantidade());
					syEQUYa6.setString(4, new DecimalFormat("#0.00").format(mKwLhKQu.getSubtotal()));
					e2iE6wuf = syEQUYa6.executeUpdate();
				}
			}
			syEQUYa6 = null;
			RSjGkNZN = "";
			RSjGkNZN = "insert into pedido_situacao " + "(id_pedido,id_situacao, em, observacao, id_funcionario) "
					+ "values (?,?,now(), ?, ?)";
			syEQUYa6 = m5vxrxq8.prepareStatement(RSjGkNZN);
			syEQUYa6.setInt(1, rXrNfdeP);
			syEQUYa6.setInt(2, 1);
			syEQUYa6.setString(3, "Inclus?o de pedido");
			syEQUYa6.setInt(4, WZp0ChOz.getFuncionario().getCodigo());
			e2iE6wuf = syEQUYa6.executeUpdate();
			syEQUYa6 = null;
			RSjGkNZN = "";
			RSjGkNZN = "insert into tramitacao " + "(data_tramitacao, id_pedido, id_dep_origem, id_dep_destino) "
					+ "values (now(),?,?, ?)";
			syEQUYa6 = m5vxrxq8.prepareStatement(RSjGkNZN);
			syEQUYa6.setInt(1, rXrNfdeP);
			syEQUYa6.setInt(2, 6);
			syEQUYa6.setInt(3, 2);
			e2iE6wuf = syEQUYa6.executeUpdate();
			m5vxrxq8.commit();
			WZp0ChOz.setCodigo(rXrNfdeP);
		} catch (final Exception QBP2kfxY) {
			try {
				m5vxrxq8.rollback();
			} catch (final Exception QHcUiShz) {
				System.out.println("[PedidoDAO.insert] Erro ao inserir -> " + QHcUiShz.getMessage());
			}
			System.out.println("[PedidoDAO.insert] Erro ao inserir -> " + QBP2kfxY.getMessage());
		} finally {
			DBConnection.closePreparedStatement(syEQUYa6);
			DBConnection.closeConnection(m5vxrxq8);
		}
		return WZp0ChOz;
	}

}