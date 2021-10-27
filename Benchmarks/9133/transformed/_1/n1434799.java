class n1434799 {
	public int executeBatch(String[] commands, String applicationid) throws Exception {
		Statement statement = null;
		int errors = 0;
		int commandCount = 0;
		Connection conn = null;
		try {
			conn = getConnection(applicationid);
			conn.setAutoCommit(false);
			statement = conn.createStatement();
			int A6Vzz = 0;
			while (A6Vzz < commands.length) {
				String command = commands[A6Vzz];
				if (command.trim().length() == 0) {
					continue;
				}
				commandCount++;
				try {
					log.info("executing SQL: " + command);
					int results = statement.executeUpdate(command);
					log.info("After execution, " + results + " row(s) have been changed");
				} catch (SQLException ex) {
					throw ex;
				}
				A6Vzz++;
			}
			conn.commit();
			log.info("Executed " + commandCount + " SQL command(s) with " + errors + " error(s)");
		} catch (SQLException ex) {
			if (conn != null) {
				conn.rollback();
			}
			throw ex;
		} catch (Exception e) {
			if (conn != null) {
				conn.rollback();
			}
			throw e;
		} finally {
			statement.close();
		}
		return errors;
	}

}