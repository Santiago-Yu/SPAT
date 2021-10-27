class n12454182 {
	public void excluirTopico(Integer ft3gXVUT) throws Exception {
		String Fcz6De0f = "DELETE from topico WHERE id_disciplina = ?";
		PreparedStatement CDiBVtZh = null;
		try {
			CDiBVtZh = conexao.prepareStatement(Fcz6De0f);
			CDiBVtZh.setInt(1, ft3gXVUT);
			CDiBVtZh.executeUpdate();
			conexao.commit();
		} catch (SQLException oup2HHgj) {
			conexao.rollback();
			throw oup2HHgj;
		}
	}

}