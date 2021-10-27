class n22366505 {
	@Override
	public void incluir(Igreja igreja) throws Exception {
		String sql = "insert into igreja ? as idlocal, ? as possui_salao;";
		Connection connection = criaConexao(false);
		PreparedStatement stmt = null;
		String sql2 = "SELECT MAX(idlocal) FROM Local";
		ResultSet rs = null;
		PreparedStatement stmt2 = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt2 = connection.prepareStatement(sql2);
			rs = stmt2.executeQuery();
			stmt.setInt(1, rs.getInt("max"));
			stmt.setBoolean(2, igreja.getPossuiSalao());
			int retorno = stmt.executeUpdate();
			if (retorno == 0) {
				connection.rollback();
				throw new SQLException("Ocorreu um erro inesperado no momento de inserir dados de cliente no banco!");
			}
			connection.commit();
		} catch (SQLException e) {
			connection.rollback();
			throw e;
		} finally {
			try {
				stmt.close();
				stmt2.close();
				rs.close();
				this.fechaConexao();
			} catch (SQLException e) {
				throw e;
			}
		}
	}

}