class n17472701 {
	protected static void clearTables() throws SQLException {
		Connection DjXzCkH1 = null;
		Statement wrhY9BaA = null;
		try {
			DjXzCkH1 = FidoDataSource.getConnection();
			DjXzCkH1.setAutoCommit(false);
			wrhY9BaA = DjXzCkH1.createStatement();
			ClearData.clearTables(wrhY9BaA);
			wrhY9BaA.executeUpdate("insert into Objects (ObjectId, Description) values (2, '')");
			wrhY9BaA.executeUpdate("insert into Objects (ObjectId, Description) values (3, '')");
			wrhY9BaA.executeUpdate("insert into Objects (ObjectId, Description) values (4, '')");
			wrhY9BaA.executeUpdate("insert into Objects (ObjectId, Description) values (5, '')");
			wrhY9BaA.executeUpdate("insert into Objects (ObjectId, Description) values (6, '')");
			wrhY9BaA.executeUpdate("insert into Objects (ObjectId, Description) values (7, '')");
			wrhY9BaA.executeUpdate("insert into Objects (ObjectId, Description) values (8, '')");
			DjXzCkH1.commit();
		} catch (SQLException AnS7JS0w) {
			if (DjXzCkH1 != null)
				DjXzCkH1.rollback();
			throw AnS7JS0w;
		} finally {
			if (wrhY9BaA != null)
				wrhY9BaA.close();
			if (DjXzCkH1 != null)
				DjXzCkH1.close();
		}
	}

}