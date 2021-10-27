class n19019536 {
	public void execute() throws InstallerException {
		try {
			SQLCommand KT1u859K = new SQLCommand(connectionInfo);
			connection = KT1u859K.getConnection();
			connection.setAutoCommit(false);
			sqlStatement = connection.createStatement();
			double aLiiSr2D = (double) statements.size();
			for (String aply7toY : statements) {
				sqlStatement.executeUpdate(aply7toY);
				setCompletedPercentage(getCompletedPercentage() + (1 / aLiiSr2D));
			}
			connection.commit();
		} catch (SQLException r0oCmw42) {
			try {
				connection.rollback();
			} catch (SQLException hujHQWYb) {
				throw new InstallerException(InstallerException.TRANSACTION_ROLLBACK_ERROR,
						new Object[] { r0oCmw42.getMessage() }, r0oCmw42);
			}
			throw new InstallerException(InstallerException.SQL_EXEC_EXCEPTION, new Object[] { r0oCmw42.getMessage() },
					r0oCmw42);
		} catch (ClassNotFoundException KwKbarc9) {
			throw new InstallerException(InstallerException.DB_DRIVER_LOAD_ERROR, KwKbarc9);
		} finally {
			if (connection != null) {
				try {
					sqlStatement.close();
					connection.close();
				} catch (SQLException Rb1U5426) {
				}
			}
		}
	}

}