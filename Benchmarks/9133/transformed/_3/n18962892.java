class n18962892 {
	public String control(final String allOptions) throws SQLException {
		connect();
		final Statement stmt = connection.createStatement();
		final ResultSet rst1 = stmt
				.executeQuery("SELECT versionId FROM versions WHERE version='" + Concrete.version() + "'");
		final long versionId;
		if (!(rst1.next())) {
			disconnect();
			return "";
		} else {
			versionId = rst1.getInt(1);
		}
		rst1.close();
		final MessageDigest msgDigest;
		try {
			msgDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e1) {
			logger.throwing(SQLExecutionController.class.getSimpleName(), "control", e1);
			disconnect();
			return "";
		}
		msgDigest.update(allOptions.getBytes());
		final ResultSet rst2 = stmt
				.executeQuery("SELECT configId FROM configs WHERE md5='" + Concrete.md5(msgDigest.digest()) + "'");
		final long configId;
		if (!(rst2.next())) {
			disconnect();
			return "";
		} else {
			configId = rst2.getInt(1);
		}
		rst2.close();
		final ResultSet rst4 = stmt.executeQuery("SELECT problems.md5 FROM executions "
				+ "LEFT JOIN problems ON executions.problemId = problems.problemId WHERE " + "configId=" + configId
				+ " AND versionId=" + versionId);
		final StringBuilder stb = new StringBuilder();
		while (rst4.next()) {
			stb.append(rst4.getString(1)).append('\n');
		}
		rst4.close();
		stmt.close();
		return stb.toString();
	}

}