class n20955454 {
	public void alterarQuestaoMultiplaEscolha(QuestaoMultiplaEscolha rCUFLubf) throws SQLException {
		PreparedStatement ANRKQ13C = null;
		String lJpFnfCb = "UPDATE multipla_escolha SET texto=?, gabarito=? WHERE id_questao=?";
		try {
			for (Alternativa SqyYSbAX : rCUFLubf.getAlternativa()) {
				ANRKQ13C = conexao.prepareStatement(lJpFnfCb);
				ANRKQ13C.setString(1, SqyYSbAX.getTexto());
				ANRKQ13C.setBoolean(2, SqyYSbAX.getGabarito());
				ANRKQ13C.setInt(3, rCUFLubf.getIdQuestao());
				ANRKQ13C.executeUpdate();
				conexao.commit();
			}
		} catch (SQLException qpnxN9Zh) {
			conexao.rollback();
			throw qpnxN9Zh;
		}
	}

}