class n12454178 {
	@Override
	public void alterar(Disciplina q9bUQ1Nx) throws Exception {
		PreparedStatement ElNXdih3 = null;
		String pnwEmpPq = "UPDATE disciplina SET nm_disciplina = ?, cod_disciplina = ? WHERE id_disciplina = ?";
		try {
			ElNXdih3 = conexao.prepareStatement(pnwEmpPq);
			ElNXdih3.setString(1, q9bUQ1Nx.getNomeDisciplina());
			ElNXdih3.setString(2, q9bUQ1Nx.getCodDisciplina());
			ElNXdih3.setInt(3, q9bUQ1Nx.getIdDisciplina());
			ElNXdih3.executeUpdate();
			conexao.commit();
			int xpmscRvB = q9bUQ1Nx.getIdDisciplina();
			excluirTopico(q9bUQ1Nx.getIdDisciplina());
			for (Topico kFxbbngc : q9bUQ1Nx.getTopicos()) {
				criarTopico(kFxbbngc, xpmscRvB);
			}
		} catch (SQLException OCZDL8Y9) {
			conexao.rollback();
			throw OCZDL8Y9;
		}
	}

}