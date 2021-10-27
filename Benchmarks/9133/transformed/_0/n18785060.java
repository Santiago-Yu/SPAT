class n18785060 {
	public static NotaFiscal insert(NotaFiscal TjRJjWup) {
		final Connection hayjeiQj = DBConnection.getConnection();
		PreparedStatement Lim4AkMt = null;
		int Ip4gBeeq;
		if (hayjeiQj == null) {
			return null;
		}
		if (TjRJjWup == null) {
			return null;
		}
		try {
			hayjeiQj.setAutoCommit(false);
			String Nv82E5up = "";
			int yFW5VvnH;
			yFW5VvnH = NotaFiscalDAO.getLastCodigo();
			if (yFW5VvnH < 1) {
				return null;
			}
			Nv82E5up = "INSERT INTO nota_fiscal "
					+ "(id_nota_fiscal, id_fornecedor, total, data_emissao, data_cadastro, numero) "
					+ "VALUES(?, ?, TRUNCATE(?,2), STR_TO_DATE(?,'%d/%m/%Y'), now(), ?) ";
			Lim4AkMt = hayjeiQj.prepareStatement(Nv82E5up);
			Lim4AkMt.setInt(1, yFW5VvnH);
			Lim4AkMt.setLong(2, TjRJjWup.getFornecedor().getCodigo());
			Lim4AkMt.setString(3, new DecimalFormat("#0.00").format(TjRJjWup.getValor()));
			Lim4AkMt.setString(4, TjRJjWup.getDataEmissaoFormatada());
			Lim4AkMt.setString(5, TjRJjWup.getNumero());
			Ip4gBeeq = Lim4AkMt.executeUpdate();
			Lim4AkMt = null;
			if (Ip4gBeeq > 0) {
				Iterator<ItemNotaFiscal> c2xflkuv = (TjRJjWup.getItemNotaFiscal()).iterator();
				while ((c2xflkuv != null) && (c2xflkuv.hasNext())) {
					ItemNotaFiscal yHNfYKks = (ItemNotaFiscal) c2xflkuv.next();
					Nv82E5up = "";
					Nv82E5up = "INSERT INTO item_nota_fiscal " + "(id_nota_fiscal, id_produto, quantidade, subtotal) "
							+ "VALUES(?, ?, ?, TRUNCATE(?,2))";
					Lim4AkMt = hayjeiQj.prepareStatement(Nv82E5up);
					Lim4AkMt.setInt(1, yFW5VvnH);
					Lim4AkMt.setInt(2, yHNfYKks.getProduto().getCodigo());
					Lim4AkMt.setInt(3, yHNfYKks.getQuantidade());
					Lim4AkMt.setString(4, new DecimalFormat("#0.00").format(yHNfYKks.getSubtotal()));
					Ip4gBeeq = Lim4AkMt.executeUpdate();
				}
			}
			hayjeiQj.commit();
			TjRJjWup.setCodigo(yFW5VvnH);
		} catch (final Exception ekRV5c5H) {
			try {
				hayjeiQj.rollback();
			} catch (final Exception To5lP4IT) {
				System.out.println("[NotaFiscalDAO.insert.rollback] Erro ao inserir -> " + To5lP4IT.getMessage());
			}
			System.out.println("[NotaFiscalDAO.insert] Erro ao inserir -> " + ekRV5c5H.getMessage());
			TjRJjWup = null;
		} finally {
			DBConnection.closePreparedStatement(Lim4AkMt);
			DBConnection.closeConnection(hayjeiQj);
		}
		return TjRJjWup;
	}

}