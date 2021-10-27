class n22447616 {
	public Usuario insertUsuario(IUsuario Mv7LjPOp) throws SQLException {
		Connection oRZOceXr = null;
		String LyW102M9 = "insert into Usuario (idusuario, nome, email, telefone, cpf, login, senha) " + "values "
				+ "(nextval('seq_usuario'), '" + Mv7LjPOp.getNome() + "', '" + Mv7LjPOp.getEmail() + "', " + "'"
				+ Mv7LjPOp.getTelefone() + "', '" + Mv7LjPOp.getCpf() + "', '" + Mv7LjPOp.getLogin() + "', '"
				+ Mv7LjPOp.getSenha() + "')";
		try {
			oRZOceXr = connectionFactory.getConnection(true);
			oRZOceXr.setAutoCommit(false);
			Statement SIwxKill = oRZOceXr.createStatement();
			Integer dSHjMY2K = SIwxKill.executeUpdate(LyW102M9);
			if (dSHjMY2K == 1) {
				String n0HxO6Yq = "select last_value from seq_usuario";
				ResultSet GWQ4okUA = SIwxKill.executeQuery(n0HxO6Yq);
				while (GWQ4okUA.next()) {
					Mv7LjPOp.setIdUsuario(GWQ4okUA.getInt("last_value"));
				}
				if (Mv7LjPOp instanceof Requerente) {
					RequerenteDAO ZfjvKRxd = new RequerenteDAO();
					ZfjvKRxd.insertRequerente((Requerente) Mv7LjPOp, oRZOceXr);
				} else if (Mv7LjPOp instanceof RecursoHumano) {
					RecursoHumanoDAO AYJMDsxq = new RecursoHumanoDAO();
					AYJMDsxq.insertRecursoHumano((RecursoHumano) Mv7LjPOp, oRZOceXr);
				}
			}
			oRZOceXr.commit();
		} catch (SQLException vyIT6mjg) {
			oRZOceXr.rollback();
			throw vyIT6mjg;
		} finally {
			oRZOceXr.close();
		}
		return null;
	}

}