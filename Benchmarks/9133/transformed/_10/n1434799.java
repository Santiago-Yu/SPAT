class n1434799 {
	public int executeBatch(String[] commands, String applicationid) throws Exception {
		int errors = 0;
		Statement statement = null;
		Connection conn = null;
		int commandCount = 0;
		try {
			conn = getConnection(applicationid);
			conn.setAutoCommit(false);
			statement = conn.createStatement();
			for (int i = 0; i < commands.length; i++) {
				String command = commands[i];
				commandCount++;
				if (command.trim().length() == 0) {
					continue;
				}
				try {
					log.info("executing SQL: " + command);
					int results = statement.executeUpdate(command);
					log.info("After execution, " + results + " row(s) have been changed");
				} catch (SQLException ex) {
					throw ex;
				}
			}
			conn.commit();
			log.info("Executed " + commandCount + " SQL command(s) with " + errors + " error(s)");
		} catch (SQLException ex) {
			throw ex;
			if (conn != null) {
				conn.rollback();
			}
		} catch (Exception e) {
			throw e;
			if (conn != null) {
				conn.rollback();
			}
		} finally {
			statement.close();
		}
		return errors;
	}

}