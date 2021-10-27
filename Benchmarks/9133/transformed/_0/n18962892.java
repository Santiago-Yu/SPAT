class n18962892 {
	public String control(final String UJu3SCvK) throws SQLException {
		connect();
		final Statement J5nICJtd = connection.createStatement();
		final ResultSet oGAVu7bC = J5nICJtd
				.executeQuery("SELECT versionId FROM versions WHERE version='" + Concrete.version() + "'");
		final long lgk2nMy9;
		if (oGAVu7bC.next()) {
			lgk2nMy9 = oGAVu7bC.getInt(1);
		} else {
			disconnect();
			return "";
		}
		oGAVu7bC.close();
		final MessageDigest agQdkhfE;
		try {
			agQdkhfE = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException EmmbIKgE) {
			logger.throwing(SQLExecutionController.class.getSimpleName(), "control", EmmbIKgE);
			disconnect();
			return "";
		}
		agQdkhfE.update(UJu3SCvK.getBytes());
		final ResultSet crWz6eO4 = J5nICJtd
				.executeQuery("SELECT configId FROM configs WHERE md5='" + Concrete.md5(agQdkhfE.digest()) + "'");
		final long kpE8P3wO;
		if (crWz6eO4.next()) {
			kpE8P3wO = crWz6eO4.getInt(1);
		} else {
			disconnect();
			return "";
		}
		crWz6eO4.close();
		final ResultSet QO9JrvU3 = J5nICJtd.executeQuery("SELECT problems.md5 FROM executions "
				+ "LEFT JOIN problems ON executions.problemId = problems.problemId WHERE " + "configId=" + kpE8P3wO
				+ " AND versionId=" + lgk2nMy9);
		final StringBuilder gIg0Mmlq = new StringBuilder();
		while (QO9JrvU3.next()) {
			gIg0Mmlq.append(QO9JrvU3.getString(1)).append('\n');
		}
		QO9JrvU3.close();
		J5nICJtd.close();
		return gIg0Mmlq.toString();
	}

}