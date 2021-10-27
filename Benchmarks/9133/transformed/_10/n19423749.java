class n19423749 {
	public void removerQuestaoMultiplaEscolha(QuestaoMultiplaEscolha multiplaEscolha)
			throws ClassNotFoundException, SQLException {
		this.criaConexao(false);
		PreparedStatement stmt = null;
		String sql = "DELETE FROM \"Disciplina\"    " + "      WHERE ID_Disciplina =  ? )";
		try {
			stmt = connection.prepareStatement(sql);
			stmt.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			connection.rollback();
			throw e;
		} finally {
			try {
				stmt.close();
				this.fechaConexao();
			} catch (SQLException e) {
				throw e;
			}
		}
	}

}