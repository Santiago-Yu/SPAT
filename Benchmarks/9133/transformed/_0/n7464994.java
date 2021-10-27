class n7464994 {
	public void alterarQuestaoDiscursiva(QuestaoDiscursiva mgUQCQiG) throws SQLException {
		PreparedStatement kI8PwKSj = null;
		String jk2vefuN = "UPDATE discursiva SET  gabarito=? WHERE id_questao=?";
		try {
			kI8PwKSj = conexao.prepareStatement(jk2vefuN);
			kI8PwKSj.setString(1, mgUQCQiG.getGabarito());
			kI8PwKSj.setInt(2, mgUQCQiG.getIdQuestao());
			kI8PwKSj.executeUpdate();
			conexao.commit();
		} catch (SQLException yITlXmvO) {
			conexao.rollback();
			throw yITlXmvO;
		}
	}

}