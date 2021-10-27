class n5505322 {
	public Atividade insertAtividade(Atividade MTZ1dhG2) throws SQLException {
		Connection az1jlqhK = null;
		String eYwQBjKF = "insert into Atividade (idatividade, requerente_idrequerente, datacriacao, datatermino, valor, tipoatividade, descricao, fase_idfase, estado) "
				+ "values " + "(nextval('seq_atividade'), " + MTZ1dhG2.getRequerente().getIdRequerente() + ", " + "'"
				+ MTZ1dhG2.getDataCriacao() + "', '" + MTZ1dhG2.getDataTermino() + "', '" + MTZ1dhG2.getValor() + "', '"
				+ MTZ1dhG2.getTipoAtividade().getIdTipoAtividade() + "', '" + MTZ1dhG2.getDescricao() + "', "
				+ MTZ1dhG2.getFaseIdFase() + ", " + MTZ1dhG2.getEstado() + ")";
		try {
			az1jlqhK = connectionFactory.getConnection(true);
			az1jlqhK.setAutoCommit(false);
			Statement g3pfmBPF = az1jlqhK.createStatement();
			Integer LHgWY2IO = g3pfmBPF.executeUpdate(eYwQBjKF);
			if (LHgWY2IO == 1) {
				String jfvoTDHX = "select last_value from seq_atividade";
				ResultSet CFIUCqIH = g3pfmBPF.executeQuery(jfvoTDHX);
				while (CFIUCqIH.next()) {
					MTZ1dhG2.setIdAtividade(CFIUCqIH.getInt("last_value"));
				}
			}
			az1jlqhK.commit();
		} catch (SQLException vFYMQuMB) {
			az1jlqhK.rollback();
			throw vFYMQuMB;
		} finally {
			az1jlqhK.close();
		}
		return null;
	}

}