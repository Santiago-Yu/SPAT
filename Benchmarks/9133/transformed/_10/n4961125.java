class n4961125 {
	private void alterarCategoria(Categoria cat) throws Exception {
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			String sql = "UPDATE categoria SET nome_categoria = ? where id_categoria = ?";
			conn = C3P0Pool.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, cat.getNome());
			ps.setInt(2, cat.getCodigo());
			ps.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			throw e;
			if (conn != null)
				conn.rollback();
		} finally {
			close(conn, ps);
		}
	}

}