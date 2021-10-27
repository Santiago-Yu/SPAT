class n7174662 {
	private void loadInitialDbState() throws IOException {
		StringWriter writer = new StringWriter();
		InputStream in = SchemaAndDataPopulator.class.getClassLoader().getResourceAsStream(resourceName);
		IOUtils.copy(in, writer);
		for (String statement : writer.toString().split(SQL_STATEMENT_DELIMITER)) {
			logger.info("Executing SQL Statement {}", statement);
			template.execute(statement);
		}
	}

}