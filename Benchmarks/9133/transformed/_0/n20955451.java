class n20955451 {
	public void criarTopicoQuestao(Questao MUp4Z0HG, Integer D19ylbJN) throws SQLException {
		PreparedStatement Ug8OCCsv = null;
		String qh3WK3Vf = "INSERT INTO questao_topico (id_questao, id_disciplina, id_topico) VALUES (?,?,?)";
		try {
			Ug8OCCsv = conexao.prepareStatement(qh3WK3Vf);
			Ug8OCCsv.setInt(1, MUp4Z0HG.getIdQuestao());
			Ug8OCCsv.setInt(2, MUp4Z0HG.getDisciplina().getIdDisciplina());
			Ug8OCCsv.setInt(3, D19ylbJN);
			Ug8OCCsv.executeUpdate();
			conexao.commit();
		} catch (SQLException MB3gjLT7) {
			conexao.rollback();
			throw MB3gjLT7;
		}
	}

}