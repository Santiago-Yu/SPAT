class n12454182 {
	public void excluirTopico(Integer idDisciplina) throws Exception {
		PreparedStatement stmt = null;
		String sql = "DELETE from topico WHERE id_disciplina = ?";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, idDisciplina);
			stmt.executeUpdate();
			conexao.commit();
		} catch (SQLException e) {
			conexao.rollback();
			throw e;
		}
	}

}