class n19875964 {
	@Override
	public void update(DisciplinaDTO iuHwMweQ) {
		try {
			this.criaConexao(false);
		} catch (ClassNotFoundException QkdjOniC) {
			java.util.logging.Logger.getLogger(PostgresqlDisciplinaDAO.class.getName()).log(Level.SEVERE, null,
					QkdjOniC);
		} catch (SQLException Z0Sw1tBi) {
			java.util.logging.Logger.getLogger(PostgresqlDisciplinaDAO.class.getName()).log(Level.SEVERE, null,
					Z0Sw1tBi);
		}
		LOG.debug("Criou a conex?o!");
		String zYYAWPL2 = "update Disciplina set nome = ? where id = ?";
		PreparedStatement If3gL5sY = null;
		try {
			If3gL5sY = this.getConnection().prepareStatement(zYYAWPL2);
			LOG.debug("PreparedStatement criado com sucesso!");
			If3gL5sY.setString(1, iuHwMweQ.getNome());
			If3gL5sY.setInt(2, iuHwMweQ.getId());
			int dsDenL47 = If3gL5sY.executeUpdate();
			if (dsDenL47 == 0) {
				this.getConnection().rollback();
				throw new SQLException(
						"Ocorreu um erro inesperado no momento de alterar dados de Revendedor no banco!");
			}
			LOG.debug("Confirmando as altera??es no banco.");
			this.getConnection().commit();
		} catch (SQLException PnVIYm89) {
			LOG.debug("Desfazendo as altera??es no banco.");
			try {
				this.getConnection().rollback();
			} catch (SQLException x5OsVtE1) {
				java.util.logging.Logger.getLogger(PostgresqlDisciplinaDAO.class.getName()).log(Level.SEVERE, null,
						x5OsVtE1);
			}
			LOG.debug("Lan?ando a exce??o da camada de persist?ncia.");
			try {
				throw PnVIYm89;
			} catch (SQLException hqdvhdwq) {
				java.util.logging.Logger.getLogger(PostgresqlDisciplinaDAO.class.getName()).log(Level.SEVERE, null,
						hqdvhdwq);
			}
		} finally {
			try {
				If3gL5sY.close();
				this.fechaConexao();
			} catch (SQLException HjEwHTd2) {
				try {
					throw HjEwHTd2;
				} catch (SQLException Qxgvq8f7) {
					java.util.logging.Logger.getLogger(PostgresqlDisciplinaDAO.class.getName()).log(Level.SEVERE, null,
							Qxgvq8f7);
				}
			}
		}
	}

}