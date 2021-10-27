class n7464993 {
	@Override
	public void alterar(QuestaoDiscursiva JxU8yPXG) throws Exception {
		System.out.println("ALTERAR " + JxU8yPXG.getIdQuestao());
		PreparedStatement KsugsxMx = null;
		String MalogHWw = "UPDATE questao SET id_disciplina=?, enunciado=?, grau_dificuldade=? WHERE id_questao=?";
		try {
			KsugsxMx = conexao.prepareStatement(MalogHWw);
			KsugsxMx.setInt(1, JxU8yPXG.getDisciplina().getIdDisciplina());
			KsugsxMx.setString(2, JxU8yPXG.getEnunciado());
			KsugsxMx.setString(3, JxU8yPXG.getDificuldade().name());
			KsugsxMx.setInt(4, JxU8yPXG.getIdQuestao());
			KsugsxMx.executeUpdate();
			conexao.commit();
			alterarQuestaoDiscursiva(JxU8yPXG);
		} catch (SQLException YXPtbGVW) {
			conexao.rollback();
			throw YXPtbGVW;
		}
	}

}