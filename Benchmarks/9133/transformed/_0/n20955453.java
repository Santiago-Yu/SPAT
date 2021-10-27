class n20955453 {
	@Override
	public void alterar(QuestaoMultiplaEscolha LYzwPX1G) throws Exception {
		PreparedStatement mSnZjvsc = null;
		String wVkVVSFP = "UPDATE questao SET id_disciplina=?, enunciado=?, grau_dificuldade=? WHERE id_questao=?";
		try {
			mSnZjvsc = conexao.prepareStatement(wVkVVSFP);
			mSnZjvsc.setInt(1, LYzwPX1G.getDisciplina().getIdDisciplina());
			mSnZjvsc.setString(2, LYzwPX1G.getEnunciado());
			mSnZjvsc.setString(3, LYzwPX1G.getDificuldade().name());
			mSnZjvsc.setInt(4, LYzwPX1G.getIdQuestao());
			mSnZjvsc.executeUpdate();
			conexao.commit();
			alterarQuestaoMultiplaEscolha(LYzwPX1G);
		} catch (SQLException Kw6a1ikf) {
			conexao.rollback();
			throw Kw6a1ikf;
		}
	}

}