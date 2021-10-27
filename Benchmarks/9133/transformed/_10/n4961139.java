class n4961139 {
	@Override
	public void delArtista(Integer numeroInscricao) throws Exception {
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			String sql = "delete from artista where numeroinscricao = ?";
			conn = C3P0Pool.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, numeroInscricao);
			ps.executeUpdate();
			delEndereco(conn, ps, numeroInscricao);
			delObras(conn, ps, numeroInscricao);
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