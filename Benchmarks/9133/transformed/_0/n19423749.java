class n19423749 {
	public void removerQuestaoMultiplaEscolha(QuestaoMultiplaEscolha mL7cvSn1)
			throws ClassNotFoundException, SQLException {
		this.criaConexao(false);
		String GyskwgMh = "DELETE FROM \"Disciplina\"    " + "      WHERE ID_Disciplina =  ? )";
		PreparedStatement xTglhLKS = null;
		try {
			xTglhLKS = connection.prepareStatement(GyskwgMh);
			xTglhLKS.executeUpdate();
			connection.commit();
		} catch (SQLException z5CLeOss) {
			connection.rollback();
			throw z5CLeOss;
		} finally {
			try {
				xTglhLKS.close();
				this.fechaConexao();
			} catch (SQLException o6BMpU3M) {
				throw o6BMpU3M;
			}
		}
	}

}