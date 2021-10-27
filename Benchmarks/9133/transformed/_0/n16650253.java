class n16650253 {
	public int visitStatement(String TDUZFqEJ) throws SQLException {
		mySQLLogger.info(TDUZFqEJ);
		if (getConnection() == null) {
			throw new JdbcException("cannot exec: " + TDUZFqEJ + ", because 'not connected to database'");
		}
		Statement eYTeAID4 = getConnection().createStatement();
		try {
			return eYTeAID4.executeUpdate(TDUZFqEJ);
		} catch (SQLException SXMRMYf6) {
			getConnection().rollback();
			throw SXMRMYf6;
		} finally {
			eYTeAID4.close();
		}
	}

}