class n8912113 {
	private static void salvarCategoria(Categoria categoria) throws Exception {
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			String sql = "insert into categoria VALUES (?,?)";
			conn = C3P0Pool.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setNull(1, Types.INTEGER);
			ps.setString(2, categoria.getNome());
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