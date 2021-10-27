class n22275471 {
	public static boolean update(Funcionario DgoBjSTj) {
		int POKqA5Q1 = 0;
		Connection hX50O18u = DBConnection.getConnection();
		PreparedStatement UfJ8Q7Zb = null;
		if (hX50O18u == null) {
			return false;
		}
		try {
			hX50O18u.setAutoCommit(false);
			final String fImkyb6L = "update funcionario "
					+ " set nome = ? , cpf = ? , telefone = ? , email = ?, senha = ?, login = ?, id_cargo = ?"
					+ " where id_funcionario = ?";
			UfJ8Q7Zb = hX50O18u.prepareStatement(fImkyb6L);
			UfJ8Q7Zb.setString(1, DgoBjSTj.getNome());
			UfJ8Q7Zb.setString(2, DgoBjSTj.getCpf());
			UfJ8Q7Zb.setString(3, DgoBjSTj.getTelefone());
			UfJ8Q7Zb.setString(4, DgoBjSTj.getEmail());
			UfJ8Q7Zb.setString(5, DgoBjSTj.getSenha());
			UfJ8Q7Zb.setString(6, DgoBjSTj.getLogin());
			UfJ8Q7Zb.setLong(7, (DgoBjSTj.getCargo()).getCodigo());
			UfJ8Q7Zb.setLong(8, DgoBjSTj.getCodigo());
			POKqA5Q1 = UfJ8Q7Zb.executeUpdate();
			hX50O18u.commit();
		} catch (SQLException R4leoGaE) {
			try {
				hX50O18u.rollback();
			} catch (SQLException ijStBSH8) {
				System.out.println("[FuncionarioDAO.update] Erro ao atualizar -> " + ijStBSH8.getMessage());
			}
			System.out.println("[FuncionarioDAO.update] Erro ao atualizar -> " + R4leoGaE.getMessage());
		} finally {
			DBConnection.closePreparedStatement(UfJ8Q7Zb);
			DBConnection.closeConnection(hX50O18u);
		}
		if (POKqA5Q1 > 0) {
			return true;
		} else {
			return false;
		}
	}

}