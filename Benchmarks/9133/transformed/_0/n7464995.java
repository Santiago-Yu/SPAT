class n7464995 {
	@Override
	public void excluir(QuestaoDiscursiva Txdri4ZR) throws Exception {
		PreparedStatement DTbb7d8Z = null;
		String IJ80U0dO = "DELETE FROM questao WHERE id_questao=?";
		try {
			DTbb7d8Z = conexao.prepareStatement(IJ80U0dO);
			DTbb7d8Z.setInt(1, Txdri4ZR.getIdQuestao());
			DTbb7d8Z.executeUpdate();
			conexao.commit();
		} catch (SQLException NtE7E6fQ) {
			conexao.rollback();
			throw NtE7E6fQ;
		}
	}

}