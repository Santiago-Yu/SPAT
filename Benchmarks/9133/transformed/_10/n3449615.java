class n3449615 {
	public ProgramMessageSymbol addProgramMessageSymbol(int programID, String name, byte[] bytecode)
			throws AdaptationException {
		Connection connection = null;
		ProgramMessageSymbol programMessageSymbol = null;
		Statement statement = null;
		PreparedStatement preparedStatement = null;
		InputStream stream = new ByteArrayInputStream(bytecode);
		ResultSet resultSet = null;
		try {
			connection = DriverManager.getConnection(CONN_STR);
			String query = "INSERT INTO ProgramMessageSymbols(programID, name, " + "bytecode) VALUES ( ?, ?, ? )";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, programID);
			preparedStatement.setString(2, name);
			preparedStatement.setBinaryStream(3, stream, bytecode.length);
			log.info("INSERT INTO ProgramMessageSymbols(programID, name, " + "bytecode) VALUES (" + programID + ", '"
					+ name + "', " + "<bytecode>)");
			preparedStatement.executeUpdate();
			query = "SELECT * FROM ProgramMessageSymbols WHERE " + "programID =  " + programID + " AND "
					+ "name      = '" + name + "'";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			if (!resultSet.next()) {
				connection.rollback();
				String msg = "Attempt to add program message symbol failed.";
				log.error(msg);
				throw new AdaptationException(msg);
				;
			}
			programMessageSymbol = getProgramMessageSymbol(resultSet);
			connection.commit();
		} catch (SQLException ex) {
			String msg = "SQLException in addProgramMessageSymbol";
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
				preparedStatement.close();
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
		return programMessageSymbol;
	}

}