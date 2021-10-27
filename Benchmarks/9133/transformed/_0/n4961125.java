class n4961125 {
	private void alterarCategoria(Categoria esuHH04T) throws Exception {
		Connection GDucNNUT = null;
		PreparedStatement wAIxmOUH = null;
		try {
			GDucNNUT = C3P0Pool.getConnection();
			String o1qoF4nM = "UPDATE categoria SET nome_categoria = ? where id_categoria = ?";
			wAIxmOUH = GDucNNUT.prepareStatement(o1qoF4nM);
			wAIxmOUH.setString(1, esuHH04T.getNome());
			wAIxmOUH.setInt(2, esuHH04T.getCodigo());
			wAIxmOUH.executeUpdate();
			GDucNNUT.commit();
		} catch (Exception Cy6gJfpo) {
			if (GDucNNUT != null)
				GDucNNUT.rollback();
			throw Cy6gJfpo;
		} finally {
			close(GDucNNUT, wAIxmOUH);
		}
	}

}