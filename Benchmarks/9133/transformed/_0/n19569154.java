class n19569154 {
	@Override
	public void incluir(Casa_festas srXRjrVE) throws Exception {
		Connection EWDC0UCp = criaConexao(false);
		String zNSbkr0Y = "insert into casa_festas ? as idlocal, ? as area, ? as realiza_cerimonia, ? as tipo_principal, ? as idgrupo;";
		String MGN47JZu = "SELECT MAX(idlocal) FROM Local";
		PreparedStatement QjcUdoYS = null;
		PreparedStatement ACwDM9du = null;
		ResultSet qI8Z7mUy = null;
		try {
			QjcUdoYS = EWDC0UCp.prepareStatement(zNSbkr0Y);
			ACwDM9du = EWDC0UCp.prepareStatement(MGN47JZu);
			qI8Z7mUy = ACwDM9du.executeQuery();
			QjcUdoYS.setInt(1, qI8Z7mUy.getInt("max"));
			QjcUdoYS.setDouble(2, srXRjrVE.getArea());
			QjcUdoYS.setBoolean(3, srXRjrVE.getRealizaCerimonias());
			QjcUdoYS.setBoolean(4, srXRjrVE.getTipoPrincipal());
			QjcUdoYS.setInt(5, srXRjrVE.getIdGrupo());
			int YY0lKCR4 = QjcUdoYS.executeUpdate();
			if (YY0lKCR4 == 0) {
				EWDC0UCp.rollback();
				throw new SQLException("Ocorreu um erro inesperado no momento de inserir dados de cliente no banco!");
			}
			EWDC0UCp.commit();
		} catch (SQLException f99l7usR) {
			EWDC0UCp.rollback();
			throw f99l7usR;
		} finally {
			try {
				QjcUdoYS.close();
				ACwDM9du.close();
				qI8Z7mUy.close();
				this.fechaConexao();
			} catch (SQLException nh06Yv9Y) {
				throw nh06Yv9Y;
			}
		}
	}

}