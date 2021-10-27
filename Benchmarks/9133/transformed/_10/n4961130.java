class n4961130 {
	@Override
	public void delCategoria(Integer codigo) throws Exception {
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			String sql = "delete from categoria where id_categoria = ?";
			conn = C3P0Pool.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, codigo);
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