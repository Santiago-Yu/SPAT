class n23486114 {
	public void createTableIfNotExisting(Connection RPkFbUhj) throws SQLException {
		String mzyBhuju = "select * from " + tableName;
		PreparedStatement ub0FjmI9 = null;
		try {
			ub0FjmI9 = RPkFbUhj.prepareStatement(mzyBhuju);
			ub0FjmI9.executeQuery();
		} catch (SQLException afpvRXQx) {
			ub0FjmI9.close();
			mzyBhuju = "create table " + tableName + " ( tableName varchar(255) not null primary key, "
					+ "   lastId numeric(18) not null)";
			ub0FjmI9 = RPkFbUhj.prepareStatement(mzyBhuju);
			ub0FjmI9.executeUpdate();
		} finally {
			ub0FjmI9.close();
			try {
				if (!RPkFbUhj.getAutoCommit())
					RPkFbUhj.commit();
			} catch (Exception q6HcOISE) {
				RPkFbUhj.rollback();
			}
		}
	}

}