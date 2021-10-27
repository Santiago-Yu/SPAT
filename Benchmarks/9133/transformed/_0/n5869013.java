class n5869013 {
	public Leilao insertLeilao(Leilao T3X3JQir) throws SQLException {
		Connection x7Tylv5N = null;
		String UnEfSmAB = "insert into Leilao (idleilao, atividade_idatividade, datainicio, datafim) " + "values "
				+ "(nextval('seq_leilao'), " + T3X3JQir.getAtividade().getIdAtividade() + ", '"
				+ T3X3JQir.getDataInicio() + "', '" + T3X3JQir.getDataFim() + "')";
		try {
			x7Tylv5N = connectionFactory.getConnection(true);
			x7Tylv5N.setAutoCommit(false);
			Statement eik1R9y3 = x7Tylv5N.createStatement();
			Integer fBo5RsUn = eik1R9y3.executeUpdate(UnEfSmAB);
			if (fBo5RsUn == 1) {
				String eF86LVPi = "select last_value from seq_leilao";
				ResultSet YGb3mTGE = eik1R9y3.executeQuery(eF86LVPi);
				while (YGb3mTGE.next()) {
					T3X3JQir.setIdLeilao(YGb3mTGE.getInt("last_value"));
				}
			}
			x7Tylv5N.commit();
		} catch (SQLException TXjddziq) {
			x7Tylv5N.rollback();
			throw TXjddziq;
		} finally {
			x7Tylv5N.close();
		}
		return null;
	}

}