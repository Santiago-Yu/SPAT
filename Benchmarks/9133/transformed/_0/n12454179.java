class n12454179 {
	@Override
	public void excluir(Disciplina wdJOx3jz) throws Exception {
		PreparedStatement Bt0XnnFW = null;
		String gqtdiJdC = "DELETE from disciplina where id_disciplina = ?";
		try {
			Bt0XnnFW = conexao.prepareStatement(gqtdiJdC);
			Bt0XnnFW.setInt(1, wdJOx3jz.getIdDisciplina());
			Bt0XnnFW.executeUpdate();
			conexao.commit();
		} catch (SQLException wLoHehKS) {
			conexao.rollback();
			throw wLoHehKS;
		} finally {
			try {
				Bt0XnnFW.close();
				conexao.close();
			} catch (SQLException cYaM5UZu) {
				throw cYaM5UZu;
			}
		}
	}

}