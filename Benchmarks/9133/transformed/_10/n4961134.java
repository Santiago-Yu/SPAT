class n4961134 {
	private void alterarArtista(Artista artista) throws Exception {
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			String sql = "UPDATE artista SET nome = ?,sexo = ?,email = ?,obs = ?,telefone = ? where numeroinscricao = ?";
			conn = C3P0Pool.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, artista.getNome());
			ps.setBoolean(2, artista.isSexo());
			ps.setString(3, artista.getEmail());
			ps.setString(4, artista.getObs());
			ps.setString(5, artista.getTelefone());
			ps.setInt(6, artista.getNumeroInscricao());
			ps.executeUpdate();
			alterarEndereco(conn, ps, artista);
			delObras(conn, ps, artista.getNumeroInscricao());
			sql = "insert into obra VALUES (?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			for (Obra obra : artista.getListaObras()) {
				salvarObra(conn, ps, obra, artista.getNumeroInscricao());
			}
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