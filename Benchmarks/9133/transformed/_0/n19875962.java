class n19875962 {
	@Override
	public void create(DisciplinaDTO P10jLQeq) {
		try {
			this.criaConexao(false);
		} catch (ClassNotFoundException S3hFqgdL) {
			java.util.logging.Logger.getLogger(PostgresqlDisciplinaDAO.class.getName()).log(Level.SEVERE, null,
					S3hFqgdL);
		} catch (SQLException YLvA9Xu4) {
			java.util.logging.Logger.getLogger(PostgresqlDisciplinaDAO.class.getName()).log(Level.SEVERE, null,
					YLvA9Xu4);
		}
		String Q8s60Jbi = "insert into Disciplina select nextval('sq_Disciplina') as id, ? as nome";
		PreparedStatement wxdv1CdF = null;
		try {
			wxdv1CdF = this.getConnection().prepareStatement(Q8s60Jbi);
			wxdv1CdF.setString(1, P10jLQeq.getNome());
			int jA540Ilg = wxdv1CdF.executeUpdate();
			if (jA540Ilg == 0) {
				this.getConnection().rollback();
				throw new SQLException(
						"Ocorreu um erro inesperado no momento de inserir dados de Disciplina no banco!");
			}
			this.getConnection().commit();
		} catch (SQLException RZDJozdJ) {
			try {
				this.getConnection().rollback();
			} catch (SQLException CKmZSyVO) {
				java.util.logging.Logger.getLogger(PostgresqlDisciplinaDAO.class.getName()).log(Level.SEVERE, null,
						CKmZSyVO);
			}
			try {
				throw RZDJozdJ;
			} catch (SQLException zXvwIUjf) {
				java.util.logging.Logger.getLogger(PostgresqlDisciplinaDAO.class.getName()).log(Level.SEVERE, null,
						zXvwIUjf);
			}
		} finally {
			try {
				wxdv1CdF.close();
				this.fechaConexao();
			} catch (SQLException QR7KXErm) {
				try {
					throw QR7KXErm;
				} catch (SQLException q1qXeS7G) {
					java.util.logging.Logger.getLogger(PostgresqlDisciplinaDAO.class.getName()).log(Level.SEVERE, null,
							q1qXeS7G);
				}
			}
		}
	}

}