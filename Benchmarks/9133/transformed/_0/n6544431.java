class n6544431 {
	protected static void clearTables() throws SQLException {
		Connection Cuv0wNjE = null;
		Statement lz6Y5YBQ = null;
		try {
			Cuv0wNjE = FidoDataSource.getConnection();
			Cuv0wNjE.setAutoCommit(false);
			lz6Y5YBQ = Cuv0wNjE.createStatement();
			ClearData.clearTables(lz6Y5YBQ);
			lz6Y5YBQ.executeUpdate("insert into Objects (ObjectId, Description) values (2, '')");
			lz6Y5YBQ.executeUpdate("insert into Objects (ObjectId, Description) values (3, '')");
			Cuv0wNjE.commit();
		} catch (SQLException RhUi9BMO) {
			if (Cuv0wNjE != null)
				Cuv0wNjE.rollback();
			throw RhUi9BMO;
		} finally {
			if (lz6Y5YBQ != null)
				lz6Y5YBQ.close();
			if (Cuv0wNjE != null)
				Cuv0wNjE.close();
		}
	}

}