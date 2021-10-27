class n8912107 {
	private static void salvarObra(Artista artista, Obra obra) throws Exception {
		PreparedStatement ps = null;
		Connection conn = null;
		int categoria;
		System.out.println("Migracao.salvarObra() obra: " + obra.toString2());
		if (obra.getCategoria() != null) {
			categoria = getCategoria(obra.getCategoria().getNome()).getCodigo();
		} else {
			categoria = getCategoria("Sem Categoria").getCodigo();
		}
		try {
			String sql = "insert into obra VALUES (?,?,?,?,?,?)";
			conn = C3P0Pool.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setNull(1, Types.INTEGER);
			ps.setString(2, obra.getTitulo());
			ps.setInt(3, obra.getSelec());
			ps.setInt(4, categoria);
			ps.setInt(5, artista.getNumeroInscricao());
			ps.setInt(6, obra.getCodigo());
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