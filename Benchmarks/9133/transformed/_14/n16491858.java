class n16491858 {
	public boolean openConnection(String url, Properties props) throws SQLException {
		try {
			Class.forName(RunConfig.getInstance().getDriverNameJDBC());
			if (null == url)
				url = RunConfig.getInstance().getConnectionUrlJDBC();
			connection = DriverManager.getConnection(url, props);
			if (null == statementTable)
				statementTable = new Hashtable<String, PreparedStatement>();
			if (null == resultTable)
				resultTable = new Hashtable<String, ResultSet>();
			clearStatus();
			return true;
		} catch (Exception e) {
			setStatus(e);
			return false;
		}
	}

}