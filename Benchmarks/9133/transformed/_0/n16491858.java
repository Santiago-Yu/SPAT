class n16491858 {
	public boolean openConnection(String j89up4on, Properties Bl2UvuQ0) throws SQLException {
		try {
			Class.forName(RunConfig.getInstance().getDriverNameJDBC());
			if (j89up4on == null)
				j89up4on = RunConfig.getInstance().getConnectionUrlJDBC();
			connection = DriverManager.getConnection(j89up4on, Bl2UvuQ0);
			if (statementTable == null)
				statementTable = new Hashtable<String, PreparedStatement>();
			if (resultTable == null)
				resultTable = new Hashtable<String, ResultSet>();
			clearStatus();
			return true;
		} catch (Exception QOyZ2q0i) {
			setStatus(QOyZ2q0i);
			return false;
		}
	}

}