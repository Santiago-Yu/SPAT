class n1543361 {
	public ProgramSymbol createNewProgramSymbol(int programID, String module, String symbol, int address, int size)
			throws AdaptationException {
		Connection connection = null;
		ProgramSymbol programSymbol = null;
		ResultSet resultSet = null;
		Statement statement = null;
		try {
			connection = DriverManager.getConnection(CONN_STR);
			String query = "INSERT INTO ProgramSymbols " + "(programID, module, symbol, address, size)" + " VALUES ("
					+ programID + ", '" + module + "',  '" + symbol + "', " + address + ", " + size + ")";
			statement = connection.createStatement();
			statement.executeUpdate(query);
			query = "SELECT * FROM ProgramSymbols WHERE  " + "programID =  " + programID + "  AND " + "module    = '"
					+ module + "' AND " + "symbol    = '" + symbol + "'";
			resultSet = statement.executeQuery(query);
			if (!resultSet.next()) {
				connection.rollback();
				String msg = "Attempt to create program symbol failed.";
				log.error(msg);
				throw new AdaptationException(msg);
			}
			programSymbol = getProgramSymbol(resultSet);
			connection.commit();
		} catch (SQLException ex) {
			String msg = "SQLException in createNewProgramSymbol";
			try {
				connection.rollback();
			} catch (Exception e) {
			}
			log.error(msg, ex);
			throw new AdaptationException(msg, ex);
		} finally {
			try {
				resultSet.close();
			} catch (Exception ex) {
			}
			try {
				statement.close();
			} catch (Exception ex) {
			}
			try {
				connection.close();
			} catch (Exception ex) {
			}
		}
		return programSymbol;
	}

}