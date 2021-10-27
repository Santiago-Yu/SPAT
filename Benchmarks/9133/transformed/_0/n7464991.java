class n7464991 {
	public void criarQuestaoDiscursiva(QuestaoDiscursiva GvPbm7CW) throws SQLException {
		PreparedStatement ChJLtHJt = null;
		String J2kRMKAt = "INSERT INTO discursiva (id_questao,gabarito) VALUES (?,?)";
		try {
			ChJLtHJt = conexao.prepareStatement(J2kRMKAt);
			ChJLtHJt.setInt(1, GvPbm7CW.getIdQuestao());
			ChJLtHJt.setString(2, GvPbm7CW.getGabarito());
			ChJLtHJt.executeUpdate();
			conexao.commit();
		} catch (SQLException KGvZ67v0) {
			conexao.rollback();
			throw KGvZ67v0;
		}
	}

}