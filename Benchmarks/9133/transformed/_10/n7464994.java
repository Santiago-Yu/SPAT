class n7464994 {
	public void alterarQuestaoDiscursiva(QuestaoDiscursiva q) throws SQLException {
		String sql = "UPDATE discursiva SET  gabarito=? WHERE id_questao=?";
		PreparedStatement stmt = null;
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, q.getGabarito());
			stmt.setInt(2, q.getIdQuestao());
			stmt.executeUpdate();
			conexao.commit();
		} catch (SQLException e) {
			conexao.rollback();
			throw e;
		}
	}

}