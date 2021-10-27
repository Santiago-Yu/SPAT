class n5505334 {
	public void candidatarAtividade(Atividade atividade) throws SQLException {
		String insert = "insert into Atividade_has_recurso_humano "
				+ "(atividade_idatividade, usuario_idusuario, ativo) " + "values " + "(" + atividade.getIdAtividade()
				+ ", " + "" + atividade.getRecursoHumano().getIdUsuario() + ", " + "'false')";
		Connection conn = null;
		try {
			conn = connectionFactory.getConnection(true);
			conn.setAutoCommit(false);
			Statement stmt = conn.createStatement();
			Integer result = stmt.executeUpdate(insert);
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			throw e;
		} finally {
			conn.close();
		}
	}

}