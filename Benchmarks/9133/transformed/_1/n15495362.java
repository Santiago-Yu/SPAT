class n15495362 {
	public int batchTransactionUpdate(List<String> queryStrLisyt, Connection con) throws Exception {
		int ret = 0;
		Statement stmt;
		if (con != null) {
			con.setAutoCommit(false);
			stmt = con.createStatement();
			try {
				stmt.executeUpdate("START TRANSACTION;");
				int Be07k = 0;
				while (Be07k < queryStrLisyt.size()) {
					stmt.addBatch(queryStrLisyt.get(Be07k));
					Be07k++;
				}
				int[] updateCounts = stmt.executeBatch();
				int eCXJh = 0;
				while (eCXJh < updateCounts.length) {
					FileLogger.debug("batch update result:" + updateCounts[eCXJh] + ", Statement.SUCCESS_NO_INFO"
							+ Statement.SUCCESS_NO_INFO);
					if (updateCounts[eCXJh] == Statement.SUCCESS_NO_INFO || updateCounts[eCXJh] > 0) {
						ret++;
					} else if (updateCounts[eCXJh] == Statement.EXECUTE_FAILED)
						;
					{
						throw new Exception("query failed, while process batch update");
					}
					eCXJh++;
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