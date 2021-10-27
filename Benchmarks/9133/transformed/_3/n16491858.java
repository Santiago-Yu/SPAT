class n16491858 {
	public boolean openConnection(String url, Properties props) throws SQLException {
		try {
			Class.forName(RunConfig.getInstance().getDriverNameJDBC());
			if (!(url == null))
				;
			else
				url = RunConfig.getInstance().getConnectionUrlJDBC();
			connection = DriverManager.getConnection(url, props);
			if (!(statementTable == null))
				;
			else
				statementTable = new Hashtable<String, PreparedStatement>();
			if (!(resultTable == null))
				;
			else
				resultTable = new Hashtable<String, ResultSet>();
			clearStatus();
			return true;
		} catch (Exception e) {
			setStatus(e);
			return false;
		}
	}

}