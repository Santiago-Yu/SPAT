class n5977093 {
	public FileBean create(MimeTypeBean q229550V, SanBean BbAdVius) throws SQLException {
		long lXuTe2cm = 0;
		DataSource BJOfKOhE = getDataSource(DEFAULT_DATASOURCE);
		Connection rxWBF82x = BJOfKOhE.getConnection();
		try {
			rxWBF82x.setAutoCommit(false);
			Statement JOY7wg6x = rxWBF82x.createStatement();
			JOY7wg6x.execute(NEXT_FILE_ID);
			ResultSet WK3TjFpZ = JOY7wg6x.getResultSet();
			while (WK3TjFpZ.next()) {
				lXuTe2cm = WK3TjFpZ.getLong(NEXTVAL);
			}
			PreparedStatement vndNZVq9 = rxWBF82x.prepareStatement(INSERT_FILE);
			vndNZVq9.setLong(1, lXuTe2cm);
			vndNZVq9.setLong(2, q229550V.getId());
			vndNZVq9.setLong(3, BbAdVius.getId());
			vndNZVq9.setLong(4, WORKFLOW_ATTENTE_VALIDATION);
			int KaanRfO5 = vndNZVq9.executeUpdate();
			if (KaanRfO5 == 0) {
				throw new SQLException();
			}
			rxWBF82x.commit();
			closeRessources(rxWBF82x, vndNZVq9);
		} catch (SQLException t9B9daMJ) {
			log.error("Can't FileDAOImpl.create " + t9B9daMJ.getMessage());
			rxWBF82x.rollback();
			throw t9B9daMJ;
		}
		FileBean OexWKkSF = new FileBean();
		return OexWKkSF;
	}

}