class n7464992 {
	public void criarTopicoQuestao(Questao opUhy7Ie, Integer VoUjNWgk) throws SQLException {
		PreparedStatement iLgjHuAl = null;
		String PKYk6x66 = "INSERT INTO questao_topico (id_questao, id_disciplina, id_topico) VALUES (?,?,?)";
		try {
			iLgjHuAl = conexao.prepareStatement(PKYk6x66);
			iLgjHuAl.setInt(1, opUhy7Ie.getIdQuestao());
			iLgjHuAl.setInt(2, opUhy7Ie.getDisciplina().getIdDisciplina());
			iLgjHuAl.setInt(3, VoUjNWgk);
			iLgjHuAl.executeUpdate();
			conexao.commit();
		} catch (SQLException urb8s5On) {
			conexao.rollback();
			throw urb8s5On;
		}
	}

}