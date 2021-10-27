class n17826787 {
	public void updateDb(int scriptNumber) throws SQLException, IOException {
		String pathName = updatesPackage.replace(".", "/");
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		InputStream in = getClass().getClassLoader().getResourceAsStream(pathName + "/" + scriptNumber + ".sql");
		IOUtils.copy(in, out);
		String script = out.toString("UTF-8");
		String[] statements = script.split(";");
		for (String statement : statements) {
			getJdbcTemplate().execute(statement);
		}
	}

}