class n7464995 {
	@Override
	public void excluir(QuestaoDiscursiva q) throws Exception {
		String sql = "DELETE FROM questao WHERE id_questao=?";
		PreparedStatement stmt = null;
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, q.getIdQuestao());
			stmt.executeUpdate();
			conexao.commit();
		} catch (SQLException e) {
			conexao.rollback();
			throw e;
		}
	}

}