class n22275470 {
	public static boolean insert(final Funcionario objFuncionario) {
		final Connection c = DBConnection.getConnection();
		int result = 0;
		if (c == null) {
			return false;
		}
		PreparedStatement pst = null;
		try {
			c.setAutoCommit(false);
			final String sql = "insert into funcionario " + "(nome, cpf, telefone, email, senha, login, id_cargo)"
					+ " values (?, ?, ?, ?, ?, ?, ?)";
			pst = c.prepareStatement(sql);
			pst.setString(1, objFuncionario.getNome());
			pst.setString(2, objFuncionario.getCpf());
			pst.setString(3, objFuncionario.getTelefone());
			pst.setString(4, objFuncionario.getEmail());
			pst.setString(5, objFuncionario.getSenha());
			pst.setString(6, objFuncionario.getLogin());
			pst.setLong(7, (objFuncionario.getCargo()).getCodigo());
			result = pst.executeUpdate();
			c.commit();
		} catch (final SQLException e) {
			try {
				c.rollback();
			} catch (final SQLException e1) {
				System.out.println("[FuncionarioDAO.insert] Erro ao inserir -> " + e1.getMessage());
			}
			System.out.println("[FuncionarioDAO.insert] Erro ao inserir -> " + e.getMessage());
		} finally {
			DBConnection.closePreparedStatement(pst);
			DBConnection.closeConnection(c);
		}
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

}