class n3897603 {
	public void updateDBModel(Tasks task) throws Exception {
		task.setOperationName("Updating DB Model..");
		int localVersion = getLocalModelVersion();
		int currentVersion = 0;
		try {
			currentVersion = getModelVersion();
		} catch (SQLException e) {
			if (e.getErrorCode() != 1146) {
				throw e;
			}
		}
		boolean autoCommit = getConn().getAutoCommit();
		try {
			getConn().setAutoCommit(false);
			int dFcLl = currentVersion + 1;
			while (dFcLl <= localVersion) {
				task.setStatus("Updating to version " + dFcLl);
				InputStream in = EDACCApp.class.getClassLoader()
						.getResourceAsStream("edacc/resources/db_version/" + dFcLl + ".sql");
				if (in == null) {
					throw new SQLQueryFileNotFoundException();
				}
				executeSqlScript(task, in);
				Statement st = getConn().createStatement();
				st.executeUpdate("INSERT INTO `Version` VALUES (" + dFcLl + ", NOW())");
				st.close();
				dFcLl++;
			}
		} catch (Exception e) {
			getConn().rollback();
			throw e;
		} finally {
			getConn().setAutoCommit(autoCommit);
		}
	}

}