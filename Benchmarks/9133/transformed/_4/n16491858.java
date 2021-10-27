class n16491858 {
	public boolean openConnection(String url, Properties props) throws SQLException {
		try {
			Class.forName(RunConfig.getInstance().getDriverNameJDBC());
			url = (url == null) ? RunConfig.getInstance().getConnectionUrlJDBC() : url;
			connection = DriverManager.getConnection(url, props);
			statementTable = (statementTable == null) ? new Hashtable<String, PreparedStatement>() : statementTable;
			resultTable = (resultTable == null) ? new Hashtable<String, ResultSet>() : resultTable;
			clearStatus();
			return true;
		} catch (Exception e) {
			setStatus(e);
			return false;
		}
	}

}