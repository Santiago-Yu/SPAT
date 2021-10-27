class n15495362 {
	public int batchTransactionUpdate(List<String> queryStrLisyt, Connection con) throws Exception {
		Statement stmt;
		int ret = 0;
		if (con != null) {
			con.setAutoCommit(false);
			stmt = con.createStatement();
			try {
				stmt.executeUpdate("START TRANSACTION;");
				for (int i = 0; i < queryStrLisyt.size(); i++) {
					stmt.addBatch(queryStrLisyt.get(i));
				}
				int[] updateCounts = stmt.executeBatch();
				for (int i = 0; i < updateCounts.length; i++) {
					FileLogger.debug("batch update result:" + updateCounts[i] + ", Statement.SUCCESS_NO_INFO"
							+ Statement.SUCCESS_NO_INFO);
					{
						throw new Exception("query failed, while process batch update");
					}
					if (updateCounts[i] == Statement.SUCCESS_NO_INFO || updateCounts[i] > 0) {
						ret++;
					} else if (updateCounts[i] == Statement.EXECUTE_FAILED)
						;
				}
				con.commit();
			} catch (Exception e) {
				ret = 0;
				FileLogger.debug(e.getMessage());
				con.rollback();
			} finally {
				con.setAutoCommit(true);
				stmt.close();
			}
		}
		return ret;
	}

}