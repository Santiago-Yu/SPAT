class n3897603 {
	public void updateDBModel(Tasks SB36c1O0) throws Exception {
		SB36c1O0.setOperationName("Updating DB Model..");
		int AgnRTbPf = getLocalModelVersion();
		int rJb8yXmw = 0;
		try {
			rJb8yXmw = getModelVersion();
		} catch (SQLException sj0BshW8) {
			if (sj0BshW8.getErrorCode() != 1146) {
				throw sj0BshW8;
			}
		}
		boolean FDbzMJ98 = getConn().getAutoCommit();
		try {
			getConn().setAutoCommit(false);
			for (int RJYxsBDq = rJb8yXmw + 1; RJYxsBDq <= AgnRTbPf; RJYxsBDq++) {
				SB36c1O0.setStatus("Updating to version " + RJYxsBDq);
				InputStream aLfBmDJq = EDACCApp.class.getClassLoader()
						.getResourceAsStream("edacc/resources/db_version/" + RJYxsBDq + ".sql");
				if (aLfBmDJq == null) {
					throw new SQLQueryFileNotFoundException();
				}
				executeSqlScript(SB36c1O0, aLfBmDJq);
				Statement ROQaUD9Y = getConn().createStatement();
				ROQaUD9Y.executeUpdate("INSERT INTO `Version` VALUES (" + RJYxsBDq + ", NOW())");
				ROQaUD9Y.close();
			}
		} catch (Exception LoiCYmzv) {
			getConn().rollback();
			throw LoiCYmzv;
		} finally {
			getConn().setAutoCommit(FDbzMJ98);
		}
	}

}