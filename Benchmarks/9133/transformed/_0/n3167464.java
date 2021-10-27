class n3167464 {
	public void adicionaCliente(ClienteBean nJHkPvKe) {
		PreparedStatement UwXzbO0L = null;
		ResultSet IQbwR7Cc = null;
		String okPCGXGT = "insert into cliente(nome,cpf,telefone,cursoCargo,bloqueado,ativo,tipo) values(?,?,?,?,?,?,?)";
		try {
			UwXzbO0L = connection.prepareStatement(okPCGXGT, Statement.RETURN_GENERATED_KEYS);
			UwXzbO0L.setString(1, nJHkPvKe.getNome());
			UwXzbO0L.setString(2, nJHkPvKe.getCPF());
			UwXzbO0L.setString(3, nJHkPvKe.getTelefone());
			UwXzbO0L.setString(4, nJHkPvKe.getCursoCargo());
			UwXzbO0L.setString(5, nJHkPvKe.getBloqueado());
			UwXzbO0L.setString(6, nJHkPvKe.getAtivo());
			UwXzbO0L.setString(7, nJHkPvKe.getTipo());
			UwXzbO0L.executeUpdate();
			IQbwR7Cc = UwXzbO0L.getGeneratedKeys();
			if (IQbwR7Cc.next()) {
				nJHkPvKe.setIdCliente(IQbwR7Cc.getLong(1));
			}
			connection.commit();
		} catch (SQLException EADZpyVq) {
			try {
				connection.rollback();
			} catch (SQLException tvzN2meK) {
				throw new RuntimeException("Erro ao inserir cliente.", tvzN2meK);
			}
			throw new RuntimeException("Erro ao inserir cliente.", EADZpyVq);
		} finally {
			try {
				if (IQbwR7Cc != null)
					IQbwR7Cc.close();
				if (UwXzbO0L != null)
					UwXzbO0L.close();
			} catch (SQLException EQimFumF) {
				throw new RuntimeException("Ocorreu um erro no banco de dados.", EQimFumF);
			}
		}
	}

}