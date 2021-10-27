class n20955455 {
	@Override
	public void excluir(QuestaoMultiplaEscolha OxlWfyVt) throws Exception {
		PreparedStatement P6Onqu7Z = null;
		String MA6IFOWF = "DELETE FROM questao WHERE id_questao=?";
		try {
			P6Onqu7Z = conexao.prepareStatement(MA6IFOWF);
			P6Onqu7Z.setInt(1, OxlWfyVt.getIdQuestao());
			P6Onqu7Z.executeUpdate();
			conexao.commit();
		} catch (SQLException W5NIIson) {
			conexao.rollback();
			throw W5NIIson;
		}
	}

}