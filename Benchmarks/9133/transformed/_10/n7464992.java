class n7464992 {
	public void criarTopicoQuestao(Questao q, Integer idTopico) throws SQLException {
		String sql = "INSERT INTO questao_topico (id_questao, id_disciplina, id_topico) VALUES (?,?,?)";
		PreparedStatement stmt = null;
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, q.getIdQuestao());
			stmt.setInt(2, q.getDisciplina().getIdDisciplina());
			stmt.setInt(3, idTopico);
			stmt.executeUpdate();
			conexao.commit();
		} catch (SQLException e) {
			conexao.rollback();
			throw e;
		}
	}

}