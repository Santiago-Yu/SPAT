class n2375094 {
	public boolean run() {
		Statement stmt = null;
		Connection conn = null;
		try {
			conn = getDataSource().getConnection();
			conn.setAutoCommit(false);
			conn.rollback();
			stmt = conn.createStatement();
			for (String task : tasks) {
				if (task.length() == 0)
					continue;
				LOGGER.info("Executing SQL migration: " + task);
				stmt.executeUpdate(task);
			}
			conn.commit();
		} catch (SQLException ex) {
			throw new SystemException("Cannot execute SQL migration", ex);
			try {
				conn.rollback();
			} catch (Throwable th) {
			}
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (Throwable th) {
				LOGGER.error(th);
			}
			try {
				if (stmt != null)
					conn.close();
			} catch (Throwable th) {
				LOGGER.error(th);
			}
		}
		return true;
	}

}