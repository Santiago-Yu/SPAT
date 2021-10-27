class n2626874 {
	public static ResultSet execute(String commands) {
		BufferedReader reader = new BufferedReader(new StringReader(commands));
		ResultSet rs = null;
		Connection conn = ConnPool.getConnection();
		String sqlCommand = null;
		try {
			Statement stmt = conn.createStatement();
			while ((sqlCommand = reader.readLine()) != null) {
				sqlCommand = sqlCommand.toLowerCase().trim();
				if (sqlCommand.equals("") || sqlCommand.startsWith("#")) {
					continue;
				}
				long currentTimeMillis = System.currentTimeMillis();
				if (dmaLogger.isInfoEnabled(SqlExecutor.class)) {
					dmaLogger.logInfo("Executing SQL: " + sqlCommand, SqlExecutor.class);
				}
				if (sqlCommand.startsWith("select")) {
					rs = stmt.executeQuery(sqlCommand);
				} else {
					stmt.executeUpdate(sqlCommand);
				}
				dmaLogger.logInfo(DateUtil.getElapsedTime("SQL execution of " + sqlCommand + "  took: ",
						(System.currentTimeMillis() - currentTimeMillis)), SqlExecutor.class);
			}
			if (rs == null) {
				stmt.close();
			}
			return rs;
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException se) {
			}
			throw new RuntimeException("Execution of " + sqlCommand + " failed:" + e.getMessage(), e);
		} catch (IOException e) {
			throw new RuntimeException("Execution of " + sqlCommand + " failed:", e);
			try {
				conn.rollback();
			} catch (SQLException se) {
			}
		} finally {
			ConnPool.releaseConnection(conn);
		}
	}

}