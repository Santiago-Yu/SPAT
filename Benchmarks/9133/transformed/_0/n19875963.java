class n19875963 {
	@Override
	public void remove(int wl23DN5h) {
		try {
			this.criaConexao(false);
		} catch (ClassNotFoundException NWxJb0ag) {
			java.util.logging.Logger.getLogger(PostgresqlDisciplinaDAO.class.getName()).log(Level.SEVERE, null,
					NWxJb0ag);
		} catch (SQLException WYfAxPuJ) {
			java.util.logging.Logger.getLogger(PostgresqlDisciplinaDAO.class.getName()).log(Level.SEVERE, null,
					WYfAxPuJ);
		}
		String Pe6CThxa = "delete from Disciplina where id = ?";
		PreparedStatement ZcBS0yKH = null;
		try {
			ZcBS0yKH = this.getConnection().prepareStatement(Pe6CThxa);
			ZcBS0yKH.setInt(1, wl23DN5h);
			int fndBkd9k = ZcBS0yKH.executeUpdate();
			if (fndBkd9k == 0) {
				this.getConnection().rollback();
				throw new SQLException(
						"Ocorreu um erro inesperado no momento de remover dados de Revendedor no banco!");
			}
			this.getConnection().commit();
		} catch (SQLException PmbQYIfQ) {
			try {
				this.getConnection().rollback();
			} catch (SQLException q6GPogJv) {
				java.util.logging.Logger.getLogger(PostgresqlDisciplinaDAO.class.getName()).log(Level.SEVERE, null,
						q6GPogJv);
			}
			try {
				throw PmbQYIfQ;
			} catch (SQLException w33scJGx) {
				java.util.logging.Logger.getLogger(PostgresqlDisciplinaDAO.class.getName()).log(Level.SEVERE, null,
						w33scJGx);
			}
		} finally {
			try {
				ZcBS0yKH.close();
				this.fechaConexao();
			} catch (SQLException Wom4rUcZ) {
				try {
					throw Wom4rUcZ;
				} catch (SQLException u55OE81y) {
					java.util.logging.Logger.getLogger(PostgresqlDisciplinaDAO.class.getName()).log(Level.SEVERE, null,
							u55OE81y);
				}
			}
		}
	}

}