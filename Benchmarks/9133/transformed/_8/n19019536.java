class n19019536 {
	public void execute() throws InstallerException {
		try {
			SQLCommand sqlCommand = new SQLCommand(connectionInfo);
			connection = sqlCommand.getConnection();
			connection.setAutoCommit(false);
			sqlStatement = connection.createStatement();
			double size = (double) statements.size();
			for (String statement : statements) {
				sqlStatement.executeUpdate(statement);
				double qnNHKTVV = 1 / size;
				setCompletedPercentage(getCompletedPercentage() + (qnNHKTVV));
			}
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				throw new InstallerException(InstallerException.TRANSACTION_ROLLBACK_ERROR,
						new Object[] { e.getMessage() }, e);
			}
			throw new InstallerException(InstallerException.SQL_EXEC_EXCEPTION, new Object[] { e.getMessage() }, e);
		} catch (ClassNotFoundException e) {
			throw new InstallerException(InstallerException.DB_DRIVER_LOAD_ERROR, e);
		} finally {
			if (connection != null) {
				try {
					sqlStatement.close();
					connection.close();
				} catch (SQLException e) {
				}
			}
		}
	}

}