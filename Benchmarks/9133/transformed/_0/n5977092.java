class n5977092 {
	public long create(long TvUGVDjo, long aiilHAxh) throws SQLException {
		long CDTJVIZf = 0;
		DataSource uHH7fcAd = getDataSource(DEFAULT_DATASOURCE);
		Connection kqU0asAg = uHH7fcAd.getConnection();
		try {
			kqU0asAg.setAutoCommit(false);
			Statement FKbb9fnw = kqU0asAg.createStatement();
			FKbb9fnw.execute(NEXT_FILE_ID);
			ResultSet GYujQinD = FKbb9fnw.getResultSet();
			while (GYujQinD.next()) {
				CDTJVIZf = GYujQinD.getLong(NEXTVAL);
			}
			PreparedStatement TpjWkGTU = kqU0asAg.prepareStatement(INSERT_FILE);
			TpjWkGTU.setLong(1, CDTJVIZf);
			TpjWkGTU.setLong(2, TvUGVDjo);
			TpjWkGTU.setLong(3, aiilHAxh);
			TpjWkGTU.setLong(4, WORKFLOW_ATTENTE_VALIDATION);
			int NVKkBJ7Z = TpjWkGTU.executeUpdate();
			if (NVKkBJ7Z == 0) {
				throw new SQLException();
			}
			kqU0asAg.commit();
			closeRessources(kqU0asAg, TpjWkGTU);
		} catch (SQLException tYP437c9) {
			log.error("Can't FileDAOImpl.create " + tYP437c9.getMessage());
			kqU0asAg.rollback();
			throw tYP437c9;
		}
		return CDTJVIZf;
	}

}