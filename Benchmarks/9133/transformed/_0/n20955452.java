class n20955452 {
	private void criarQuestaoMultiplaEscolha(QuestaoMultiplaEscolha prOF9l7o) throws SQLException {
		PreparedStatement EXneNABK = null;
		String yDI8ILDi = "INSERT INTO multipla_escolha (id_questao, texto, gabarito) VALUES (?,?,?)";
		try {
			for (Alternativa CHXtgInp : prOF9l7o.getAlternativa()) {
				EXneNABK = conexao.prepareStatement(yDI8ILDi);
				EXneNABK.setInt(1, prOF9l7o.getIdQuestao());
				EXneNABK.setString(2, CHXtgInp.getTexto());
				EXneNABK.setBoolean(3, CHXtgInp.getGabarito());
				EXneNABK.executeUpdate();
				conexao.commit();
			}
		} catch (SQLException WywirJVr) {
			conexao.rollback();
			throw WywirJVr;
		}
	}

}